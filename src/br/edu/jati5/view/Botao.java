package br.edu.jati5.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;

public class Botao extends JButton {

	public static final Color CINZA_CLARO_PADRAO = Color.LIGHT_GRAY;
	public static final Color CINZA_CLARO_2 = new Color(210, 210, 210);
	
	public static final Color VERDE = new Color(100, 150, 0);
	public static final Color VERDE_ESCURO = new Color(0, 100, 0);
	public static final Color MARROM = new Color(100, 100, 0);
	
	public static final Font FONT_PADRAO = new Font("Arial", Font.BOLD, 14);
	public static final Font FONT_CLICK = new Font("Arial", Font.BOLD, 16);
	
	public static final Color VERMELHO = Color.RED;
	public static final Color VERMELHO_ESCURO = Color.RED.darker();
	public static final Color VERMELHO_CLARO = Color.RED.brighter();
	
	private static final long serialVersionUID = 1L;

	public Botao() {
		super();
		setBackground(CINZA_CLARO_PADRAO);
	}
	
	public Botao(String texto) {
		super(texto);
		setBackground(CINZA_CLARO_PADRAO);
	}
	
	public Botao(String texto, Color cor) {
		super(texto);
		setBackground(cor);
	}
	
	public Botao(Icon icone,String texto_ao_passar_mouse) {
		super(icone);
		setToolTipText(texto_ao_passar_mouse);
		setBackground(CINZA_CLARO_PADRAO);
	}
	
	public Botao(Icon icone,String texto_ao_passar_mouse, Color corFundo, Color corFrontal) {
		super(icone);
		setToolTipText(texto_ao_passar_mouse);
		setForeground(corFrontal);
		setBackground(corFundo);
	}
	
	public Botao(Icon icone, String texto, int posicaoVerticalTexto, int posicaoHorizontalTexto) {
		super(icone);
		setText(texto);
		setVerticalTextPosition(posicaoVerticalTexto);
		setHorizontalTextPosition(posicaoHorizontalTexto);
		setBackground(CINZA_CLARO_PADRAO);
	}
	
	
	
}