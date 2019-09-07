package br.edu.jati5.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import br.edu.jati5.util.ViewUtil;

public class CampoTexto extends JTextField implements FocusListener{

	private static final long serialVersionUID = 1L;
	private String campoDescricao;
	private String campoAtual;
	
	public CampoTexto() {
		setBorder(ViewUtil.Bordas.border1);
		addFocusListener(this);
	}

	public CampoTexto(String text) {
		super(text);
		setBorder(ViewUtil.Bordas.border1);
		addFocusListener(this);
	}
	
	public CampoTexto(String text, Font font) {
		super(text);
		setFont(font);
		setBorder(ViewUtil.Bordas.border1);
		addFocusListener(this);
	}
	
	public CampoTexto(Font font) {
		setFont(font);
		setBorder(ViewUtil.Bordas.border1);
		addFocusListener(this);
	}
	
	/**
	 * @param descricao - Mensagem que será exibida
	 * quando o campo estiver vazio e sem foco.
	 */
	public void setDescricao(String descricao) {
		this.campoDescricao = descricao;
		setPadrao();
	}
	
	private void setPadrao() {
		this.campoAtual = "";
		this.setText(campoDescricao);
		this.setForeground(Color.lightGray);
	} 
	
	private void setAtual() {
		this.campoAtual = getText();
		this.setText("");
		this.setForeground(Color.black);
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if(getText().trim().equals(""))
			setPadrao();
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(campoAtual == null || campoAtual.trim().equals(""))
			setAtual();
	}
	
	public String getTexto() {
		if(campoAtual.trim().equals(""))
			return "";
		else
			return getText();
	}
	
	public void setTexto(String text)
	{
		this.setText(text);
		setAtual();
		this.setText(campoAtual);
		requestFocus();
	}
}