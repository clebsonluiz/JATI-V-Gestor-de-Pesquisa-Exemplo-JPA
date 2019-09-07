package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

import br.edu.jati5.util.ViewUtil;

public class TelaInfUsuario extends TelaInfoTabela {

	private static final long serialVersionUID = 1L;
	private TelaPesquisaTabela telaPesquisa;
	private Botao bt_logout;
	private TelaUsuarioTabela telaUsuarioTabela;

	
	public TelaInfUsuario()
	{
		setPreferredSize(new Dimension(600, 500));
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		
		telaPesquisa = new TelaPesquisaTabela();
		telaPesquisa.setPreferredSize(new Dimension(300, 320));
		
		
		MeuJPanel panel = new MeuJPanel(new BorderLayout());
		
		bt_logout = new Botao("Logout");
		
		
		bt_logout.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B_I);
		bt_logout.setForeground(Color.WHITE);
		bt_logout.setBackground(Color.red.darker());
		
		telaUsuarioTabela = new TelaUsuarioTabela();

		panel.add(telaUsuarioTabela, BorderLayout.CENTER);
		panel.add(bt_logout, BorderLayout.SOUTH);
		
		jTabbedPane.addTab("Info", telaPesquisa);
		jTabbedPane.addTab("Config", panel);
		
		setLeftComponent(jTabbedPane);
	}


	public TelaPesquisaTabela getTelaPesquisaTabela() {
		return telaPesquisa;
	}

	public Botao getBt_logout() {
		return bt_logout;
	}

	public TelaUsuarioTabela getTelaUsuarioTabela() {
		return telaUsuarioTabela;
	}

}
