//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import java.util.ArrayList;

public class Jogador {
	
	public ArrayList<Carta> mao_jogador;
	public int pontuacao;
	
	public Jogador(){
		this.pontuacao = 0;
		this.mao_jogador = new ArrayList<Carta>();
	}
	
	public void adicionarCarta(Carta carta){
		this.pontuacao += carta.getValor();
		this.mao_jogador.add(carta);	
	}

	public ArrayList<Carta> getMao_jogador() {
		return mao_jogador;
	}

	public void setMao_jogador(ArrayList<Carta> mao_jogador) {
		this.mao_jogador = mao_jogador;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}