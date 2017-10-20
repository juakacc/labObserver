package controller;

import java.util.ArrayList;
import java.util.List;

import model.Onibus;

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

	private void OnibusAlterou() {
		TerminalEvent e = new TerminalEvent(this);
		
		for (TerminalListener terminalListener : listeners) {
			terminalListener.atualizarPassagens(e);
		}
	}

	public void venderPassagem() {
		System.out.println("Seu acento é o: " + this.bus.adicionar());
		OnibusAlterou();
	}
	
	public Onibus getBus() {
		return this.bus;
	}

	public void reservarPassagem() {
		System.out.println("Sua reserva é: " + this.bus.reservar());
		OnibusAlterou();
	}
}