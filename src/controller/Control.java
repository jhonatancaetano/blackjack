//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.Banca;
public class Control extends JPanel {
	public Control() {

	      addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
	            System.out.println((int)me.getX()); 
	            System.out.println((int)me.getY());
	          } 
	        }); 

	  }
	
	 public static void main(String[] args) {
		    JFrame frame = new JFrame();
		    Control controle =new Control();
		    //Banca banca = new Banca();
		    frame.add(controle);
            //frame.add(banca);
            //banca.mostra_botoes(frame);
		    
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    frame.pack();
		    frame.setSize(1200, 700);
		    frame.setVisible(true);
		  }
		}

