package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

import br.edu.jati5.util.ViewUtil;

public class TelaInfPesquisa extends TelaInfoTabela {

	private static final long serialVersionUID = 1L;
	private TelaPesquisa telaPesquisa;
	private TelaGrafico telaGraficoPesquisa;
	private Botao btVoltar;
	
	public TelaInfPesquisa()
	{
		setPreferredSize(new Dimension(600, 500));
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		
		telaPesquisa = new TelaPesquisa();
		telaPesquisa.getTelaCadastroEdicao().desabilitar();
		telaPesquisa.setPreferredSize(new Dimension(300, 320));
		
		jTabbedPane.addTab("Info", telaPesquisa);
		
		telaGraficoPesquisa = new TelaGrafico();
		telaGraficoPesquisa.chartExclusivo(TelaGrafico.g_anel);
		telaGraficoPesquisa.setNomeCategoria("TEMPO DECORRIDO (%)", "", "");
		
		jTabbedPane.addTab("Andamento", telaGraficoPesquisa);
		
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

	public TelaPesquisa getTelaPesquisa() {
		return telaPesquisa;
	}

	public Botao getBtVoltar() {
		return btVoltar;
	}

	public TelaGrafico getTelaGraficoPesquisa() {
		return telaGraficoPesquisa;
	}

}
