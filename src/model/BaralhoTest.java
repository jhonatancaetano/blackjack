//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaralhoTest {
	
	Baralho bar_jogo = new Baralho(); //testando a criação de um novo baralho
	
	//Testando Inicializacao, Criacao e Tamanho do Baralho
	@Test
	public void testInicio_e_Tam_baralho() {
		bar_jogo.iniciarBaralho();
		assertEquals("Compara o Baralho Iniciado como Tamanho que ele deve ter",208, bar_jogo.tam_bar());
	}
	
	//Testando Remocao da Carta no Baralho
	@Test
	public void remove_carta_do_baralho() {
		bar_jogo.iniciarBaralho();
		bar_jogo.removerCarta();
		bar_jogo.removerCarta();
		assertEquals("Compara o Baralho Iniciado como duas remocoes feitas",206, bar_jogo.tam_bar());
	}
	
	//Testando a exibição do Baralho
	@Test
	public void exibe() {
		bar_jogo.iniciarBaralho();
		bar_jogo.mostrarBaralho();
	}
	
	//Testando o Baralho Embaralhado
	@Test
	public void exibe_embaralhamento() {
		bar_jogo.iniciarBaralho();
		bar_jogo.embaralhar();
		System.out.println(bar_jogo);
		bar_jogo.mostrarBaralho();
	}
	
}
