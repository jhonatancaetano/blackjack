//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import java.util.ArrayList;
import java.util.Collections;

class Baralho {
	private static Baralho baralho = null;
	//Passamos a classe array com a classe nao publica cartas
	private ArrayList<Carta> baralho_jogo; 
	
	private Baralho() {
		this.baralho_jogo = new ArrayList<Carta>(); //criamos
	}
	
	public static Baralho getBaralho() {
		if(baralho == null)
			baralho = new Baralho();
		return baralho;
	}
	
	//verifica se o baralho esta vazio, se sim cria um baralho novo
	public void iniciarBaralho() {
		if(baralho_jogo.isEmpty()) {
			criar_Cartas_Baralho();
		}
	}
	
	public void embaralhar(){
		Collections.shuffle(baralho_jogo);
	}
	
	public Carta removerCarta(){
		return this.baralho_jogo.remove(this.baralho_jogo.size() - 1);
	}
	
	public void mostrarBaralho(){
		for(int i = 0; i < baralho_jogo.size(); i++){
			System.out.println(((Carta) baralho_jogo.get(i)).getNome() + " de " + ((Carta) baralho_jogo.get(i)).getNaipe());
		}
	}
	
	public int tam_bar() {
		return baralho_jogo.size();
	}

	public void criar_Cartas_Baralho() {
		Carta cartas_do_baralho; 
		
		//2 Interacao
		//Criar as cartas de uma forma mais eficiente
		
		for(int i = 0; i<1; i++) {
			//criar indice pra fazer a criacao de 2 a 9 simplificada
			for(int c2 =0; c2<4; c2++) {
				cartas_do_baralho = new Carta(2,"Paus", false, "Carta_2", "/2c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c3 =0; c3<4; c3++) {
				cartas_do_baralho = new Carta(3,"Paus", false, "Carta_3", "/3c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c4 =0; c4<4; c4++) {
				cartas_do_baralho = new Carta(4,"Paus", false, "Carta_4", "/4c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c5 =0; c5<4; c5++) {
				cartas_do_baralho = new Carta(5,"Paus", false, "Carta_5", "/5c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c6 =0; c6<4; c6++) {
				cartas_do_baralho = new Carta(6,"Paus", false, "Carta_6", "/6c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c7 =0; c7<4; c7++) {
				cartas_do_baralho = new Carta(7,"Paus", false, "Carta_7", "/7c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c8 =0; c8<4; c8++) {
				cartas_do_baralho = new Carta(8,"Paus", false, "Carta_8", "/8c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(9,"Paus", false, "Carta_9", "/9c.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(10,"Paus", false, "Carta_10", "/tc.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int  j = 0; j<4; j++) {
				cartas_do_baralho = new Carta(10,"Paus", false, "Valete", "/jc.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int q = 0; q<4; q++) {
				cartas_do_baralho = new Carta(10,"Paus", false, "Dama", "/qc.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int k = 0; k<4; k++) {
				cartas_do_baralho = new Carta(10,"Paus", false, "Rei", "/kc.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int a = 0; a<4; a++) {
				cartas_do_baralho = new Carta(11,"Paus", true, "As", "/ac.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
		}
		
		for(int i = 0; i<1; i++) {
			for(int c2 =0; c2<4; c2++) {
				cartas_do_baralho = new Carta(2,"Ouro", false, "Carta_2", "/2d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c3 =0; c3<4; c3++) {
				cartas_do_baralho = new Carta(3,"Ouro", false, "Carta_3", "/3d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c4 =0; c4<4; c4++) {
				cartas_do_baralho = new Carta(4,"Ouro", false, "Carta_4", "/4d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c5 =0; c5<4; c5++) {
				cartas_do_baralho = new Carta(5,"Ouro", false, "Carta_5", "/5d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c6 =0; c6<4; c6++) {
				cartas_do_baralho = new Carta(6,"Ouro", false, "Carta_6", "/6d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c7 =0; c7<4; c7++) {
				cartas_do_baralho = new Carta(7,"Ouro", false, "Carta_7", "/7d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c8 =0; c8<4; c8++) {
				cartas_do_baralho = new Carta(8,"Ouro", false, "Carta_8", "/8d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(9,"Ouro", false, "Carta_9", "/9d.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(10,"Ouro", false, "Carta_10", "/td.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int  j = 0; j<4; j++) {
				cartas_do_baralho = new Carta(10,"Ouro", false, "Valete", "/jd.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int q = 0; q<4; q++) {
				cartas_do_baralho = new Carta(10,"Ouro", false, "Dama", "/qd.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int k = 0; k<4; k++) {
				cartas_do_baralho = new Carta(10,"Ouro", false, "Rei", "/kd.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int a = 0; a<4; a++) {
				cartas_do_baralho = new Carta(11,"Ouro", true, "As", "/ad.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
		}
		
		for(int i = 0; i<1; i++){
			for(int c2 =0; c2<4; c2++) {
				cartas_do_baralho = new Carta(2,"Copas", false, "Carta_2", "/2h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c3 =0; c3<4; c3++) {
				cartas_do_baralho = new Carta(3,"Copas", false, "Carta_3", "/3h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c4 =0; c4<4; c4++) {
				cartas_do_baralho = new Carta(4,"Copas", false, "Carta_4", "/4h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c5 =0; c5<4; c5++) {
				cartas_do_baralho = new Carta(5,"Copas", false, "Carta_5", "/5h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c6 =0; c6<4; c6++) {
				cartas_do_baralho = new Carta(6,"Copas", false, "Carta_6", "/6h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c7 =0; c7<4; c7++) {
				cartas_do_baralho = new Carta(7,"Copas", false, "Carta_7", "/7h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c8 =0; c8<4; c8++) {
				cartas_do_baralho = new Carta(8,"Copas", false, "Carta_8", "/8h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(9,"Copas", false, "Carta_9", "/9h.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(10,"Copas", false, "Carta_10", "/th.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int  j = 0; j<4; j++) {
				cartas_do_baralho = new Carta(10,"Copas", false, "Valete", "/jh.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int q = 0; q<4; q++) {
				cartas_do_baralho = new Carta(10,"Copas", false, "Dama", "/qh.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int k = 0; k<4; k++) {
				cartas_do_baralho = new Carta(10,"Copas", false, "Rei", "/kh.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int a = 0; a<4; a++) {
				cartas_do_baralho = new Carta(11,"Copas", true, "As", "/ah.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
		}
		
		for(int i = 0; i<1; i++) {
			for(int c2 =0; c2<4; c2++) {
				cartas_do_baralho = new Carta(2,"Espada", false, "Carta_2", "/2s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c3 =0; c3<4; c3++) {
				cartas_do_baralho = new Carta(3,"Espada", false, "Carta_3", "/3s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c4 =0; c4<4; c4++) {
				cartas_do_baralho = new Carta(4,"Espada", false, "Carta_4", "/4s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c5 =0; c5<4; c5++) {
				cartas_do_baralho = new Carta(5,"Espada", false, "Carta_5", "/5s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c6 =0; c6<4; c6++) {
				cartas_do_baralho = new Carta(6,"Espada", false, "Carta_6", "/6s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c7 =0; c7<4; c7++) {
				cartas_do_baralho = new Carta(7,"Espada", false, "Carta_7", "/7s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c8 =0; c8<4; c8++) {
				cartas_do_baralho = new Carta(8,"Espada", false, "Carta_8", "/8s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(9,"Espada", false, "Carta_9", "/9s.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int c9 =0; c9<4; c9++) {
				cartas_do_baralho = new Carta(10,"Espada", false, "Carta_10", "/ts.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int  j = 0; j<4; j++) {
				cartas_do_baralho = new Carta(10,"Espada", false, "Valete", "/js.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int q = 0; q<4; q++) {
				cartas_do_baralho = new Carta(10,"Espada", false, "Dama", "/qs.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int k = 0; k<4; k++) {
				cartas_do_baralho = new Carta(10,"Espada", false, "Rei", "/ks.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
			for(int a = 0; a<4; a++) {
				cartas_do_baralho = new Carta(11,"Espada", true, "As", "/as.gif");
				baralho_jogo.add(cartas_do_baralho);
			}
		}
			
	}
	}
