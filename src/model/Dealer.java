//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import java.util.ArrayList;

public class Dealer extends Jogador{
	
	int cacife = 0;
	Carta cartaOculta;
	ArrayList<Carta> cartas;
	private static Dealer dealer = null;
	
	private Dealer() {
		
	}
	
	public static Dealer getDealer() {
		if(dealer == null)
			dealer = new Dealer();
		return dealer;
	}
	
	/*public Dealer() {
	}*/
	
	public int getCacife() {
		return cacife;
	}
	
	public void setCacife(int cacife) {
		this.cacife = cacife;
	}
	
	public void virarCarta() {
		this.mao_jogador.add(this.cartaOculta);
		this.pontuacao += cartaOculta.getValor();
		this.cartaOculta = null;
	}
	
	/*public void adiciona(Carta carta){
		this.pontuacao += carta.getValor();
		this.cartas.add(carta);
		
	}*/
	
	public void adicionaCartaOculta(Carta carta) {
		this.cartaOculta = carta;
	}
	
	//Saber quando um hit � arriscado e portanto n�o faz�-lo 
	public void decidirCompra() {
		
	}
	
}
