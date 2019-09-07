package br.edu.jati5.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class JCadastro extends JDialog {

	private static final long serialVersionUID = 1L;

	private TelaCadPesquisa telaCadPesquisa;
	private TelaCadEstrutura telaCadEstrutura;
	private TelaCadDado telaCadDado;
	
	
	private static final String C_PESQUISA = "1";
	private static final String C_ESTRUTURA = "2";
	private static final String C_DADO = "3";
	
	private static final Dimension d1 = new Dimension(320, 370);
	private static final Dimension d2 = new Dimension(350, 380);
	private static final Dimension d3 = new Dimension(350, 340);
	
	private MeuJPanel contentPanel;
	private CardLayout card;
	
	private static JCadastro instance;
	
	public static JCadastro getInstance()
	{
		if(instance == null)
			instance = new JCadastro();
		return instance;
	}
	
	public static void exibir_cadastro_pesquisa() {getInstance().cad_p();}
	public static void exibir_cadastro_estrutura() {getInstance().cad_e();}
	public static void exibir_cadastro_dado() {getInstance().cad_d();}

	
	public static void main(String[] args) {
		try {
			JCadastro dialog = new JCadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JCadastro() 
	{
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) { setVisible(false); }
		});
		
		setSize(new Dimension(350, 340));
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setResizable(false);
		
		contentPanel = new MeuJPanel();
		setContentPane(contentPanel);
		
		telaCadPesquisa = new TelaCadPesquisa();
		telaCadEstrutura = new TelaCadEstrutura();
		telaCadDado = new TelaCadDado();
		
		telaCadPesquisa.getTelaCadastroEdicao().abilitar();
		telaCadEstrutura.getTelaCadastroEdicao().abilitar();
		telaCadDado.getTelaCadastroEdicao().abilitar();
		
		card = new CardLayout();
		card.addLayoutComponent(telaCadPesquisa, C_PESQUISA);
		card.addLayoutComponent(telaCadEstrutura, C_ESTRUTURA);
		card.addLayoutComponent(telaCadDado, C_DADO);
		
		contentPanel.setLayout(card);
		contentPanel.add(telaCadPesquisa);
		contentPanel.add(telaCadEstrutura);
		contentPanel.add(telaCadDado);
		
	}
	
	private void cad_p()
	{
		card.show(contentPanel, C_PESQUISA);
		set_dimension(d1);
	}
	
	private void cad_e()
	{
		card.show(contentPanel, C_ESTRUTURA);
		set_dimension(d2);
	}
	
	private void cad_d()
	{
		card.show(contentPanel, C_DADO);
		set_dimension(d3);
	}

	public void set_dimension(Dimension d)
	{
		setPreferredSize(d);
		setMinimumSize(d);
		revalidate();
		repaint();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public TelaCadPesquisa getTelaCadPesquisa() {
		return telaCadPesquisa;
	}

	public TelaCadEstrutura getTelaCadEstrutura() {
		return telaCadEstrutura;
	}

	public TelaCadDado getTelaCadDado() {
		return telaCadDado;
	}
	
}
