//Guilherme Vassalo
//Jhonatan Caetano
//Joanne Carneiro

package controller;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.Banca;
public class Controller extends JFrame implements MouseListener, MouseMotionListener {
//private static final GraphicsConfiguration Events = null;
//private JLabel statusBar;
public Controller()
{
//statusBar = new JLabel();
//getContentPane().add( statusBar, BorderLayout.SOUTH );
// application listens to its own mouse events
addMouseListener( (MouseListener) this );
//addMouseMotionListener( this );

}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	//statusBar.setText( "Pressed at [" + e.getX() +", " + e.getY() + "]" );
	int x,y;
	x = e.getX();
	y = e.getY();
	
	Envia_click(x,y);
	
}

public int[] Envia_click(int x, int y) {
    int []vetor=new int[2];
    vetor[0]=x;
    vetor[1]=y;
    pega(vetor);
    return vetor;

}

public int[] pega(int[] vetor) {
	System.out.println(vetor[0]);
	System.out.println(vetor[1]);
	Banca b = new Banca();
	b.compara_posicao(vetor);
	
	return vetor;
}


/*public static void main( String args[] ) {
	Controller app = new Controller();
	
}*/


@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


}