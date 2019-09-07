package br.edu.jati5.view;

public class TelaCadPesquisa extends TelaPesquisa {

	private static final long serialVersionUID = 1L;

	public TelaCadPesquisa()
	{
		getTelaCadastroEdicao().abilitar();
		getTelaCadastroEdicao().esconderTglbtnBotao();
	}
}
