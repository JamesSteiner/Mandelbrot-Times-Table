import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener{

	Timer tm = new Timer(100, (ActionListener) this); 

	double pi = Math.PI;
	boolean animate;
	public Screen(){
		repaint();
	}
	
	public void paint(Graphics g){
		//please ignore, i am still working on animate
		animate = false;
		
		//parameters
		int radius = 300;
		//alter this variable for different results
		int points_number = 200;
		int[] xpoints = new int[points_number];
		int[] ypoints = new int[points_number];

		//draw circle
		g.setColor(Color.BLACK);
		g.drawArc(250, 150, radius, radius, 0, 360);
		
		//draw points
		double angle_increment = 360 / points_number;
		double a;
		int xpoint;
		int ypoint;
		for(int i = 0; i < points_number; i++){
			a = i*angle_increment;
			int xcenter = 400 - 2;
			int ycenter = 300 - 2;
			xpoint = (int) (Math.cos(a)*radius/2) + xcenter;
			ypoint = (int) (Math.sin(a)*radius/2) + ycenter;
			g.fillOval(xpoint, ypoint, 4, 4);
			xpoints[i] = xpoint;
			ypoints[i] = ypoint;
		}
		//please ignore
		if (animate == true){
			for(double table = 0.0000001; table < points_number; table += 0.0000000001){
				for(int i = 0; i < points_number; i++){
					int[] values = animate(points_number, xpoints, ypoints, table, i);
					g.drawLine(values[0], values[1], values[2], values[3]);
				}
			}
		}else{
			//parameters
			//alter this variable as you like
			int table = 7;
		
			//draw lines
			for(int i = 0; i < points_number; i++){
				int[] values = getLineValues(xpoints, ypoints, table, points_number, i);
				g.drawLine(values[0], values[1], values[2], values[3]);
			}
		}
		
	}
	
	public static int[] getLineValues(int[] xpoints, int[] ypoints, double table, int points_number, int i){
		int[] values = new int[4];
		values[0] = xpoints[i];
		values[1]= ypoints[i];
		values[2] = xpoints[(int) Math.floor((i*table) % points_number)];
		values[3] = ypoints[(int) Math.floor((i*table) % points_number)];
		return values;
	}
	
	public static int[] animate(int points_number, int[] xpoints, int[] ypoints, double table, int i){
		int[] values = getLineValues(xpoints, ypoints, table, points_number, i);
		return values;
	}

	//please ignore, this does nothing as yet
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tm.start();
		
		
		repaint();
	}
	
}
