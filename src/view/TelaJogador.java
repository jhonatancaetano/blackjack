//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package view;
import model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TelaJogador extends JPanel{
	
	private BufferedImage image;
	private BufferedImage deck1;
	private BufferedImage deck2;
	private BufferedImage carta_desvirada_dealer;
	private BufferedImage carta_virada_dealer;
	private BufferedImage carta_virada;
  	JLabel point_carta = new JLabel("Pontos");
	JLabel point_credito = new JLabel("Credito Disponivel");
	JLabel val_aposta = new JLabel("Valor da Aposta " + String.valueOf(Jogo.somaApostas));
    JButton encerrar = new JButton("Sair");
    JButton rodada = new JButton("Nova Rodada");
    JButton salvar = new JButton("Salvar");
    JButton split = new JButton("Split");
    JButton double1 = new JButton("Double");
    JButton hit = new JButton("Hit");
    JButton stand = new JButton("Stand");
	
	public TelaJogador() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
			carta_desvirada_dealer = ImageIO.read(getClass().getResourceAsStream("/deck1.gif"));
			
			/*if(Jogo.endereco!=null) {
				carta_virada_dealer = ImageIO.read(getClass().getResourceAsStream(Jogo.endereco));
			}*/
			//carta_virada = ImageIO.read(getClass().getResourceAsStream(Jogo.endereco));
			//deck1 = ImageIO.read(getClass().getResourceAsStream("/deck1.gif"));
			//deck2 = ImageIO.read(getClass().getResourceAsStream("/deck2.gif"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void paintComponent(Graphics g) {	
		try {
			//image = ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
			//carta_desvirada_dealer = ImageIO.read(getClass().getResourceAsStream());
			if(Jogo.endereco!=null) {
				carta_virada = ImageIO.read(getClass().getResourceAsStream(Jogo.endereco));
				carta_virada_dealer = ImageIO.read(getClass().getResourceAsStream(Jogo.dealer_desv));
			}
			//carta_virada = ImageIO.read(getClass().getResourceAsStream(Jogo.endereco));
			//deck1 = ImageIO.read(getClass().getResourceAsStream("/deck1.gif"));
			//deck2 = ImageIO.read(getClass().getResourceAsStream("/deck2.gif"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
			//g.drawImage(image, 0, 0, 1200, 700, null);
			g.drawImage(image, 200, 0, 1000, 700, null);
			g.drawImage(carta_virada, 550, 350,180, 200, null);
			g.drawImage(carta_virada_dealer, 500, 50,180, 200, null);
			g.drawImage(carta_desvirada_dealer, 550, 50,180, 200, null);
			g.drawImage(deck1, 135, 30,90, 110, null);
			g.drawImage(deck2, 45, 30,90, 110, null);
			
			
			val_aposta.setText("Valor da Aposta: " + String.valueOf(Jogo.somaApostas));
			
			repaint();
	}
		
	public void mostra_botoes(JFrame frame) {
        
        point_carta.setBounds(750, 400, 130, 60);
        point_carta.setForeground(Color.white);
        point_carta.setFont(new Font("Serif", Font.PLAIN, 22));
        frame.add(point_carta);
        
        point_credito.setBounds(1000, 550, 130, 60);
        point_credito.setForeground(Color.white);
        point_credito.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(point_credito);
        
        val_aposta.setBounds(1000, 515, 130, 60);
        val_aposta.setForeground(Color.white);
        val_aposta.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(val_aposta);
        
        encerrar.setBounds(20, 590, 120, 40);
        frame.add(encerrar);
        
        rodada.setBounds(20, 490, 120, 40);
        frame.add(rodada);
        
        salvar.setBounds(20, 540, 120, 40);
        frame.add(salvar);
        
        split.setBounds(20, 390, 120, 40);
        frame.add(split);
        
        double1.setBounds(20, 440, 120, 40);
        frame.add(double1);
        
        hit.setBounds(20, 340, 120, 40);
        frame.add(hit);
        
        stand.setBounds(20, 290, 120, 40);
        frame.add(stand);
        
        frame.setTitle("BlackJack - Jogador");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new TelaJogador());
        frame.pack();
        
        frame.setSize(1200, 700);
        
        stand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            	Jogo.stand_jogo();
             }
        });
        
        hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            	Jogo.hit_jogo();
             }
        });
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            	Jogo.salvarJogo();
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
        double1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Jogo.double_jogo();
            }
            
        });
		
	}


}
