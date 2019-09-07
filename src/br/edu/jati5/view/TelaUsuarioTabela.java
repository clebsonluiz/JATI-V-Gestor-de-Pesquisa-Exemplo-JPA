package br.edu.jati5.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JToggleButton;

import br.edu.jati5.util.ViewUtil;

public class TelaUsuarioTabela extends TelaUsuario 
{
	private static final long serialVersionUID = 1L;
	private JToggleButton tglbtnEditarSenha;
	private Botao btConcluir;

	public TelaUsuarioTabela() 
	{
		super();
		getNomeField().setBounds(23, 11, 250, 50);
		setPreferredSize(new Dimension(300, 300));
		setMinimumSize(new Dimension(280, 300));
		getContentPane().setMinimumSize(new Dimension(300, 300));
		getContentPane().setPreferredSize(new Dimension(300, 300));
		getSenhaField().setBounds(23, 134, 250, 50);
		getTelaCadastroEdicao().setBounds(23, 196, 250, 93);
		
		btConcluir = new Botao();
		btConcluir.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		btConcluir.setText("Concluir");
		btConcluir.setVisible(false);
		getTelaCadastroEdicao().add(btConcluir);
		
		tglbtnEditarSenha = new JToggleButton("Editar Senha");
		getTelaCadastroEdicao().add(tglbtnEditarSenha);
		getLoginField().setBounds(23, 73, 250, 50);
	
		tglbtnEditarSenha.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);
		
		tglbtnEditarSenha.addActionListener((ActionEvent)->{
			if(tglbtnEditarSenha.isSelected()) 
				abilitar();
			else 
				desabilitar();
		});
	}
	
	private void abilitar()
	{
		getTelaCadastroEdicao().esconderTglbtnBotao();
		getTelaCadastroEdicao().desabilitar();
		getSenhaField().setEditable(true);
		getSenhaField().setEnabled(true);
		tglbtnEditarSenha.setBackground(Color.red.brighter());
		tglbtnEditarSenha.setForeground(Color.white);
		tglbtnEditarSenha.setText("Cancelar");
		btConcluir.setVisible(true);
	}
	
	private void desabilitar()
	{
		getTelaCadastroEdicao().desabilitar();
		getTelaCadastroEdicao().mostrarTglbtnBotao();
		getSenhaField().setEditable(false);
		getSenhaField().setEnabled(false);
		tglbtnEditarSenha.setBackground(null);
		tglbtnEditarSenha.setForeground(Color.black);
		tglbtnEditarSenha.setText("Editar Senha");
		btConcluir.setVisible(false);
	}

	public void escondeBtn()
	{
		desabilitar();
	}
	
	public Botao getBtConcluir() {
		return btConcluir;
	}
	
}
