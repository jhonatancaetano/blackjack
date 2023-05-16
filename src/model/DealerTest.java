//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DealerTest {
	
	//Criando e testando o deler
	Carta card_dealer = new Carta(11, "Copas", true, "As", "/as.gif");
	ArrayList array_card = new ArrayList();
	Dealer d = new Dealer(7, card_dealer, array_card);
	
	//testando pontuação
	@Test
	public void test_point() {		
		d.setPontuacao(card_dealer.getValor());
		assertEquals("Vendo se o valor da carta foi realmente inserido",11, d.getPontuacao());
	}
	
	//testando virada de carta, carta oculta vai ficar null
	@Test
	public void test_vira() {
		d.virarCarta();
		assertNull("Vendo se a carta virou e se a variavel de controle ficou null",d.cartaOculta);
	}
	
	//testando a adicao de uma nova carta
	@Test
	public void test_adiciona() {
		Carta card_dealer_1 = new Carta(7, "Paus", false, "Carta_7", "/7c.gif");
		d.adiciona(card_dealer_1);
		//Observar que o dealer já tinha 7 criado lá em cima
		assertEquals("verificando se a carta foi adicionada atraves do valor",14, d.getPontuacao());
	}

}
