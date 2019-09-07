package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import br.edu.jati5.util.ViewUtil;

public class TelaDado extends MeuJPanel {

	private static final long serialVersionUID = 1L;
	
	private CampoTexto ct_nome;
	private CampoTexto ct_valor;
	private CampoTexto ct_familia;
	private TelaCadastroEdicao telaCadastroEdicao;

	public TelaDado() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(320, 280));
		MeuJPanel meuJPanel = new MeuJPanel(new GridBagLayout());
		add(meuJPanel, BorderLayout.CENTER);
		
		MeuJPanel meuJPanel_1 = new MeuJPanel(null);
		meuJPanel_1.setPreferredSize(new Dimension(320, 280));
		meuJPanel.add(meuJPanel_1);
		
		ct_nome = new CampoTexto();
		ct_nome.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_nome.setDescricao("Nome");
		ct_nome.setBounds(12, 13, 300, 51);
		meuJPanel_1.add(ct_nome);
		
		ct_valor = new CampoTexto();
		ct_valor.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_valor.setDescricao("Valor");
		ct_valor.setBounds(12, 77, 300, 51);
		meuJPanel_1.add(ct_valor);
		
		ct_familia = new CampoTexto();
		ct_familia.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_familia.setDescricao("Familia");
		ct_familia.setBounds(12, 140, 300, 51);
		meuJPanel_1.add(ct_familia);
		
		telaCadastroEdicao = new TelaCadastroEdicao() 
		{
			private static final long serialVersionUID = 1L;
			
			protected void abilitar() 
			{
				ativar();
				super.abilitar();
			}
			
			protected void desabilitar() 
			{
				desativar();
				super.desabilitar();
			}
		};
		telaCadastroEdicao.setBounds(12, 203, 300, 57);
		meuJPanel_1.add(telaCadastroEdicao);
	}
	
	public void limpar_campos()
	{
		ct_nome.setTexto("");
		ct_valor.setTexto("");
		ct_familia.setTexto("");
	}
	
	private void ativar()
	{
		ct_nome.setEditable(true);
		ct_nome.setEnabled(true);
		ct_valor.setEditable(true);
		ct_valor.setEnabled(true);
		ct_familia.setEditable(true);
		ct_familia.setEnabled(true);
	}
	
	private void desativar()
	{
		ct_nome.setEditable(false);
		ct_nome.setEnabled(false);
		ct_valor.setEditable(false);
		ct_valor.setEnabled(false);
		ct_familia.setEditable(false);
		ct_familia.setEnabled(false);
	}

	public CampoTexto getCt_nome() {
		return ct_nome;
	}

	public CampoTexto getCt_valor() {
		return ct_valor;
	}

	public CampoTexto getCt_familia() {
		return ct_familia;
	}

	public TelaCadastroEdicao getTelaCadastroEdicao() {
		return telaCadastroEdicao;
	}
	
}
