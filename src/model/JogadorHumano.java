//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

import java.util.ArrayList;

public class JogadorHumano extends Jogador{
	
		public String nome;
		public Fichas ficha;
		public ArrayList<Carta> segunda_mao;
		
		public JogadorHumano(String nome){
			this.nome = nome;
			this.pontuacao = 0;
			this.mao_jogador = new ArrayList<Carta>();
			this.ficha = new Fichas();
			this.segunda_mao = new ArrayList<Carta>();
		}
		
		public Fichas getFicha() {
			return ficha;
		}

		public void setFicha(Fichas ficha) {
			this.ficha = ficha;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		public int credito;
		
		public int getCredito() {
		            return credito;
		        }

		        public void setCredito(int credito) {
		            this.credito = credito;
		        }

}
