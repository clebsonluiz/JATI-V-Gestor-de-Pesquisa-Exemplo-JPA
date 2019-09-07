package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import br.edu.jati5.util.ViewUtil;

public class TelaEstrutura extends MeuJPanel {

	private static final long serialVersionUID = 1L;

	private CampoTexto ct_nome;
	private CampoTexto ct_valor;
	private CampoTexto ct_familia;
	private CampoTexto ct_titulo;
	private CampoTexto ct_categoria;
	private TelaCadastroEdicao telaCadastroEdicao;

	public TelaEstrutura() 
	{
		setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(320, 350));
		setPreferredSize(new Dimension(320, 350));
		MeuJPanel meuJPanel = new MeuJPanel(new GridBagLayout());
		add(meuJPanel, BorderLayout.CENTER);

		MeuJPanel meuJPanel_1 = new MeuJPanel(null);
		meuJPanel_1.setPreferredSize(new Dimension(320, 350));
		meuJPanel.add(meuJPanel_1);

		ct_nome = new CampoTexto();
		ct_nome.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_nome.setDescricao("Nome do Dado");
		ct_nome.setBounds(10, 62, 300, 40);
		meuJPanel_1.add(ct_nome);

		ct_valor = new CampoTexto();
		ct_valor.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_valor.setDescricao("Nome do Valor");
		ct_valor.setBounds(10, 113, 300, 40);
		meuJPanel_1.add(ct_valor);

		ct_familia = new CampoTexto();
		ct_familia.setFont(ViewUtil.Fonts.Arial.ARIAL_TITULO_B);
		ct_familia.setDescricao("Familia de Origem");
		ct_familia.setBounds(10, 164, 300, 40);
		meuJPanel_1.add(ct_familia);
		
		ct_titulo = new CampoTexto();
		ct_titulo.setFont(new Font("Arial", Font.BOLD, 20));
		ct_titulo.setDescricao("Titulo da Estrutura");
		ct_titulo.setBounds(10, 11, 300, 40);
		meuJPanel_1.add(ct_titulo);
		
		ct_categoria = new CampoTexto();
		ct_categoria.setFont(new Font("Arial", Font.BOLD, 20));
		ct_categoria.setDescricao("Categoria dos Valores");
		ct_categoria.setBounds(10, 215, 300, 40);
		meuJPanel_1.add(ct_categoria);
		ativar();
		
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
		telaCadastroEdicao.setBounds(10, 266, 300, 59);
		meuJPanel_1.add(telaCadastroEdicao);

	}
	
	public void limpar_campos()
	{
		ct_nome.setTexto("");
		ct_valor.setTexto("");
		ct_familia.setTexto("");
		ct_titulo.setTexto("");
		ct_categoria.setTexto("");
	}
	
	private void ativar()
	{
		ct_nome.setEditable(true);
		ct_nome.setEnabled(true);
		ct_valor.setEditable(true);
		ct_valor.setEnabled(true);
		ct_familia.setEditable(true);
		ct_familia.setEnabled(true);
		ct_titulo.setEditable(true);
		ct_titulo.setEnabled(true);
		ct_categoria.setEditable(true);
		ct_categoria.setEnabled(true);
	}
	
	private void desativar()
	{
		ct_nome.setEditable(false);
		ct_nome.setEnabled(false);
		ct_valor.setEditable(false);
		ct_valor.setEnabled(false);
		ct_familia.setEditable(false);
		ct_familia.setEnabled(false);
		ct_titulo.setEditable(false);
		ct_titulo.setEnabled(false);
		ct_categoria.setEditable(false);
		ct_categoria.setEnabled(false);	
	}

	public CampoTexto getCt_nome() {
		return ct_nome;
	}

	public CampoTexto getCt_valor() {
		return ct_valor;
	}

	public CampoTexto getCt_familia() {
		return ct_familia;
	}

	public CampoTexto getCt_titulo() {
		return ct_titulo;
	}

	public CampoTexto getCt_categoria() {
		return ct_categoria;
	}

	public TelaCadastroEdicao getTelaCadastroEdicao() {
		return telaCadastroEdicao;
	}
	
}
