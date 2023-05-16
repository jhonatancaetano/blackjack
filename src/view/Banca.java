//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.*;

import model.Carta;
import model.Dealer;
import model.Jogador;
import model.JogadorHumano;
import model.Jogo;

public class Banca extends JPanel {
	
	private BufferedImage image;
	private BufferedImage deck1;
	private BufferedImage deck2;
	private BufferedImage carta_desvirada;
	private BufferedImage carta_virada;
	private BufferedImage ficha_1;
	private BufferedImage ficha_5;
	private BufferedImage ficha_10;
	private BufferedImage ficha_20;
	private BufferedImage ficha_50;
	private BufferedImage ficha_100;
	private BufferedImage ficha_pilha;
	private ArrayList<BufferedImage> img_cartas;
	JLabel point = new JLabel("Pontos: ");
    JButton encerrar = new JButton("Sair");
    JButton deal = new JButton("Deal");
    JButton salvar = new JButton("Salvar");
    JLabel apostador = new JLabel("<html> Jogador " + String.valueOf(Jogo.vez));
    JLabel facasuaaposta = new JLabel("aposte um valor!");
    JLabel totalApostas = new JLabel("Aposta total: " + String.valueOf(Jogo.somaApostas));
	

	public Banca() {
		
		img_cartas = new ArrayList<BufferedImage>();
		try {
			
			for (int i = 0; i < Dealer.getDealer().getMao_jogador().size(); i++) {
				String img_carta = Dealer.getDealer().getMao_jogador().get(i).getImg();
				//System.out.println(i);
				//System.out.println("Imagem da carta do dealer:");
				//System.out.println(img_carta);
				img_cartas.add(ImageIO.read(getClass().getResourceAsStream(img_carta)));
			}
			
			image = ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
			
			carta_desvirada = ImageIO.read(getClass().getResourceAsStream("/deck1.gif"));
			//carta_virada = ImageIO.read(getClass().getResourceAsStream("/4h.gif"));
			deck1 = ImageIO.read(getClass().getResourceAsStream("/deck1.gif"));
			deck2 = ImageIO.read(getClass().getResourceAsStream("/deck2.gif"));
			ficha_1 = ImageIO.read(getClass().getResourceAsStream("/ficha 1$.png"));
			ficha_5 = ImageIO.read(getClass().getResourceAsStream("/ficha 5$.png"));
			ficha_10 = ImageIO.read(getClass().getResourceAsStream("/ficha 10$.png"));
			ficha_20 = ImageIO.read(getClass().getResourceAsStream("/ficha 20$.PNG"));
			ficha_50 = ImageIO.read(getClass().getResourceAsStream("/ficha 50$.png"));
			ficha_100 = ImageIO.read(getClass().getResourceAsStream("/ficha 100$.png"));
			System.out.println(String.format("/ficha %d$.png", Jogo.ultimaAposta));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//repaint();
	}

	public void paintComponent(Graphics g) {
			
			if (Jogo.ultimaAposta > 0) {
				try {
					ficha_pilha = ImageIO.read(getClass().getResourceAsStream(String.format("/ficha %d$.png", Jogo.ultimaAposta)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			g.drawImage(image, 200, 0, 1000, 700, null);
			
			int i = 0;
			for(BufferedImage img: img_cartas){
				
				g.drawImage(img, 550 + i, 350, 180, 200, null);
				i += 80;
			}
			
			//g.drawImage(carta_desvirada, 470, 350,180, 200, null);
			g.drawImage(carta_virada, 550, 350,180, 200, null);
			g.drawImage(deck1, 335, 30,90, 110, null);
			g.drawImage(deck2, 245, 30,90, 110, null);
			g.drawImage(ficha_1, 1020, 550,30, 30, null);
			g.drawImage(ficha_5, 1050, 550,30, 30, null);
			g.drawImage(ficha_10, 1080, 550,30, 30, null);
			g.drawImage(ficha_20, 1020, 580,30, 30, null);
			g.drawImage(ficha_50, 1050, 580,30, 30, null);
			g.drawImage(ficha_100, 1080, 580,30, 30, null);
			if (Jogo.ultimaAposta > 0) {
				g.drawImage(ficha_pilha, 900, 580,30, 30, null);
			}
			
			totalApostas.setText("Aposta total: " + String.valueOf(Jogo.somaApostas));
			
			repaint();
	}
	
    public void mostra_botoes(JFrame frame) {
        
        point.setBounds(20, 50, 120, 40);
        point.setForeground(Color.black);
       
        point.setFont(new Font("Serif", Font.PLAIN, 22));
        frame.add(point);
        
        encerrar.setBounds(20, 590, 120, 40);
        frame.add(encerrar);
        
        deal.setBounds(20, 490, 120, 40);
        frame.add(deal);
        
        salvar.setBounds(20, 540, 120, 40);
        frame.add(salvar);
       
        apostador.setBounds(20, 100, 150, 150);
        apostador.setForeground(Color.black);
        frame.add(apostador);
        
        totalApostas.setBounds(20, 80, 200, 80);
        totalApostas.setForeground(Color.black);   
        frame.add(totalApostas);
        
        facasuaaposta.setBounds(20, 110, 120, 80);
        facasuaaposta.setForeground(Color.black);
        frame.add(facasuaaposta);
        
        frame.setTitle("BlackJack - BANCA");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new Banca());
        frame.pack();
        
        frame.setSize(1200, 700);
        frame.setVisible(true);
        
        deal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	Jogo.confirmarAposta();
            	
				if (Jogo.vez == -1) {
					Jogo.passar_a_vez();
					System.out.println("testando!");
					System.out.println("Mudando para tela do jogador!");
            		
            		frame.getContentPane().removeAll();
            		TelaJogador jogador = new TelaJogador();
            		frame.add(jogador);
            		frame.pack();
            		frame.setTitle("BlackJack - Jogador");
            		
            		Jogo.distribuirCartas();
            		
            		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            		jogador.mostra_botoes(frame);
            		frame.setVisible(true);	
            		
            	}
             }
        });
        encerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	Jogo.encerraJogo();
             }
        });
        
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Jogo.salvarJogo();
            }
        });
       // repaint();
        
    }
    
    public void compara_posicao(int[] vetor) {
    	int deck1[] = {335, 30, 90, 110};
		int deck2[]  = {245, 30,90, 110};
		int ficha_1[] = {1020, 550,30, 30};
		int ficha_5[] = {1050, 550,30, 30};
		int ficha_10[] = {1080, 550,30, 30};
		int ficha_20[] = {1020, 580,30, 30};
		int ficha_50[] = {1050, 580,30, 30};
		int ficha_100[] = {1080, 580,30, 30};
		int ficha_pilha[] = {900, 580,30, 30};
		
		if((vetor[0] >= deck2[0] + 7 && vetor[0] <= (deck1[0] + deck1[2]) + 7) && (vetor[1] >= deck1[1] + 30 && vetor[1] <= (deck1[1] + deck1[3]) + 30) ) {
			
			System.out.println("E uma carta");
		}else
			System.out.println("Nao e uma carta");
		
		if((vetor[0] >= ficha_1[0] + 7 && vetor[0] <= (ficha_1[0] + ficha_1[2]) + 7) && (vetor[1] >= ficha_1[1] + 30 && vetor[1] <= (ficha_1[1] + ficha_1[3]) + 30) ) {
			System.out.println("E uma ficha de 1");
			Jogo.apostar(1);
		}
		else if((vetor[0] >= ficha_5[0] + 7 && vetor[0] <= (ficha_5[0] + ficha_5[2]) + 7) && (vetor[1] >= ficha_5[1] + 30 && vetor[1] <= (ficha_5[1] + ficha_5[3]) + 30) ) {
			System.out.println("E uma ficha de 5");
			Jogo.apostar(5);
		}
		else if((vetor[0] >= ficha_10[0] + 7 && vetor[0] <= (ficha_10[0] + ficha_10[2]) + 7) && (vetor[1] >= ficha_10[1] + 30 && vetor[1] <= (ficha_10[1] + ficha_10[3]) + 30) ) {
			System.out.println("E uma ficha de 10");
			Jogo.apostar(10);
		}
		else if((vetor[0] >= ficha_20[0] + 7 && vetor[0] <= (ficha_20[0] + ficha_20[2]) + 7) && (vetor[1] >= ficha_20[1] + 30 && vetor[1] <= (ficha_20[1] + ficha_20[3]) + 30) ) {
			System.out.println("E uma ficha de 20");
			Jogo.apostar(20);
		}
		else if((vetor[0] >= ficha_50[0] + 7 && vetor[0] <= (ficha_50[0] + ficha_50[2]) + 7) && (vetor[1] >= ficha_50[1] + 30 && vetor[1] <= (ficha_50[1] + ficha_50[3]) + 30) ) {
			System.out.println("E uma ficha de 50");
			Jogo.apostar(50);
		}
		else if((vetor[0] >= ficha_100[0] + 7 && vetor[0] <= (ficha_100[0] + ficha_100[2]) + 7) && (vetor[1] >= ficha_100[1] + 30 && vetor[1] <= (ficha_100[1] + ficha_100[3]) + 30) ) {
			System.out.println("E uma ficha de 100");
			Jogo.apostar(100);
		}
		else if((vetor[0] >= ficha_pilha[0] + 7 && vetor[0] <= (ficha_pilha[0] + ficha_pilha[2]) + 7) && (vetor[1] >= ficha_pilha[1] + 30 && vetor[1] <= (ficha_pilha[1] + ficha_pilha[3]) + 30) ) {
			System.out.println("eh uma ficha da pilha de apostas");
			Jogo.removerAposta();
		}
		else
			System.out.println("Nao e uma ficha ");
    }
    
}


