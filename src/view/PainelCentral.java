package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.TerminalEvent;
import controller.TerminalListener;
import model.Terminal;

public class PainelCentral implements TerminalListener {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JEditorPane console;
	private StringBuilder texto;
	
	public PainelCentral() {
		montarJanela();
		this.texto = new StringBuilder();
	}
	
	public void montarJanela() {
		prepararJanela();
		prepararPainel();
		prepararConsole();
		exibirJanela();
	}
	
	private void prepararConsole() {
		console = new JEditorPane();
		console.setBackground(Color.BLACK);
		console.setFont(new Font("Comic Sans", Font.BOLD, 14));
		
		console.setContentType("text/html");
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
		menu();
		
		for (int i = 0; i < situacao.length; i++) {
			String novo = (i+1) + "-" + situacao[i];
			switch (situacao[i]) {
			case '-':
				texto.append("<b color='green'>" + novo + "</b>&nbsp;");
				break;
			case 'R':
				texto.append("<b color='yellow'>" + novo + "</b>&nbsp;");
				break;
			default:
				texto.append("<b color='red'>" + novo + "</b>&nbsp;");
				break;
			}
			if ((i+1) % 5 == 0)
				texto.append("<br>");
		}
		console.setText(texto.toString());
	}
	
	private void menu() {
		texto = new StringBuilder();
		texto.append("<b color='white'>-----------------------------------------------------------------------------</b><br>");
		texto.append("<b color='white'>PAINEL CENTRAL</b> | ");
		texto.append("<b color='green'>V - Vago</b> | ");
		texto.append("<b color='yellow'>R - Reservado</b> | ");
		texto.append("<b color='red'>O - Ocupado</b><br>");
		texto.append("<b color='white'>-----------------------------------------------------------------------------</b><br>");
	}

}
