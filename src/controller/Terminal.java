package controller;

import java.util.ArrayList;
import java.util.List;

import model.Onibus;
import model.OnibusException;
import model.TerminalEvent;
import model.TerminalListener;

/**
 * Classe responsável por representar o terminal da rodoviária
 * @author juaka, Patrick
 *
 */
public class Terminal {
	
	private List<TerminalListener> listeners;
	private Onibus bus;
	
	public Terminal() {
		this.listeners = new ArrayList<>();
		this.bus = new Onibus();
	}
	
	/**
	 * Adiciona um Listener a lista de Listeners desse souce
	 * @param t Listerner
	 */
	public void addTerminalListener(TerminalListener t) {
		this.listeners.add(t);
	}
	
	/**
	 * Remove um Listener a lista de Listeners desse souce
	 * @param t Listerner
	 */
	public void removeTerminalListener(TerminalListener t) {
		this.listeners.remove(t);
	}

	/**
	 * Método para notificar Listeners de alteração
	 */
	private void onibusAlterou() {
		TerminalEvent e = new TerminalEvent(this);
		
		for (TerminalListener terminalListener : listeners) {
			terminalListener.atualizarPassagens(e);
		}
	}

	/**
	 * Vende uma passagem
	 * @return O número do acento
	 * @throws OnibusException Caso o ônibus esteja cheio
	 */
	public int venderPassagem() throws OnibusException {
		int a = this.bus.adicionar();
		onibusAlterou();
		return a;
	}
	
	/**
	 * Reserva uma passagem
	 * @return O número do acento
	 * @throws OnibusException Caso o ônibus esteja cheio
	 */
	public int reservarPassagem() throws OnibusException {
		int a = this.bus.reservar();
		onibusAlterou();
		return a;
	}
	
	/**
	 * Cancela uma passagem comprada/reservada
	 * @param i Número do acento
	 * @return
	 */
	public boolean cancelarPassagem(int i) {
		if (i >= 0 && i <= this.bus.getCapacidade()) {
			this.bus.liberar(i);
			onibusAlterou();
			return true;
		}
		return false;
	}
	
	/**
	 * Recupera o ônibus
	 * @return
	 */
	public Onibus getOnibus() {
		return this.bus;
	}
}