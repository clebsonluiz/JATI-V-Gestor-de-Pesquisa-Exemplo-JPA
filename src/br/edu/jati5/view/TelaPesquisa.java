package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import br.edu.jati5.util.ViewUtil;

public class TelaPesquisa extends MeuJPanel {

	private static final long serialVersionUID = 1L;

	private MeuJPanel contentPane;
	private CampoTexto ct_titulo;
	private CampoTextoArea campoTextoArea;
	private JDateChooser dc_inicio;
	private JDateChooser dc_fim;
	private TelaCadastroEdicao telaCadastroEdicao;

	public TelaPesquisa()
	{
		super(new BorderLayout());
		
		setPreferredSize(new Dimension(300, 350));
		setMinimumSize(getPreferredSize());

		contentPane = new MeuJPanel(null);
		
		contentPane.setPreferredSize(new Dimension(300, 350));
		contentPane.setMinimumSize(new Dimension(300, 350));
		
		JPanel panel = new MeuJPanel(new GridBagLayout());
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.gridy = 0;
		panel.add(contentPane, gbc_contentPane);
		
		ct_titulo = new CampoTexto();
		ct_titulo.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_titulo.setDescricao("Titulo da Pesquisa");
		ct_titulo.setBounds(12, 13, 272, 45);
		contentPane.add(ct_titulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(ViewUtil.Bordas.border1);
		scrollPane.setBounds(12, 71, 272, 120);
		contentPane.add(scrollPane);
		
		campoTextoArea = new CampoTextoArea();
		campoTextoArea.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		campoTextoArea.setDescricao("Descrição...");
		scrollPane.setViewportView(campoTextoArea);
		
		dc_inicio = new JDateChooser();
		dc_inicio.getCalendarButton().setPreferredSize(new Dimension(25, 25));
		
		dc_inicio.setBorder(ViewUtil.Bordas.criarBordaTituloField("Inicio"));
		dc_inicio.setBackground(new Color(240, 240, 240));
		dc_inicio.setBounds(12, 203, 130, 60);
		dc_inicio.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		contentPane.add(dc_inicio);
		
		dc_fim = new JDateChooser();
		dc_fim.setBorder(ViewUtil.Bordas.criarBordaTituloField("Fim"));
		dc_fim.setBackground(new Color(240, 240, 240));
		dc_fim.setBounds(154, 203, 130, 60);
		dc_fim.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		dc_fim.getCalendarButton().setPreferredSize(new Dimension(25, 25));
		contentPane.add(dc_fim);
		
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
		telaCadastroEdicao.setBounds(12, 275, 272, 60);
		contentPane.add(telaCadastroEdicao);
		
		add(panel, BorderLayout.CENTER);
	}

	public void limpar_campos()
	{
		ct_titulo.setTexto("");
		campoTextoArea.setTexto("");
		dc_inicio.setDate(new Date());;
		dc_fim.setDate(new Date());
	}
	
	private void ativar()
	{
		ct_titulo.setEnabled(true);
		ct_titulo.setEditable(true);
		campoTextoArea.setEnabled(true);
		campoTextoArea.setEditable(true);
		dc_inicio.setEnabled(true);
		dc_fim.setEnabled(true);
	}
	
	private void desativar()
	{
		ct_titulo.setEnabled(false);
		ct_titulo.setEditable(false);
		campoTextoArea.setEnabled(false);
		campoTextoArea.setEditable(false);
		dc_inicio.setEnabled(false);
		dc_fim.setEnabled(false);
	}
	
	public CampoTexto getCt_titulo() {
		return ct_titulo;
	}

	public CampoTextoArea getCampoTextoArea() {
		return campoTextoArea;
	}

	public JDateChooser getDc_inicio() {
		return dc_inicio;
	}

	public JDateChooser getDc_fim() {
		return dc_fim;
	}

	public TelaCadastroEdicao getTelaCadastroEdicao() {
		return telaCadastroEdicao;
	}
	
}
