package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.edu.jati5.util.ViewUtil;
import br.edu.jati5.util.ViewUtil.Fonts.Arial;

public class TelaLogin extends MeuJPanel {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private CampoTexto loginField;
	private CampoSenha senhaField;
	private JButton btnLogar;
	private JButton btnCadastrar;

	private JLabel lblErro;

	public TelaLogin() {
		super(new BorderLayout());
		
		setPreferredSize(new Dimension(400, 450));
		setMinimumSize(getPreferredSize());

		contentPane = new MeuJPanel(null);
		
		contentPane.setPreferredSize(new Dimension(400, 400));
		contentPane.setMinimumSize(getPreferredSize());
		
		loginField = new CampoTexto();
		loginField.setDescricao(" Login");
		loginField.setBounds(23, 154, 347, 50);
		loginField.setFont(Arial.ARIAL_TITULO_B);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		senhaField = new CampoSenha();
		senhaField.setDescricao(" Senha");
		senhaField.setBounds(23, 228, 347, 50);
		senhaField.setFont(Arial.ARIAL_TITULO_B);
		contentPane.add(senhaField);
		
		btnLogar = new JButton("Entrar");
		btnLogar.setToolTipText("Logar no sistema");
		btnLogar.setBounds(23, 300, 98, 73);
		btnLogar.setFont(Arial.ARIAL_TITULO_B);
		btnLogar.setBackground(Color.BLUE.darker());
		btnLogar.setForeground(Color.white);
		contentPane.add(btnLogar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastrar novo usuario");
		btnCadastrar.setBounds(150, 300, 220, 73);
		btnCadastrar.setFont(Arial.ARIAL_TITULO_B);
		btnCadastrar.setBackground(Color.RED.darker());
		btnCadastrar.setForeground(Color.WHITE);
		contentPane.add(btnCadastrar);
		
		JPanel panel = new MeuJPanel(new GridBagLayout());
		panel.add(contentPane);
		
		JLabel lblNewLabel = new JLabel("Autenticação de Usuário");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(23, 61, 347, 73);
		contentPane.add(lblNewLabel);
		add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new MeuJPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		lblErro = new JLabel("");
		lblErro.setBorder(null);
		lblErro.setForeground(Color.RED.darker());
		
		lblErro.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		panel_1.add(lblErro);
	}

	
	public void limpar_campos() {
		loginField.setTexto("");
		senhaField.setText("");
		olcultarErro();
	}
	
	public void exibirErro(String text)
	{
		lblErro.setText(text);
		lblErro.setBorder(ViewUtil.Bordas.border2);
		revalidate();
		repaint();
	}
	
	public void olcultarErro()
	{
		lblErro.setText("");
		lblErro.setBorder(null);
		revalidate();
		repaint();
	}
	
	public CampoTexto getLoginField() {
		return loginField;
	}

	public CampoSenha getSenhaField() {
		return senhaField;
	}

	public JButton getBtnLogar() {
		return btnLogar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}
}
