package model;

import java.util.EventListener;

public interface TerminalListener extends EventListener {

	public void atualizarPassagens(TerminalEvent t);
}