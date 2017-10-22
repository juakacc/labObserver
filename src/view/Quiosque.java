package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Terminal;
import model.TerminalEvent;
import model.TerminalListener;

/**
 * Classe responsável por representar a tela do quiosque
 * @see TerminalListener
 * @author juaka, Patrick
 *
 */
public class Quiosque implements TerminalListener {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTextArea console;
	
	public Quiosque() {
		montarJanela();
	}
	
	public void montarJanela() {
		prepararJanela();
		prepararPainel();
		prepararConsole();
		exibirJanela();
	}
	
	private void prepararConsole() {
		console = new JTextArea();
		console.setBackground(Color.BLACK);
		console.setFont(new Font("Comic Sans", Font.BOLD, 14));
		console.setForeground(Color.WHITE);
		painelPrincipal.add(BorderLayout.CENTER, console);
	}

	private void exibirJanela() {
		janela.setSize(600, 200);
		janela.setVisible(true);
	}

	private void prepararPainel() {
		painelPrincipal = new JPanel(new BorderLayout());
		painelPrincipal.setBackground(Color.BLACK);
		janela.setContentPane(painelPrincipal);
	}

	private void prepararJanela() {
		janela = new JFrame("Quiosque");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void atualizarPassagens(TerminalEvent t) {
		Terminal terminal = (Terminal) t.getSource();
		Character situacao[] = terminal.getOnibus().getAcentos();
		console.setText("");
		menu();
		
		for (int i = 0; i < situacao.length; i++) {
			String novo = (i+1) + "-" +situacao[i];
			console.setText(console.getText() + " " + novo + "\t");
			if ((i+1) % 5 == 0)
				console.setText(console.getText() + "\n");
		}
	}
	
	private void menu() {
		StringBuilder str = new StringBuilder();
		str.append("---------------------------------------------------------------------\n");
		str.append("QUIOSQUE | V - Vago | ");
		str.append("R - Reservado | ");
		str.append("O - Ocupado |\n");
		str.append("---------------------------------------------------------------------\n");
		console.setText(str.toString());
	}
}