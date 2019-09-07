package br.edu.jati5.view;

import br.edu.jati5.util.ViewUtil;

public class TelaCadUsuario extends TelaUsuario {

	private static final long serialVersionUID = 1L;

	private Botao bt_voltar;
	
	public TelaCadUsuario()
	{
		bt_voltar = new Botao("Voltar");
		bt_voltar.setFont(ViewUtil.Fonts.Arial.ARIAL_MEDIO_B);

		getTelaCadastroEdicao().abilitar();
		getTelaCadastroEdicao().esconderTglbtnBotao();
		
		getNomeField().setEditable(true);
		getNomeField().setEnabled(true);
		
		getLoginField().setEditable(true);
		getLoginField().setEnabled(true);
		
		getSenhaField().setEditable(true);
		getSenhaField().setEnabled(true);
		getTelaCadastroEdicao().add(bt_voltar);
	}

	public Botao getBt_voltar() {
		return bt_voltar;
	}
	
}
