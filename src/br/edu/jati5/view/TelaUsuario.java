package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import br.edu.jati5.util.ViewUtil.Fonts.Arial;
import java.awt.Font;

public class TelaUsuario extends MeuJPanel {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private CampoTexto loginField;
	private CampoSenha senhaField;

	private TelaCadastroEdicao telaCadastroEdicao;

	private CampoTexto ct_nome;
	
	public TelaUsuario()
	{
		super(new BorderLayout());
		
		setPreferredSize(new Dimension(400, 400));
		setMinimumSize(getPreferredSize());

		contentPane = new MeuJPanel(null);
		
		contentPane.setPreferredSize(new Dimension(400, 300));
		contentPane.setMinimumSize(new Dimension(400, 300));
		
		ct_nome = new CampoTexto();
		ct_nome.setFont(new Font("Arial", Font.BOLD, 20));
		ct_nome.setEnabled(false);
		ct_nome.setEditable(false);
		ct_nome.setDescricao("Nome");
		ct_nome.setColumns(10);
		ct_nome.setBounds(23, 11, 347, 50);
		contentPane.add(ct_nome);
		
		loginField = new CampoTexto();
		loginField.setDescricao(" Login");
		loginField.setBounds(23, 83, 347, 50);
		loginField.setFont(Arial.ARIAL_TITULO_B);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		senhaField = new CampoSenha();
		senhaField.setDescricao(" Senha");
		senhaField.setBounds(23, 157, 347, 50);
		senhaField.setFont(Arial.ARIAL_TITULO_B);
		contentPane.add(senhaField);
		
		JPanel panel = new MeuJPanel(new GridBagLayout());
		panel.add(contentPane);
		
		loginField.setEditable(false);
		loginField.setEnabled(false);
		
		senhaField.setEditable(false);
		senhaField.setEnabled(false);
		
		telaCadastroEdicao = new TelaCadastroEdicao() 
		{
			private static final long serialVersionUID = 1L;

			protected void abilitar() 
			{
				ct_nome.setEditable(true);
				ct_nome.setEnabled(true);
				super.abilitar();
			}
			
			protected void desabilitar() 
			{
				ct_nome.setEditable(false);
				ct_nome.setEnabled(false);
				super.desabilitar();
			}
			
		};
		
		
		telaCadastroEdicao.setBounds(23, 219, 347, 50);
		contentPane.add(telaCadastroEdicao);
		
		
		add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new MeuJPanel();
		add(panel_1, BorderLayout.SOUTH);
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public CampoTexto getNomeField() {
		return ct_nome;
	}

	public CampoTexto getLoginField() {
		return loginField;
	}

	public CampoSenha getSenhaField() {
		return senhaField;
	}

	public TelaCadastroEdicao getTelaCadastroEdicao() {
		return telaCadastroEdicao;
	}
	
	public void limpar_campos()
	{
		ct_nome.setTexto("");
		loginField.setTexto("");
		senhaField.setText("");
	}
}
