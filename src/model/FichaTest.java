//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FichaTest {
	
	Fichas fichas_jog = new Fichas();

	//Testando a aposta
	@Test
	public void test_aposta() {
		fichas_jog.apostar(100);
		assertEquals("Comparando a quantidade de apostas com o num de apostas feitas",1, fichas_jog.getCem());
	}
	
	//Testando a remocao da aposta
	@Test
	public void test__remove_aposta() {	
		fichas_jog.apostar(5);
		fichas_jog.apostar(5);
		fichas_jog.apostar(10);
		fichas_jog.apostar(100);
		fichas_jog.remover_aposta();
		int ultimo = fichas_jog.pilha_apostas.get(fichas_jog.pilha_apostas.size() - 1);
		assertSame("Verificando se a remocao esta ok",10, ultimo);
	}
	
	//Testando o recebimento de ficha
	@Test
	public void test_rec_ficha() {
		Fichas jog1 = new Fichas();
		jog1.receber_fichas(1, 1, 1, 1, 1, 1);
		fichas_jog.receber_fichas(1, 3, 5, 7, 9, 11);
		assertNotEquals("Vendo a diferenca das fichas recebidas pelos jogadores",jog1, fichas_jog);
	}
	
	//Testando a insercao na pilha de aposta
	@Test
	public void test_set_pilha_aposta() {
		ArrayList list = new ArrayList();
		ArrayList lista1 = new ArrayList();
		list.add(3);
		list.add(7);
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(9);
		lista1.add(3);
		lista1.add(7);
		lista1.add(1);
		lista1.add(5);
		lista1.add(4);
		lista1.add(9);
		System.out.print(list);
		fichas_jog.setPilha_apostas(list);
		assertEquals("Testando a pilha de apostas",list, lista1);
	}
	
	//Testando a insercao na pilha de aposta
	@Test
	public void test_get_pilha_aposta() {
		ArrayList list = new ArrayList();
		ArrayList lista1 = new ArrayList();
		list.add(3);
		list.add(7);
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(9);
		lista1.add(3);
		lista1.add(7);
		lista1.add(1);
		lista1.add(5);
		lista1.add(4);
		lista1.add(9);
		System.out.print(list);
		fichas_jog.setPilha_apostas(list);
		assertEquals("Testando a pilha de apostas",fichas_jog.get_apostas(), lista1);
	}
	
	//Testando get e set da ficha 1
	@Test
	public void teste_um() {
		fichas_jog.setUm(3);
		assertSame("Testando 1",3, fichas_jog.getUm());
	}
	
	//Testando get e set da ficha 5
	@Test
	public void teste_cinco() {
		fichas_jog.setCinco(5);
		assertNotSame("Testando 5",4, fichas_jog.getCinco());
	}
	
	//Testando get e set da ficha 10
	@Test
	public void teste_dez() {
		fichas_jog.setDez(9);
		assertSame("Testando 10",9, fichas_jog.getDez());
	}
	
	//Testando get e set da ficha 20
	@Test
	public void teste_vinte() {
		fichas_jog.setVinte(6);
		assertNotSame("Testando 20",1, fichas_jog.getVinte());
	}
	
	//Testando get e set da ficha 50
	@Test
	public void teste_cinquenta() {
		fichas_jog.setCinquenta(18);
		assertSame("Testando 50",18, fichas_jog.getCinquenta());
	}
	
	//Testando get e set da ficha 100
	@Test
	public void teste_cem() {
		fichas_jog.setCem(100);
		assertNotSame("Testando 100",99, fichas_jog.getCem());
	}

}
