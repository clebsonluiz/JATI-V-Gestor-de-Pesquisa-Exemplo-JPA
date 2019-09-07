package br.edu.jati5.tabela;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import br.edu.jati5.view.Botao;

public class CellRenderer extends DefaultTableCellRenderer{
	
	private static final long serialVersionUID = 1L;
	
	public Component getTableCellRendererComponent(
			JTable table,
			Object value,
			boolean isSelected,
			boolean hasFocus,
			int row,
			int column) {
		
		if(value instanceof Botao) {
			Botao btn = (Botao) value;
			if(btn.getText().equalsIgnoreCase("ver"))
			{
				if(hasFocus) 
				{
					btn.setBackground(Botao.VERDE);
					btn.setForeground(Color.white);
					btn.setFont(Botao.FONT_CLICK);
				}
				else if(isSelected)
				{
					btn.setBackground(Botao.MARROM);
					btn.setForeground(Color.white);
					btn.setFont(Botao.FONT_PADRAO);
				}
				else
				{
					btn.setBackground(Botao.VERDE_ESCURO);
					btn.setForeground(Color.white);
					btn.setFont(Botao.FONT_PADRAO);
				}
				return btn;
			}
			
			else if(btn.getText().equalsIgnoreCase("x"))
			{
				if(hasFocus) 
				{
					btn.setBackground(Botao.VERMELHO);
					btn.setForeground(Color.white);
					btn.setFont(Botao.FONT_CLICK);
				}
				else if(isSelected)
				{
					btn.setBackground(Botao.VERMELHO_ESCURO);
					btn.setForeground(Color.white);
					btn.setFont(Botao.FONT_PADRAO);
				}
				else
				{
					btn.setBackground(Botao.VERMELHO_CLARO);
					btn.setForeground(Color.white);
					btn.setFont(Botao.FONT_PADRAO);
				}
				return btn;
			}
			
		}
		return super.getTableCellRendererComponent(
				table,
				value,
				isSelected,
				hasFocus,
				row,
				column);
		
	}
	
}