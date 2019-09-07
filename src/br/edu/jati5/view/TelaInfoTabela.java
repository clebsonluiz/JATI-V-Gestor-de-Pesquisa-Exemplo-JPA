package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import br.edu.jati5.util.ViewUtil;

public class TelaInfoTabela extends MeuJPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private CampoTexto ct_busca;
	private Botao btBuscar;

	private JSplitPane splitPane;
	private MeuJPanel meuJPanel;
	private Botao btCadastrar;
	
	public TelaInfoTabela() 
	{
		super(new BorderLayout());
		
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.01);
		splitPane.setOneTouchExpandable(true);
		add(splitPane);
		
		MeuJPanel meuPanel = new MeuJPanel();
		meuPanel.setMinimumSize(new Dimension(300, 300));
		meuPanel.setLayout(new BorderLayout(0, 0));
		
		MeuJPanel panel = new MeuJPanel();
		
		splitPane.setRightComponent(meuPanel);
		
		meuPanel.add(panel, BorderLayout.NORTH);
		
		ct_busca = new CampoTexto();
		ct_busca.setDescricao("Buscar por...");
		ct_busca.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		ct_busca.setColumns(16);
		panel.add(ct_busca);
		
		btBuscar = new Botao();
		btBuscar.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		btBuscar.setText("Buscar");
		panel.add(btBuscar);
		
		table = new JTable();
		
		JScrollPane scroll = new JScrollPane(table);
		
		meuPanel.add(scroll, BorderLayout.CENTER);
		
		meuJPanel = new MeuJPanel();
		meuPanel.add(meuJPanel, BorderLayout.SOUTH);
		
		btCadastrar = new Botao();
		btCadastrar.setText("Cadastrar");
		btCadastrar.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		meuJPanel.add(btCadastrar);
	}

	public JTable getTable() {
		return table;
	}

	public CampoTexto getCt_busca() {
		return ct_busca;
	}

	public Botao getBtBuscar() {
		return btBuscar;
	}

	public Botao getBtCadastrar() {
		return btCadastrar;
	}
	
	public void setLeftComponent(Component component)
	{
		splitPane.setLeftComponent(component);
	}
	
}
