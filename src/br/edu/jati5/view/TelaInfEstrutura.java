package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

import br.edu.jati5.util.ViewUtil;

public class TelaInfEstrutura extends TelaInfoTabela {

	private static final long serialVersionUID = 1L;

	private TelaEstrutura telaEstrutura;
	private TelaGrafico telaGrafico;
	private Botao btVoltar;
	
	public TelaInfEstrutura() 
	{
		setPreferredSize(new Dimension(640, 500));
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		
		telaEstrutura = new TelaEstrutura();
		telaEstrutura.getTelaCadastroEdicao().desabilitar();
		telaEstrutura.setPreferredSize(new Dimension(320, 350));
		
		telaGrafico = new TelaGrafico();
		
		jTabbedPane.addTab("Info", telaEstrutura);
		jTabbedPane.addTab("Graficos", telaGrafico);
		
		
		MeuJPanel panel = new MeuJPanel(new BorderLayout());
		MeuJPanel panel_1 = new MeuJPanel();
		
		panel.add(jTabbedPane, BorderLayout.CENTER);
		panel.add(panel_1, BorderLayout.SOUTH);
		
		btVoltar = new Botao("Voltar");
		btVoltar.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B_I);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.red.darker());
		
		panel_1.add(btVoltar);
		setLeftComponent(panel);
	}

	public TelaEstrutura getTelaEstrutura() {
		return telaEstrutura;
	}

	public Botao getBtVoltar() {
		return btVoltar;
	}

	public TelaGrafico getTelaGrafico() {
		return telaGrafico;
	}
	
}
