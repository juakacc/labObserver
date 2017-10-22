package controller;

import view.PainelCentral;
import view.Quiosque;
import view.TerminalView;

public class Rodoviaria {
	
	private Terminal terminal;
	private Quiosque quiosque;
	private PainelCentral painelCentral;
	private TerminalView terminalView;
	
	public Rodoviaria() {
		this.quiosque = new Quiosque();
		this.painelCentral = new PainelCentral();
		
		this.terminal = new Terminal();
		this.terminal.addTerminalListener(quiosque);
		this.terminal.addTerminalListener(painelCentral);
		
		this.terminalView = new TerminalView(this.terminal);
		this.terminalView.montarTela();
	}
	
	public static void main(String[] args) {
		new Rodoviaria();
	}

}
