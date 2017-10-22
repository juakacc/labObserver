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
	
	/**
	 * Adiciona um passageiro ao ônibus
	 * @return O acento ocupado pelo passageiro
	 * @throws OnibusException Caso o ônibus esteja cheio.
	 */
	public int adicionar() throws OnibusException {
		
		for (int i = 0; i < capacidade; i++) {
			if (this.acentos[i] == '-') {
				acentos[i] = 'O';
				return i;
			}
		}
		throw new OnibusException("Ônibus cheio");
	}
	
	/**
	 * Reserva um acento para o passageiro
	 * @return O acento reservado para o passageiro
	 * @throws OnibusException Caso o ônibus esteja cheio.
	 */
	public int reservar() throws OnibusException {
		for (int i = 0; i < capacidade; i++) {
			if (this.acentos[i] == '-') {
				acentos[i] = 'R';
				return i;
			}
		}
		throw new OnibusException("Ônibus cheio");
	}
	
	/**
	 * Cancela a compra/reserva de um acento
	 * @param i Acento a ser liberado
	 */
	public void liberar(int i) {
		acentos[i] = '-';
	}
	
	/**
	 * Recupera a situação dos acentos do ônibus
	 * @return
	 */
	public Character[] getAcentos() {
		return acentos;
	}
	
	/**
	 * Recupera a capacidade de passageiros do ônibus
	 * @return
	 */
	public int getCapacidade() {
		return capacidade;
	}
}