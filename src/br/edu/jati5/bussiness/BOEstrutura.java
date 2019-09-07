package br.edu.jati5.bussiness;

import java.util.List;

import br.edu.jati5.dao.DAOEstruturaPesquisa;
import br.edu.jati5.entidade.EstruturaPesquisa;
import br.edu.jati5.entidade.Pesquisa;
import br.edu.jati5.exceptions.BOException;
import br.edu.jati5.exceptions.DAOException;

public class BOEstrutura extends BO<EstruturaPesquisa>{

	public BOEstrutura() {
		super(new DAOEstruturaPesquisa(), EstruturaPesquisa.class);
	}

	public List<EstruturaPesquisa> getEstruturasPesquisa(Pesquisa pesquisa) throws BOException, DAOException
	{
		if(pesquisa == null || pesquisa.getId() <= 0) throw new BOException("Erro ao consultar estruturas");
		return ((DAOEstruturaPesquisa)this.daoT).buscaNamedQueryGenericaListFK(EstruturaPesquisa.class, "Estrutura.pesquisa", "pesquisa", pesquisa);
	}
	
	public List<EstruturaPesquisa> getEstruturasPesquisaEspecifica(String estrutura, int id_pesquisa) throws BOException, DAOException
	{
		if(id_pesquisa <= 0) throw new BOException("Erro ao consultar estruturas");
		/**
		 * Para acessar a FK de um objeto em HQL o acesso é pelo atributo da FK na forma 
		 * de objeto, tipo, select p from Pessoa p where p.endereco_fk = 1,
		 * em HQL fica select p from Pessoa p where p.endereco.id = 1
		 * 
		 */
		return ((DAOEstruturaPesquisa)this.daoT).buscaListaHQLGenerica(EstruturaPesquisa.class,
		"select e from EstruturaPesquisa as e where e.ativado = true and e.pesquisa.id = " + id_pesquisa + " and "
			+ "lower(e.titulo_estrutura) like lower('%" + estrutura + "%') "
			+ "AND "
			+ "lower(e.col_1_nome_familia) like lower('%" + estrutura + "%') "
			+ "AND "
			+ "lower(e.col_2_nome) like lower('%" + estrutura + "%') "
			+ "AND "
			+ "lower(e.col_3_valor) like lower('%" + estrutura + "%') "
			+ "AND "
			+ "lower(e.categoria_dados) like lower('%" + estrutura + "%') ");
	}
}
