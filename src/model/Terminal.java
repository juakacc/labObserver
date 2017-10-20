package model;

import java.util.ArrayList;
import java.util.List;

import controller.TerminalEvent;
import controller.TerminalListener;

public class Terminal {
	
	private List<TerminalListener> listeners;
	private Onibus bus;
	
	public Terminal() {
		this.listeners = new ArrayList<>();
		this.bus = new Onibus();
	}
	
	public void addTerminalListener(TerminalListener t) {
		this.listeners.add(t);
	}
	
	public void removeTerminalListener(TerminalListener t) {
		this.listeners.remove(t);
	}

	private void onibusAlterou() {
		TerminalEvent e = new TerminalEvent(this);
		
		for (TerminalListener terminalListener : listeners) {
			terminalListener.atualizarPassagens(e);
		}
	}

	public int venderPassagem() throws OnibusCheioException {
		int a = this.bus.adicionar();
		onibusAlterou();
		return a;
	}
	
	public Onibus getBus() {
		return this.bus;
	}

	public int reservarPassagem() throws OnibusCheioException {
		int a = this.bus.reservar();
		onibusAlterou();
		return a;
	}
	
	public boolean cancelarPassagem(int i) {
		if (i >= 0 && i <= this.bus.getCapacidade()) {
			this.bus.liberar(i);
			onibusAlterou();
			return true;
		}
		return false;
	}
}