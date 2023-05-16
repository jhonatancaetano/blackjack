//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;

public class Carta {
	public int valor;//valor da carta
	public String img; 
	public String naipe;
	public boolean ace; //verificar o as 1 ou 11 
	public String nome; 
	
		public Carta (int valor, String naipe, boolean ace, String nome, String img) {
			this.valor = valor;
			this.naipe = naipe;
			this.ace = ace;
			this.nome = nome;
			this.img = img;
		}
		
		public int getValor() {
			return valor;
		}
		
		public void setValor(int valor) {
			this.valor = valor;
		}
		
		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}
		
		public String getNaipe() {
			return naipe;
		}
		
		public void setNaipe(String naipe) {
			this.naipe = naipe;
		}
		
		public boolean getAce() {
			return ace;
		}
		
		public void setAce(boolean ace) {
			this.ace = ace;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
}
