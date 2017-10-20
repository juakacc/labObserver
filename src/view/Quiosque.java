package view;

import java.util.Map;
import java.util.Set;

import controller.Terminal;
import controller.TerminalEvent;
import controller.TerminalListener;

public class Quiosque implements TerminalListener {

	@Override
	public void atualizarPassagens(TerminalEvent t) {
		Terminal terminal = (Terminal) t.getSource();
		Map<Integer, Character> situacao = terminal.getBus().getBus();
		Set<Integer> keySet = situacao.keySet();
		
		menu();
		
		for (Integer integer : keySet) {
			System.out.println(integer + " -> " +situacao.get(integer));
		}
	}
	
	private void menu() {
		System.out.println("-----------------");
		System.out.println("| V - Vago      |");
		System.out.println("| R - Reservado |");
		System.out.println("| O - Ocupado   |");
		System.out.println("-----------------");
	}
}
