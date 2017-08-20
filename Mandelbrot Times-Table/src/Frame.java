import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
public class Frame extends JFrame{
	
	Screen s;

	public Frame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setTitle("Mandelbrot Times-Table");
		
		init();
		
	}
	
	public void init(){
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(1, 1, 0, 0));
		
		s = new Screen();
		add(s);
		
		setVisible(true);
	}
	
	public static void main(String args[]){
		new Frame();
	}


}
