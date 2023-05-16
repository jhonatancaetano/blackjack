//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package model;
import view.*;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;
import javax.swing.JOptionPane;

import java.util.Observable;
import java.util.Observer;

public class Jogo extends Observable {
	public static ArrayList<JogadorHumano> jogadores;
	public static Dealer dealer;
	public static Baralho baralho;
	public static int opcao;
	public static int opcaoJogo = 1;
	public static int maiorPontuacao = 0;
	private static Scanner in = new Scanner(System.in);
	private static Jogo jogo = null;
	public static int vez = -1;
	public static boolean apostando;
	public static int ultimaAposta = -1;
	public static int somaApostas = 0;
	public static String endereco;
	public static String dealer_desv;
	public static String dealer_v;
	public static String venceu;
	public Scanner s = null;
    public static File outputStream = null;
	
	private Jogo() {
	}
	
	public static Jogo getJogo() {
		if(jogo == null)
			jogo = new Jogo();
		return jogo;
	}
	
public static void iniciarJogo(ArrayList<String> nomes_jogadores) {
        
        Dealer.getDealer();
        
        jogadores = new ArrayList<JogadorHumano>();
        Baralho.getBaralho().iniciarBaralho();
        
        Baralho.getBaralho().embaralhar();
        
        //Pegar o nome dos jogadores por um controller 
        for (String nome : nomes_jogadores) {
            System.out.println(nome);
            JogadorHumano jogador = new JogadorHumano(nome);
            jogadores.add(jogador);
        }
        //Jogador inicia com credito 500
        for(int i = 0; i < jogadores.size(); i++) {            
            jogadores.get(i).credito = 500;
            
            System.out.println("Credito eh " + jogadores.get(i).getCredito());
        }
        
        apostando = true;
        
        passar_a_vez();
        
    }
	
public static void apostar (int qtd) {
    if (vez <= 0 || vez > jogadores.size()) return;
    
    if (jogadores.get(vez-1).ficha.apostar(qtd) == true) {
        jogadores.get(vez-1).credito -= qtd;
        ultimaAposta = qtd;
        somaApostas += ultimaAposta;
    }
    
    System.out.println(String.format("qtd fichas apostadas do jogador %d:", vez));
    System.out.println(jogadores.get(vez-1).ficha.pilha_apostas.size());
    System.out.println(String.format("total de fichas apostadas do jogador %d:", vez));
    System.out.println(somaApostas);
    System.out.println(String.format("total de credito %d:", vez));
    System.out.println(jogadores.get(vez-1).getCredito());
}
	
public static void removerAposta () {
    if (vez <= 0 || vez > jogadores.size()) return;
    
    int tamanho = jogadores.get(vez-1).ficha.pilha_apostas.size();
    
    if(tamanho >= 2) {
        ultimaAposta = jogadores.get(vez-1).ficha.pilha_apostas.get(tamanho-2);
        somaApostas -= jogadores.get(vez-1).ficha.pilha_apostas.get(tamanho-1);
        jogadores.get(vez-1).credito += jogadores.get(vez-1).ficha.pilha_apostas.get(tamanho-1);
    }
    else if (tamanho == 1) {
        ultimaAposta = -1;
        somaApostas -= jogadores.get(vez-1).ficha.pilha_apostas.get(tamanho-1);
        jogadores.get(vez-1).credito +=  jogadores.get(vez-1).ficha.pilha_apostas.get(tamanho-1);
    }
    
    jogadores.get(vez-1).ficha.remover_aposta();
    
    System.out.println(String.format("qtd fichas apostadas do jogador %d:", vez));
    System.out.println(jogadores.get(vez-1).ficha.pilha_apostas.size());
    System.out.println(String.format("total de fichas apostadas do jogador %d:", vez));
    System.out.println(somaApostas);
    System.out.println(String.format("total de credito %d:", vez));
    System.out.println(jogadores.get(vez-1).getCredito());
}
	
