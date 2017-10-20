package model;

import java.util.HashMap;
import java.util.Map;

public class Onibus {
	
	private Map<Integer, Character> acentos;
	private int index;
	
	public Onibus() {
		this.acentos = new HashMap<>();
		for (int i = 1; i <= 20; i++) {
			this.acentos.put(i, 'V');
		}
		this.index = 1;
	}
	
	
	public Integer adicionar() {
		this.acentos.put(index, 'O');
		int aux = index;
		index++;
		return aux;
	}
	
	public Integer reservar() {
		this.acentos.put(index, 'R');
		int aux = index;
		index++;
		return aux;
	}
	
	public Map<Integer, Character> getBus() {
		return new HashMap<>(acentos);
	}
}
