package br.edu.jati5.tabela;

import br.edu.jati5.entidade.Pesquisa;

public class TPesquisa extends TGenerica<Pesquisa>{

	private static final long serialVersionUID = 1L;

	public TPesquisa() {
		super(new String[] {"Nome", "Data Inicial", "Data Final", "", ""});
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		switch (coluna)
		{
			case 0:
				return getList().get(linha).getTitulo();
			case 1:
				return getList().get(linha).getDataInicio().toString();
			case 2:
				return getList().get(linha).getDataFim().toString();
			case 3:
				return getBt_ver();
			case 4:
				return getBt_excluir();
		}
		return null;
	}

}
