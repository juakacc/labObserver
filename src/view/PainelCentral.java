package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.TerminalEvent;
import controller.TerminalListener;
import model.Terminal;

public class PainelCentral implements TerminalListener {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTextArea console;
	
	public PainelCentral() {
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
		
		console.setForeground(Color.RED);

		painelPrincipal.add(BorderLayout.CENTER, console);
	}

	private void prepararPainel() {
		painelPrincipal = new JPanel(new BorderLayout());
		painelPrincipal.setBackground(Color.BLACK);
		janela.setContentPane(painelPrincipal);
	}

	private void exibirJanela() {
		janela.setSize(600, 200);
		janela.setLocation(0, 300);
		janela.setVisible(true);
	}

	private void prepararJanela() {
		janela = new JFrame("Painel Central");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void atualizarPassagens(TerminalEvent t) {
		Terminal terminal = (Terminal) t.getSource();
		Character situacao[] = terminal.getBus().getBus();
		console.setText("");
		
		for (int i = 0; i < situacao.length; i++) {
			String novo = (i+1) + "-" +situacao[i];
			console.setText(console.getText() + "\t" + novo);
			if ((i+1) % 5 == 0)
				console.setText(console.getText() + "\n");
		}
	}

}
