package br.edu.jati5.view;

public class TelaCadEstrutura extends TelaEstrutura {

	private static final long serialVersionUID = 1L;

	public TelaCadEstrutura()
	{
		getTelaCadastroEdicao().abilitar();
		getTelaCadastroEdicao().esconderTglbtnBotao();
	}

}
