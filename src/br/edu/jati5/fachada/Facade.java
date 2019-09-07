package br.edu.jati5.fachada;

import br.edu.jati5.bussiness.BODado;
import br.edu.jati5.bussiness.BOEstrutura;
import br.edu.jati5.bussiness.BOPesquisa;
import br.edu.jati5.bussiness.BOUsuario;
import br.edu.jati5.entidade.Dado;
import br.edu.jati5.entidade.Entidade;
import br.edu.jati5.entidade.EstruturaPesquisa;
import br.edu.jati5.entidade.Pesquisa;
import br.edu.jati5.entidade.Usuario;
import br.edu.jati5.exceptions.ValidacaoException;

public class Facade {

	private static Facade instance;
	
	public static Facade getInstance()
	{
		if(instance == null)
			instance = new Facade();
		return instance;
	}
	
	private final BOUsuario boUsuario;
	private final BOPesquisa boPesquisa;
	private final BOEstrutura boEstrutura;
	private final BODado boDado;
	
	private Facade() 
	{
		boUsuario = new BOUsuario();
		boPesquisa = new BOPesquisa();
		boEstrutura = new BOEstrutura();
		boDado = new BODado();
	}

	public <T extends Entidade> void inserir(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.inserir((Usuario)entidade);
		}
		else if(entidade instanceof Pesquisa)
		{
			boPesquisa.inserir((Pesquisa)entidade);
		}
		else if(entidade instanceof EstruturaPesquisa)
		{
			boEstrutura.inserir((EstruturaPesquisa)entidade);
		}
		else if(entidade instanceof Dado)
		{
			boDado.inserir((Dado)entidade);
		}
	}
	
	public <T extends Entidade> void atualizar(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.atualizar((Usuario)entidade);
		}
		else if(entidade instanceof Pesquisa)
		{
			boPesquisa.atualizar((Pesquisa)entidade);
		}
		else if(entidade instanceof EstruturaPesquisa)
		{
			boEstrutura.atualizar((EstruturaPesquisa)entidade);
		}
		else if(entidade instanceof Dado)
		{
			boDado.atualizar((Dado)entidade);
		}
	}
	
	public <T extends Entidade> Entidade buscar(Class<T> classe, int id) throws ValidacaoException
	{
		if(classe.getSimpleName().equals(Usuario.class.getSimpleName()))
		{
			return boUsuario.buscar(id);
		}
		else if(classe.getSimpleName().equals(Pesquisa.class.getSimpleName()))
		{
			return boPesquisa.buscar(id);
		}
		else if(classe.getSimpleName().equals(EstruturaPesquisa.class.getSimpleName()))
		{
			return boEstrutura.buscar(id);
		}
		else if(classe.getSimpleName().equals(Dado.class.getSimpleName()))
		{
			return boDado.buscar(id);
		}
		return null;
	}
	
	public <T extends Entidade> void remover(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.remover((Usuario)entidade);
		}
		else if(entidade instanceof Pesquisa)
		{
			boPesquisa.remover((Pesquisa)entidade);
		}
		else if(entidade instanceof EstruturaPesquisa)
		{
			boEstrutura.remover((EstruturaPesquisa)entidade);
		}
		else if(entidade instanceof Dado)
		{
			boDado.remover((Dado)entidade);
		}
	}
	
	public <T extends Entidade> void deletar(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.deletar((Usuario)entidade);
		}
		else if(entidade instanceof Pesquisa)
		{
			boPesquisa.deletar((Pesquisa)entidade);
		}
		else if(entidade instanceof EstruturaPesquisa)
		{
			boEstrutura.deletar((EstruturaPesquisa)entidade);
		}
		else if(entidade instanceof Dado)
		{
			boDado.deletar((Dado)entidade);
		}
	}
	
	
	public BOUsuario getBoUsuario() {return boUsuario;}
	public BOPesquisa getBoPesquisa() {return boPesquisa;}
	public BOEstrutura getBoEstrutura() {return boEstrutura;}
	public BODado getBoDado() {return boDado;}
	
}
