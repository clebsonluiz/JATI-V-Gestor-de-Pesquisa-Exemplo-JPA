package br.edu.jati5.tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.jati5.entidade.Entidade;
import br.edu.jati5.view.Botao;


public abstract class TGenerica<T extends Entidade> extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private Botao bt_ver = new Botao("Ver");
	private Botao bt_excluir = new Botao("X");
	
	private List<T> t;
	private String colunas[];
	
	private T item;
	
	public TGenerica(String colunas[]) {
		super();
		this.t = new ArrayList<T>();
		this.colunas = colunas;
	}
	
	public void addAll(List<T> t) {
		if(t != null)
		{
			this.t.clear();
			this.t.addAll(t);
			fireTableDataChanged();
		}
	}
	
	public void remover(int index) {
		this.t.remove(index);
		fireTableDataChanged();
	}
	
	public T getValor(int linha) {
		return t.get(linha);
	}
	
	public boolean addValor(T t) {
		boolean b = this.t.add(t);
		if(b)
			fireTableRowsInserted(this.t.size() - 1, this.t.size() - 1);
		return b;
	}
	
	public List<T> getList() {
		return t;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
		this.fireTableStructureChanged();
		this.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {return colunas.length;}
	
	@Override
	public int getRowCount() {return t.size();}
	
	abstract public Object getValueAt(int linha, int coluna);

	public Botao getBt_ver() {return bt_ver;}
	public Botao getBt_excluir() {return bt_excluir;}

	public T getSelectedItem() {
		return item;
	}

	public void setSelectedItem(T item) {
		this.item = item;
	}
}