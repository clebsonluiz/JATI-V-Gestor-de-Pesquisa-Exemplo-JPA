package br.edu.jati5.view;

public class TelaCadDado extends TelaDado {

	private static final long serialVersionUID = 1L;

	public TelaCadDado()
	{
		getTelaCadastroEdicao().abilitar();
		getTelaCadastroEdicao().esconderTglbtnBotao();
	}

}
