package br.edu.jati5.tabela;

import br.edu.jati5.entidade.Dado;

public class TDado extends TGenerica<Dado>{

	private static final long serialVersionUID = 1L;

	public TDado() {
		super(new String[] {"", "", "", ""});
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 3;
	}
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		
		switch (columnIndex) 
		{
			case 0 :
				getList().get(rowIndex).setCol_1_nome_familia((String)value);
				fireTableCellUpdated(rowIndex, columnIndex);
				fireTableDataChanged();
				break;
			case 1 :
				getList().get(rowIndex).setCol_2_nome((String)value);
				fireTableCellUpdated(rowIndex, columnIndex);
				fireTableDataChanged();
				break;
			case 2 :
				getList().get(rowIndex).setCol_3_valor((String)value);
				fireTableCellUpdated(rowIndex, columnIndex);
				fireTableDataChanged();
				break;
		}
		setSelectedItem(getList().get(rowIndex));
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna)
		{
			case 0:
				return getList().get(linha).getCol_1_nome_familia();
			case 1:
				return getList().get(linha).getCol_2_nome();
			case 2:
				return getList().get(linha).getCol_3_valor();
			case 3:
				return getBt_excluir();
		}
		return null;
	}

}
