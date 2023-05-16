//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Controller;
import model.Jogador;
import view.*;

import javax.swing.*;
import java.awt.*;

public class Blackjack {
	
	public static Controller frame = new Controller();
	
	public static void main(String[] args) {
		
		frame.setTitle("BlackJack - Inicial");
		
		mostrarTelaInicial();
        
    }
	
	public static void mostrarTelaInicial() {
		Inicial inicial = new Inicial();
		frame.add(inicial);
        frame.pack();
        //frame.setSize(1200, 700);
        inicial.mostra_botoes(frame);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	}
	}


