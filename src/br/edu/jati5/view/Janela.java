package br.edu.jati5.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private static final String op1 = "0";
	private static final String op2 = "1";
	private static final String op3 = "2";
	private static final String op4 = "3";
	private static final String op5 = "4";
	
	private JPanel contentPane;
	
	private CardLayout card;
	private TelaLogin telaLogin;
	private TelaCadUsuario telaCadUsuario;
	private TelaInfUsuario telaInfUsuario;
	private TelaInfPesquisa telaInfPesquisa;
	private TelaInfEstrutura telaInfEstrutura;
	
	public Janela() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		
		contentPane = new MeuJPanel();
		
		card = new CardLayout();
		
		contentPane.setLayout(card);
		setContentPane(contentPane);
		
		telaLogin = new TelaLogin();
		telaCadUsuario = new TelaCadUsuario();
		telaInfUsuario = new TelaInfUsuario();
		telaInfPesquisa = new TelaInfPesquisa();
		telaInfEstrutura = new TelaInfEstrutura();
		
		card.addLayoutComponent(telaLogin, op1);
		card.addLayoutComponent(telaCadUsuario, op2);
		card.addLayoutComponent(telaInfUsuario, op3);
		card.addLayoutComponent(telaInfPesquisa, op4);
		card.addLayoutComponent(telaInfEstrutura, op5);
		
		contentPane.add(telaLogin);
		contentPane.add(telaCadUsuario);
		contentPane.add(telaInfUsuario);
		contentPane.add(telaInfPesquisa);
		contentPane.add(telaInfEstrutura);
		
		adicionar_evento();
		setLocationRelativeTo(null);
	}
	
	public void show_tela_login() {card.show(contentPane, op1);}
	
	public void show_tela_cad_login() {card.show(contentPane, op2);}
	
	public void show_tela_usuario() {card.show(contentPane, op3);}
	
	public void show_tela_pesquisa() {card.show(contentPane, op4);}
	
	public void show_tela_estrutura() {card.show(contentPane, op5);}

	public TelaLogin getTelaLogin() {return telaLogin;}

	public TelaCadUsuario getTelaCadUsuario() {return telaCadUsuario;}

	public TelaInfUsuario getTelaInfUsuario() {return telaInfUsuario;}

	public TelaInfPesquisa getTelaInfPesquisa() {return telaInfPesquisa;}

	public TelaInfEstrutura getTelaInfEstrutura() {return telaInfEstrutura;}

	
	private void adicionar_evento()
	{
		telaLogin.getBtnCadastrar().addActionListener(this);
		telaCadUsuario.getBt_voltar().addActionListener(this);
		telaInfUsuario.getBt_logout().addActionListener(this);
		telaInfPesquisa.getBtVoltar().addActionListener(this);
		telaInfEstrutura.getBtVoltar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == telaLogin.getBtnCadastrar())
		{
			show_tela_cad_login();
		}
		else if(e.getSource() == telaCadUsuario.getBt_voltar())
		{
			show_tela_login();
		}
		else if(e.getSource() == telaInfUsuario.getBt_logout())
		{
			show_tela_login();
		}
		else if(e.getSource() == telaInfPesquisa.getBtVoltar())
		{
			show_tela_usuario();
		}
		else if(e.getSource() == telaInfEstrutura.getBtVoltar())
		{
			show_tela_pesquisa();
		}
	}
	
	
}
