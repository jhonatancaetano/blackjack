//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import model.Jogador;
import model.Jogo;
import view.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Inicial extends JPanel {
	
	public static ArrayList<String> jogadores;
	private BufferedImage image;
	
    
	@Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Define rendering hint, font name, font style and font size
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 40));
     
    }

    public void mostra_botoes(JFrame frame) {
    	
    	jogadores = new ArrayList<String>();       
    	
        JLabel blackjack = new JLabel("BlackJack");
        
        JButton novo = new JButton("Novo Jogo");
        
        JButton continua_jogo = new JButton("Continuar Jogo");
        
        novo.setBounds(430, 230, 100, 50);
        frame.add(novo);
        continua_jogo.setBounds(600, 230, 150, 50);
        frame.add(continua_jogo);
        blackjack.setBounds(470, 30, 300, 300);
        blackjack.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 40));
        frame.add(blackjack);
        
        frame.setTitle("BlackJack - Inicial");
       
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        frame.add(new Inicial());
        frame.pack();
        frame.setSize(1200, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String num;
            	String jogador1 = null;
            	String jogador2 = null;
            	String jogador3 = null;
            	String jogador4 = null;
            	
            	StringBuilder mensagem = new StringBuilder();
            	num = JOptionPane.showInputDialog("Digite a quantidade de jogadores:");
            	
               
                int numero = Integer.parseInt(num);
                System.out.println(numero);
                
                if(numero < 1 || numero > 4) {
                	mensagem.append("O n�mero de jogadores � inv�lido! ");
                	JOptionPane.showMessageDialog(null, mensagem);
                	num = JOptionPane.showInputDialog("Digite a quantidade de jogadores entre 1 e 4:");
                	numero = Integer.parseInt(num);
                	
                }
                
                if (numero == 1) {
                	
                	mensagem.append("A quantidade de Jogadores � ").append(numero).append("!");
                	jogador1 = JOptionPane.showInputDialog("Digite o nome do jogador 1:");
                	jogadores.add(jogador1);
                }
                else if(numero == 2) {
                	mensagem.append("A quantidade de Jogadores � ").append(numero).append("!");
                	jogador1 = JOptionPane.showInputDialog("Digite o nome do jogador 1:");
                	jogador2 = JOptionPane.showInputDialog("Digite o nome do jogador 2:");
                	jogadores.add(jogador1);
                	jogadores.add(jogador2);
                }
                else if(numero == 3) {
                	mensagem.append("A quantidade de Jogadores � ").append(numero).append("!");
                	jogador1 = JOptionPane.showInputDialog("Digite o nome do jogador 1:");
                	jogador2 = JOptionPane.showInputDialog("Digite o nome do jogador 2:");
                	jogador3 = JOptionPane.showInputDialog("Digite o nome do jogador 3:");
                	jogadores.add(jogador1);
                	jogadores.add(jogador2);
                	jogadores.add(jogador3);
                }else if(numero == 4) {
                	mensagem.append("A quantidade de Jogadores � ").append(numero).append("!");
                	jogador1 = JOptionPane.showInputDialog("Digite o nome do jogador 1:");
                	jogador2 = JOptionPane.showInputDialog("Digite o nome do jogador 2:");
                	jogador3 = JOptionPane.showInputDialog("Digite o nome do jogador 3:");
                	jogador4 = JOptionPane.showInputDialog("Digite o nome do jogador 4:");
                	jogadores.add(jogador1);
                	jogadores.add(jogador2);
                	jogadores.add(jogador3);
                	jogadores.add(jogador4);
                }else {
                	mensagem.append("O n�mero de jogadores � inv�lido! ");
                	JOptionPane.showMessageDialog(null, mensagem);
                }  
                
                System.out.println(jogadores);
                
            	Jogo.iniciarJogo(jogadores);
            	
            	frame.remove(novo);
            	frame.remove(continua_jogo);
            	frame.remove(blackjack);
                Banca banca = new Banca();
        		frame.add(banca);
                frame.pack();
        		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                banca.mostra_botoes(frame);
                frame.setVisible(true);
                
             }
        });
           
    } 
   
}
