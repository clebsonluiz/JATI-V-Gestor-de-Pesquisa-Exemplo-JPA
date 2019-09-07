package br.edu.jati5.tabela;

import br.edu.jati5.entidade.EstruturaPesquisa;

public class TEstrutura extends TGenerica<EstruturaPesquisa>{

	private static final long serialVersionUID = 1L;

	public TEstrutura() {
		super(new String[] {"Titulo", "", ""});
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		switch (coluna)
		{
			case 0:
				return getList().get(linha).getTitulo_estrutura();
			case 1:
				return getBt_ver();
			case 2:
				return getBt_excluir();
		}
		return null;
	}


}