	public static void confirmarAposta() {
		if (somaApostas >= 20 && somaApostas <= 100) {
			Dealer.getDealer().cacife += somaApostas;
			jogadores.get(vez-1).ficha.pilha_apostas.clear();
			somaApostas = 0;
			ultimaAposta = -1;
			passar_a_vez();
		}
		else {
			System.out.println("Valor da aposta deve estar entre 20 e 100!");
		}
	}
	
	public static void distribuirCartas () {
		for(int i = 1; i <= 2; i++){
			for(JogadorHumano j: jogadores){
				j.adicionarCarta(Baralho.getBaralho().removerCarta());
				System.out.println("Jogadores");
				System.out.println(j.getNome());
				System.out.println(j.getPontuacao());
			}
		}
		Dealer.getDealer().adicionaCartaOculta(Baralho.getBaralho().removerCarta());
		Dealer.getDealer().adicionarCarta(Baralho.getBaralho().removerCarta());
		System.out.println("Dealer");
		System.out.println(Dealer.getDealer().getPontuacao());
		Dealer.getDealer().virarCarta();
		System.out.println(Dealer.getDealer().getPontuacao());
		
	}
	
	public static void rodada() {
		//se um jogador saiu, se os jogadores tem fichas suficentes para uma nova rodada,o vencedor da rodada anterior tem que ganhar as fichas que foram apostadas na rodada anterior
		
	}
	
	public static void double_jogo() {
		  StringBuilder mensagem = new StringBuilder();
          
          if(Jogo.jogadores.get(Jogo.vez-1).credito > 2 *  Jogo.ultimaAposta) {
              
              Jogo.jogadores.get(Jogo.vez-1).credito -= Jogo.ultimaAposta;
              System.out.println("A aposta eh " + Jogo.somaApostas);
              Jogo.somaApostas = 2 * Jogo.somaApostas;
              System.out.println("A aposta eh " + Jogo.somaApostas);
              Jogo.hit_jogo();
          }else {
              mensagem.append("Voce nao tem credito suficiente para fazer um Double!");
              JOptionPane.showMessageDialog(null, mensagem);
          }
         
	}
	public static void salvarJogo() {
		//salvar qtd de jogadores, mï¿½o, pontuaï¿½ï¿½o, baralho, aposta, fichas disponiveis
		//salvar qtd de jogadores, vez do jogador,mï¿½o, pontuaï¿½ï¿½o, baralho, aposta, fichas disponiveis
        //capitulo 16//entrada formatada,usar scanner
        //se esta pedindo carta ele nao pode salvar, ele so pode salvar depois das jogadas
        //Quant jogadores,vezdojogador,guardar a lista de fichas,guardar as cartas
		
		
            outputStream = new File("saida.txt");
            try {
                if(!outputStream.exists()) {
                    //cria se for vazio
                    outputStream.createNewFile();
                }
                
                //escreve no arquivo
                FileWriter escreve = new FileWriter(outputStream, true);
                BufferedWriter bw = new BufferedWriter(escreve);
                bw.write("Jogadores "+String.valueOf(jogadores.size()));
                bw.newLine();
                bw.write("vez "+String.valueOf(vez));
                bw.newLine();
                //salvando Jogadores
                for(int i=0;i<jogadores.size();i++) {
                    bw.write("Nome "+String.valueOf(jogadores.get(i).getNome()));
                    bw.newLine();
                    bw.write(" Pont "+String.valueOf(jogadores.get(i).getPontuacao()));
                    bw.newLine();
                    bw.write("Fichas ");
                    bw.write("Cem "+String.valueOf(jogadores.get(i).ficha.getCem()));
                    bw.write(" Cinquenta "+String.valueOf(jogadores.get(i).ficha.getCinquenta()));
                    bw.write(" vinte "+String.valueOf(jogadores.get(i).ficha.getVinte()));
                    bw.write(" Dez "+String.valueOf(jogadores.get(i).ficha.getDez()));
                    bw.write(" Cinco "+String.valueOf(jogadores.get(i).ficha.getCinco()));
                    bw.write(" Um "+String.valueOf(jogadores.get(i).ficha.getUm()));
                    bw.newLine();
                    bw.write("Mao ");
                    for(int j=0;j<jogadores.get(i).mao_jogador.size();j++) {
                    	bw.write("ace "+String.valueOf(jogadores.get(i).mao_jogador.get(j).getAce()));
                    	bw.write(" img "+String.valueOf(jogadores.get(i).mao_jogador.get(j).getImg()));
                    	bw.write(" nome "+String.valueOf(jogadores.get(i).mao_jogador.get(j).getNome()));
                    	bw.write(" valor "+String.valueOf(jogadores.get(i).mao_jogador.get(j).getValor()));
                    	bw.newLine();
                    }
                }
                bw.write("Baralho ");
                
                
                bw.close();
                escreve.close();

            }catch (IOException ex) {
                ex.printStackTrace();
            }

	}
	
