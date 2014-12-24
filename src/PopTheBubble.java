import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class PopTheBubble {
	static int frame = 0;
	public static Circle[] k1 = new Circle[4];
	public PopTheBubble(){
	for (int i = 0; i < 4; i++) {
		k1[i] = new Circle((int) (Math.random() * (600 - 100)),
				(int) (Math.random() * (400 - 100)), 100, Color.RED);
		}
	}
	public static void main(String[] args) {

		JFrame window = new JFrame("Pop the Bubble");
		window.setSize(600, 400);

		window.setLocation(400, 200);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
PopTheBubble pop=new PopTheBubble();
		NasPanel mojPanel = new NasPanel();
		mojPanel.setBackground(Color.BLACK);
		window.add(mojPanel);
		BevelBorder border=new BevelBorder(1);
		mojPanel.setBorder(border);
		window.setVisible(true);
		 Timer frameTimer = new Timer(40,mojPanel);
		 frameTimer.start();
		 
	}

	public static class NasPanel extends JPanel implements ActionListener {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int direction=1;
			if(k1[0].getPositionX()==599 || k1[0].getPositionX()==1)
			direction*=-1;	
			if(k1[0].getPositionY()==399 || k1[0].getPositionY()==1)
				direction*=1;

			drawFrame(g,frame+=direction);
		}

		private void drawFrame(Graphics g, int frame) {
			
			for(Circle k:k1 ){
				k.draw(g,frame--);
				k.move(frame--);
			}
				// g.setColor(Color.BLUE);
				// g.fillOval((int)(Math.random()*(600-100)),(int)(Math.random()*(400-100)),
				// 100, 100);
			}

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
			
		}

		
	}