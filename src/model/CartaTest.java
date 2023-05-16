//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartaTest {
	
	Carta card = new Carta(7,"Copas", false, "Carta_7", "/7s.gif");

	//Verificando o valor da carta
	@Test
	public void val_card() {
		assertSame(7, card.getValor());
	}
	
	//Verificando o naipe da carta
	@Test
	public void naipe_card() {
		assertNotSame("Paus", card.getNaipe());
	}
	
	//Verificando o valor booleano da carta
	@Test
	public void val__bool_card() {
		assertFalse(card.getAce());
	}
	
	//Verificando o nome da carta
	@Test
	public void nome_card() {
		assertNotSame("3 de Espadas", card.getNome());
	}
	
	//Verificando o insercao do valor da carta
	@Test
	public void val__card() {
		card.setValor(6);
		assertNotSame(7, card.getValor());
	}
		
	//Verificando a insercao do naipe da carta
	@Test
	public void naipe__card() {
		card.setNaipe("Espadas");
		assertNotSame("Paus", card.getNaipe());
	}
		
	//Verificando a insercao do valor booleano da carta
	@Test
	public void val__bool__card() {
		card.setAce(true);
		assertTrue(card.getAce());
	}
		
	//Verificando a insercao do nome da carta
	@Test
	public void nome__card() {
		card.setNome("As de Copas");
		assertNotSame("3 de Espadas", card.getNome());
	}

}
