package br.edu.jati5.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.edu.jati5.controll.Controlador;
import br.edu.jati5.fachada.Facade;
import br.edu.jati5.view.Janela;

public class App {

	public static void main(String[] args) 
	{
		
		try 
		{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} 
		catch (UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}
		
		Facade.getInstance();
		
		Janela janela = new Janela();
		
		Controlador controll = new Controlador(janela);
		controll.adicionar_tables();
		controll.adicionar_eventos();
		controll.adicionar_eventos_cadastro();
		
		janela.setVisible(true);
	}
}
