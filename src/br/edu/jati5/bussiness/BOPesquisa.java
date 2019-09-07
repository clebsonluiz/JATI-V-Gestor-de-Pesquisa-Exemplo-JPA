package br.edu.jati5.bussiness;

import java.util.List;

import br.edu.jati5.dao.DAOPesquisa;
import br.edu.jati5.entidade.Pesquisa;
import br.edu.jati5.entidade.Usuario;
import br.edu.jati5.exceptions.BOException;
import br.edu.jati5.exceptions.DAOException;
import br.edu.jati5.util.DateUtil;

public class BOPesquisa extends BO<Pesquisa>{

	public BOPesquisa() {
		super(new DAOPesquisa(), Pesquisa.class);
	}
	
	public List<Pesquisa> getPesquisasUsuario(Usuario usuario) throws BOException, DAOException
	{
		if(usuario == null || usuario.getId() <= 0) throw new BOException("Erro ao consultar pesquisas");
		return ((DAOPesquisa)this.daoT).buscaNamedQueryGenericaListFK(Pesquisa.class, "Pesquisa.usuario", "usuario", usuario);
	}
	
	public List<Pesquisa> getPesquisasUsuarioEspecifica(String pesquisa, int id_usuario) throws BOException, DAOException
	{
		if(id_usuario <= 0) throw new BOException("Erro ao consultar pesquisas");
		/**
		 * Para acessar a FK de um objeto em HQL o acesso é pelo atributo da FK na forma 
		 * de objeto, tipo, select p from Pessoa p where p.endereco_fk = 1,
		 * em HQL fica select p from Pessoa p where p.endereco.id = 1
		 * 
		 */
		return ((DAOPesquisa)this.daoT).buscaListaHQLGenerica(Pesquisa.class,
		"select p from Pesquisa as p where p.ativado = true and p.usuario.id = " + id_usuario + " and "
				+ "lower(p.titulo) like lower('%" + pesquisa + "%')");
	}

	public double andamento_pesquisa(Pesquisa pesquisa) throws DAOException
	{
		return ((DAOPesquisa)this.daoT).andamento_pesquisa(DateUtil.getDateSQL(pesquisa.getDataInicio()), DateUtil.getDateSQL(pesquisa.getDataInicio()));
	}
	
}
