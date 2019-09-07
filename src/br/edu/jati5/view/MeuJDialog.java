package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.edu.jati5.util.ViewUtil;

public class MeuJDialog extends JDialog {

	public static final int MESSAGE_TYPE_INFORMATION = 0;
	public static final int MESSAGE_TYPE_PROBLEM = 1;
	public static final int MESSAGE_TYPE_WARNING = 2;
	
	private static final Border bordaWarning = ViewUtil.Bordas.criarBordaBalaoDialogo(Color.YELLOW.darker());
	private static final Border bordaProblem = ViewUtil.Bordas.criarBordaBalaoDialogo(Color.RED);
	private static final Border bordaInfo = ViewUtil.Bordas.criarBordaBalaoDialogo(Color.GREEN.darker().darker());
	
	private static int op = 0;
	private static final long serialVersionUID = 1L;

	private static MeuJDialog instance;
	private static MeuJDialog instance2;
	private static MeuJDialog instance3;
	
	private static MeuJDialog getInstance()
	{
		if(instance == null)
			instance = new MeuJDialog(MESSAGE_TYPE_WARNING);
		return instance;
	}
	
	private static MeuJDialog getInstance2()
	{
		if(instance2 == null)
			instance2 = new MeuJDialog(MESSAGE_TYPE_PROBLEM);
		return instance2;
	}

	private static MeuJDialog getInstance3()
	{
		if(instance3 == null)
			instance3 = new MeuJDialog(MESSAGE_TYPE_INFORMATION);
		return instance3;
	}
	
	public static int exibirAlertaPergunta(Component c, String titulo, String msg)
	{
		op = 0;
		getInstance().exibirMensagem(titulo, msg, bordaWarning, c);
		getInstance().setVisible(true);
		return op;
	}
	
	public static int exibirAlertaErro(Component c, String titulo, String msg)
	{
		op = 0;
		getInstance2().exibirMensagem(titulo, msg, bordaProblem, c);
		getInstance2().setVisible(true);
		return op;
	}
	
	public static int exibirAlertaInfo(Component c, String titulo, String msg)
	{
		op = 0;
		getInstance3().exibirMensagem(titulo, msg, bordaInfo, c);
		getInstance3().setVisible(true);
		return op;
	}
	
	
	public static void main(String[] args) {
		try {
			
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			
			System.out.println(MeuJDialog.exibirAlertaInfo(null, "Titulo", "\"Descrição do Text Area que mostra o que ocorreu para que o evento fosse chamado"
//					+ "\\nDescrição do Text Area que mostra o que ocorreu para que o evento fosse chamado"
					+ ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel labelTitulo;
	private JLabel labelIcone;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public MeuJDialog(int message_Type) {
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) { setVisible(false); }
		});
		
		setSize(new Dimension(400, 250));
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setResizable(false);
		labelIcone = new JLabel();
		labelIcone.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelSouth = new JPanel();
		Botao btnOK = new Botao("OK");
		
		btnOK.addActionListener(ActionEvent->
		{
			op = 1;
			setVisible(false);
		});
		
		btnOK.grabFocus();
		btnOK.setPreferredSize(new Dimension(70, 50));
		btnOK.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		panelSouth.add(btnOK);
		
		Botao btCancelar = new Botao("Cancelar");
		btCancelar.addActionListener(ActionEvent->
		{
			op = 0;
			setVisible(false);
		});
		btCancelar.setPreferredSize(new Dimension(110, 50));
		btCancelar.setFont(new Font("Arial", Font.BOLD, 17));
		panelSouth.add(btCancelar);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		JPanel panelCenter = new JPanel(new BorderLayout());
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.add(labelIcone, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panelCenter.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		labelTitulo = new JLabel("Titulo");
		textArea = new JTextArea(2, 100);
		textArea.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		panelCenter.add(labelTitulo, BorderLayout.NORTH);
		
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_GIGANTE_B);
		
		JPanel panel_1 = new JPanel();
		panelCenter.add(panel_1, BorderLayout.EAST);
		
		
		switch (message_Type) {
			case MESSAGE_TYPE_INFORMATION:
				panel.setBackground(null);//NÂO MUDAR
				scrollPane.setBackground(null);
				scrollPane.getViewport().setBackground(Color.GREEN.darker().darker());
				btnOK.setBackground(Color.GREEN.darker());
				btnOK.setForeground(Color.WHITE);
				btCancelar.setBackground(Color.RED);
				btCancelar.setForeground(Color.WHITE);
				btCancelar.setVisible(false);
				textArea.setBackground(Color.GREEN.darker().darker());
				textArea.setForeground(Color.WHITE);
				
				labelTitulo.setForeground(Color.GREEN.darker().darker());
				break;
			case MESSAGE_TYPE_PROBLEM:
				panel.setBackground(null);//NÂO MUDAR
				scrollPane.setBackground(null);
				scrollPane.getViewport().setBackground(Color.RED);
				btnOK.setBackground(Color.RED);
				btnOK.setForeground(Color.WHITE);
				btCancelar.setBackground(Color.RED);
				btCancelar.setForeground(Color.WHITE);
				btCancelar.setVisible(false);
				textArea.setBackground(Color.red);
				textArea.setForeground(Color.WHITE);
				
				labelTitulo.setForeground(Color.red);
				break;
			case MESSAGE_TYPE_WARNING:
				panel.setBackground(null);//NÂO MUDAR
				scrollPane.setBackground(null);
				scrollPane.getViewport().setBackground(Color.YELLOW.darker());
				btnOK.setBackground(Color.GREEN.darker());
				btnOK.setForeground(Color.WHITE);
				btCancelar.setBackground(Color.RED);
				btCancelar.setForeground(Color.WHITE);
				btCancelar.setVisible(true);
				textArea.setBackground(Color.YELLOW.darker());
				textArea.setForeground(Color.BLACK);
				FlowLayout flowLayout = (FlowLayout) panelSouth.getLayout();
				flowLayout.setAlignment(FlowLayout.RIGHT);
				labelTitulo.setForeground(Color.BLACK);
				break;
		}
	}
	
	public void exibirMensagem(String titulo, String msg, Border bordaBalao, Component c)
	{
		labelTitulo.setText(titulo);
		textArea.setText(msg);
		
		scrollPane.setBorder(bordaBalao);
		
		if(c != null)
		{
			int largura =  c.getWidth();
			int altura = c.getHeight();
			Point p =  new Point(largura/2 - this.getWidth()/2, altura/2 - this.getHeight()/2);
			this.setLocation(p);
		}
		else this.setLocationRelativeTo(null);
		
		repaint();
	}

}