package br.edu.jati5.view;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

import br.edu.jati5.util.ViewUtil;

public class CampoSenha extends JPasswordField implements FocusListener{

	private static final long serialVersionUID = 1L;
	private String campoDescricao;
	private String campoAtual;
	
	public CampoSenha() {
		setBorder(ViewUtil.Bordas.border1);
		addFocusListener(this);
	}

	public CampoSenha(String text) {
		super(text);
		setBorder(ViewUtil.Bordas.border1);
		addFocusListener(this);
	}
	
	/**
	 * @param descricao - Mensagem que será exibida 
	 * quando o campo estiver vazio e sem foco
	 */
	public void setDescricao(String descricao) {
		this.campoDescricao = descricao;
		setPadrao();
	}
	
	private void setPadrao() {
		this.campoAtual = "";
		this.setText(campoDescricao);
		this.setEchoChar((char)0);
		this.setForeground(Color.lightGray);
	} 
	
	private void setAtual() {
		this.campoAtual = new String(getPassword());
		this.setText("");
		this.setEchoChar('*');
		this.setForeground(Color.black);
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if((getPassword()).length == 0 || new String(getPassword()).trim().equals("")) 
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
			return new String(getPassword());
	}
	
	public void setText(String text) {
		super.setText(text);
		this.setEchoChar('*');
	}
	
}