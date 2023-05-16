//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;
import java.util.ArrayList;

class Fichas {
	private int um;
	private int cinco;
	private int dez;
	private int vinte;
	private int cinquenta;
	private int cem;
	public ArrayList<Integer> pilha_apostas;
	
	public Fichas() {
		um = 10;
		cinco = 8;
		dez = 5;
		vinte = 5;
		cinquenta = 2;
		cem = 2;
		pilha_apostas = new ArrayList<Integer>();
	}
	
	public boolean apostar (int ficha) {
		
		boolean fichaValida = true;
		
		if(ficha == 1 && this.um != 0) {
			this.um -= 1;
		}
		else if (ficha == 5 && this.cinco != 0) {
			this.cinco -= 1;
		}
		else if (ficha == 10 && this.dez != 0) {
			this.dez -= 1;
		}
		else if (ficha == 20 && this.vinte != 0) {
			this.vinte -= 1;
		}
		else if (ficha == 50 && this.cinquenta != 0) {
			this.cinquenta -= 1;
		}
		else if (ficha == 100 && this.cem != 0) {
			this.cem -= 1;
		}
		else {
			fichaValida = false;
			System.out.println("Erro, ficha inv�lida!");
		}
		if (fichaValida) {
			pilha_apostas.add(ficha);
			return true;
		}
		return false;
	}
	
	public void remover_aposta() {
		if (!pilha_apostas.isEmpty()) {
			int ultimo = pilha_apostas.get(pilha_apostas.size() - 1);
			
			switch (ultimo) {
			
			case 1: this.um += 1;
			break;
				
			case 5: this.cinco += 1;
			break;
				
			case 10: this.dez += 1;
			break;
				
			case 20: this.vinte += 1;
			break;
			
			case 50: this.cinquenta += 1;
			break;
			
			case 100: this.cem += 1;
			break;
				
			default:
				System.out.println("Erro, retirando ficha inv�lida!");
				break;
			}
			
			pilha_apostas.remove(pilha_apostas.size() - 1);
		}
	}
	
	public void receber_fichas(int um, int cinco, int dez, int vinte, int cinquenta, int cem) {
		this.um += um;
		this.cinco += cinco;
		this.dez += dez;
		this.vinte += vinte;
		this.cinquenta += cinquenta;
		this.cem += cem;
	}
	
	public ArrayList<Integer> get_apostas() {
		return this.pilha_apostas;
	}

	public void setPilha_apostas(ArrayList<Integer> pilha_apostas) {
		this.pilha_apostas = pilha_apostas;
	}
	
	public int getUm() {
		return um;
	}

	public void setUm(int um) {
		this.um = um;
	}

	public int getCinco() {
		return cinco;
	}

	public void setCinco(int cinco) {
		this.cinco = cinco;
	}

	public int getDez() {
		return dez;
	}

	public void setDez(int dez) {
		this.dez = dez;
	}

	public int getVinte() {
		return vinte;
	}

	public void setVinte(int vinte) {
		this.vinte = vinte;
	}

	public int getCinquenta() {
		return cinquenta;
	}

	public void setCinquenta(int cinquenta) {
		this.cinquenta = cinquenta;
	}

	public int getCem() {
		return cem;
	}

	public void setCem(int cem) {
		this.cem = cem;
	}
	
	
}