//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JogoTest {
	Jogo jogo1 = null;
	Jogador Ivan = new Jogador();
	Jogador Guilherme = new Jogador();
	Jogador Joanne = new Jogador();
	Jogador Jhonatan = new Jogador();
	Baralho bar = new Baralho();
	ArrayList list = new ArrayList();
	
	//Testando vencedores
	@Test
	public void test_vencedor() {
		jogo1 = new Jogo();
		jogo1.maiorPontuacao = 50;
		Ivan.setNome("Ivan");
		Ivan.setPontuacao(50);
		Joanne.setNome("Joanne");
		Joanne.setPontuacao(40);
		Guilherme.setNome("Guilherme");
		Guilherme.setPontuacao(20);
		Jhonatan.setNome("Jhonatan");
		Jhonatan.setPontuacao(10);
		list.add(Guilherme);
		list.add(Joanne);
		list.add(Jhonatan);
		list.add(Ivan);
		jogo1.jogadores = list;
		jogo1.vencedor();
		
	}
	
	//Testando a exibicao da mesa
	@Test
	public void test_mmesa() {
		jogo1 = new Jogo();
		Carta card = new Carta(7, "Copas", false, "Carta_7", "/7h.gif");
		ArrayList list = new ArrayList();
		list.add(card);
		
		Ivan.setNome("Ivan");
		Ivan.setPontuacao(50);
		
		Joanne.setNome("Joanne");
		Joanne.setPontuacao(40);
	
		Guilherme.setNome("Guilherme");
		Guilherme.setPontuacao(20);
		
		Jhonatan.setNome("Jhonatan");
		Jhonatan.setPontuacao(10);
			
		jogo1.mostrarMesa();
	}
	
	//Testando a funcao jogar
	@Test
	public void test_jogar() {
		jogo1 = new Jogo();
		Baralho bar1 = new Baralho();
		
		Ivan.setNome("Ivan");
		jogo1.jogar(Ivan, bar);
	}

}
