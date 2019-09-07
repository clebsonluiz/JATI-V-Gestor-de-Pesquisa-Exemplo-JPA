package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.edu.jati5.util.ViewUtil;
import javax.swing.SwingConstants;

public class TelaPesquisaTabela extends MeuJPanel {

	private static final long serialVersionUID = 1L;

	private MeuJPanel contentPane;
	private CampoTexto ct_titulo;
	private CampoTextoArea campoTextoArea;
	
	public TelaPesquisaTabela()
	{
		super(new BorderLayout());
		
		setPreferredSize(new Dimension(285, 320));
		setMinimumSize(new Dimension(285, 320));

		contentPane = new MeuJPanel(null);
		
		contentPane.setPreferredSize(new Dimension(285, 320));
		contentPane.setMinimumSize(new Dimension(285, 320));
		
		JPanel panel = new MeuJPanel(new GridBagLayout());
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.gridx = 0;
		gbc_contentPane.gridy = 0;
		panel.add(contentPane, gbc_contentPane);
		
		ct_titulo = new CampoTexto();
		ct_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		ct_titulo.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_titulo.setDescricao("Titulo da Pesquisa");
		ct_titulo.setBounds(12, 13, 260, 45);
		
		ct_titulo.setEditable(false);
		ct_titulo.setEnabled(false);
		
		contentPane.add(ct_titulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(ViewUtil.Bordas.border1);
		scrollPane.setBounds(12, 71, 260, 220);
		contentPane.add(scrollPane);
		
		campoTextoArea = new CampoTextoArea();
		campoTextoArea.setEditable(false);
		campoTextoArea.setEnabled(false);
		scrollPane.setViewportView(campoTextoArea);
		add(panel, BorderLayout.CENTER);
		
	}

	public CampoTexto getCt_titulo() {
		return ct_titulo;
	}

	public CampoTextoArea getCampoTextoArea() {
		return campoTextoArea;
	}

}
