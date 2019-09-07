package br.edu.jati5.view;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class MeuJPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private static Color cor = Color.white;
	private static Color cinza = new Color(240, 240, 240);
	
	public MeuJPanel() {
		super();
		setBackground(cinza);
	}
	
	public MeuJPanel(LayoutManager layout) {
		super(layout);
		setBackground(cinza);
	}
	
	public MeuJPanel(LayoutManager layout, Color cor) {
		super(layout);
		setBackground(cor);
	}
	
	public MeuJPanel(LayoutManager layout, Border borda) {
		super(layout);
		setBackground(cor);
		setBorder(borda);
	}
	
	public MeuJPanel(LayoutManager layout, Color cor, Border borda) {
		super(layout);
		setBackground(cor);
		setBorder(borda);
	}
	
}