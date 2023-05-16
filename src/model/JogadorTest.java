//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JogadorTest {
	
	//Cria o jogador com pontuação 0 e mao vazia
	Jogador jog = new Jogador();

	//Verifica a pontuacao do jogador
	@Test
	public void point() {
		assertEquals(0, jog.getPontuacao());
	}
	
	//Verifica a insercao e pontuacao do jogador
	@Test
	public void point1() {
		jog.setPontuacao(3);
		assertEquals(3, jog.getPontuacao());
	}
	
	//Verifica o nome do jogador
	@Test
	public void name() {
		assertNotEquals("Ivan", jog.getNome());
	}
		
	//Verifica a insercao e nome do jogador
	@Test
	public void name1() {
		jog.setNome("Ivan");
		assertEquals("Ivan", jog.getNome());
	}
	
	//Verifica o mao do jogador
	@Test
	public void mao() {
		Array mao = new Array();
		assertNotEquals(mao, jog.getMao_jogador());
	}
			
	//Verifica a insercao e mao do jogador
	@Test
	public void mao1() {
		Carta card = new Carta(4, "Espadas", false, "Carta_4", "/4s.gif");
		ArrayList mao = new ArrayList();
		mao.add(card);
		jog.setMao_jogador(mao);
		assertEquals(card, jog.getMao_jogador().get(0));
	}

}
