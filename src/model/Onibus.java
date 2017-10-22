package model;

/**
 * Classe responsável por representar um ônibus
 * @author juaka, Patrick
 */
public class Onibus {
	
	private Character[] acentos;
	private int capacidade;
	
	public Onibus() {
		this.capacidade = 20;
		this.acentos = new Character[capacidade];
		
		for (int i = 0; i < capacidade; i++) {
			acentos[i] = '-';
		}
	}
		
	public int adicionar() throws OnibusCheioException {
		
		for (int i = 0; i < capacidade; i++) {
			if (this.acentos[i] == '-') {
				acentos[i] = 'O';
				return i;
			}
		}
		throw new OnibusCheioException();
	}
	
	public int reservar() throws OnibusCheioException {
		for (int i = 0; i < capacidade; i++) {
			if (this.acentos[i] == '-') {
				acentos[i] = 'R';
				return i;
			}
		}
		throw new OnibusCheioException();
	}
	
	public void liberar(int i) {
		acentos[i] = '-';
	}
	
	public Character[] getBus() {
		return acentos;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
}