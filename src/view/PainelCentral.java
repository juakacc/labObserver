package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import controller.TerminalEvent;
import controller.TerminalListener;

public class PainelCentral implements TerminalListener {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTextPane console;
	
	public void montarJanela() {
		prepararJanela();
		prepararPainel();
		prepararConsole();
		exibirJanela();
	}
	
	private void prepararConsole() {
		console = new JTextPane();
//		console.setBackground(Color.BLACK);
//		console.setFont(new Font("Comic Sans", Font.PLAIN, 14));
		
		
//		console.setForeground(Color.RED);
		
		//console.setText("Olá galera do busú");
		
//		console.setForeground(Color.BLUE);
//		@SuppressWarnings
//		console.setContentType("text/html");
		console.setText("<a color='blue'>Olaar</a>");
		painelPrincipal.add(BorderLayout.CENTER, console);
	}

	private void prepararPainel() {
		painelPrincipal = new JPanel(new BorderLayout());
		painelPrincipal.setBackground(Color.BLACK);
		janela.setContentPane(painelPrincipal);
	}

	private void exibirJanela() {
		janela.setSize(500, 500);
		janela.setVisible(true);
	}

	private void prepararJanela() {
		janela = new JFrame("Painel Central");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void atualizarPassagens(TerminalEvent t) {
		// TODO Auto-generated method stub
	}

}