	public static void  retornarJogo() {
		
		
		/*outputStream = new File("saida.txt");
		FileReader fr = new FileReader(outputStream);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> nomes_jogadores;//nome dos jogadores
			//enquanto houver mais linhas
			while (br.ready()) {
			//lê a proxima linha
			String linha = br.readLine();
			//faz algo com a linha
			System.out.println(linha);
			if(linha=="Jogadores") {
				nomes_jogadores.add(linha);
			}
			else if(linha=="vez") {
				vez=Integer.parseInt(linha);
				}
			}
			br.close();
			fr.close();
			}*/
}

	
	public static void passar_a_vez() {
	
		
		if (vez >= jogadores.size()) { //Vez do ultimo jogador?
			vez = -1;
		}
		else if (vez <= -1) { //Vez do dealer?
			vez = 1;
		}
		else {
			vez += 1;
		}
	}
	
	
	public static void encerraJogo() {
		
		  int sairSistema;
    
          Object[] options = {"Sim", "Nao"};

              sairSistema = JOptionPane.showOptionDialog(null,
                      "Deseja realmente sair do BlackJack, Caso queira comecar de onde parou nao esqueca de salvar",
                      "", 0, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
             
              if (sairSistema == 0) {
           
              	Jogo.getJogo().jogadores.remove(Jogo.vez-1);
              	//baralho e fichas
              	if(Jogo.jogadores.size()<1) {
              		System.exit(0);
              	}
              	
              }
		
	}
	
	public void distribuirApostas() {
		//verificar ganhar dor e dar toda as apostas para ele
		
	}	
	public static void stand_jogo(){
        if(vez==jogadores.size()) {
            System.out.println("Entrei na Stand");
            //verificar mão dos jogadores 
            //chamar vencedores da rodada
            //vencedor();
        }
        passar_a_vez();
    }
	
	public static void hit_jogo() {
		System.out.println("Mão do jogador pre hit " + jogadores.get(vez-1).getNome());
		jogadores.get(vez-1).adicionarCarta(Baralho.getBaralho().removerCarta());
		endereco =  jogadores.get(vez-1).mao_jogador.get(jogadores.get(vez-1).mao_jogador.size()-1).getImg();
		dealer_desv=Dealer.getDealer().mao_jogador.get(Dealer.getDealer().mao_jogador.size()-1).getImg();
		System.out.println(endereco);
	
	}
	
	public static void vencedor(){
        //chamar a distribuir aposta
        int empates = 0;
        
        //pontuacao dos jogadores < que as do delaer
        for(int i=0; i <= jogadores.size(); i++) {
            if (jogadores.get(vez-i).getPontuacao() >= maiorPontuacao && jogadores.get(vez-i).getPontuacao() <= 21) {
                maiorPontuacao = jogadores.get(vez).getPontuacao();
                
            }
            else if(maiorPontuacao > dealer.getPontuacao()) {
                System.out.println("O jogador venceu!" + jogadores.get(vez - i).getNome());
            }else {
                System.out.println("O dealer venceu!");
            }
        }
        
        for(JogadorHumano j: jogadores){
            
            if(j.getPontuacao() == maiorPontuacao){
                System.out.println(j.getNome() + " Pontos = " + j.getPontuacao());
                empates++;
            }
        }
        if(empates > 1){
            System.out.println("Portanto, empate!");
        }
        
    }
	}
