import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PopTheBubble {
	final static int START_NUMBER = 4;
	static int frame = 0;
	public static Circle[] k1 = new Circle[START_NUMBER];
	public static int getIndex;

	public static void createBubbles(int number) {
		for (int i = 0; i < number; i++) {
			createBubble(k1,i);
		}
	}

	public static void createBubble(Circle[] circ, int index) {
		circ[index] = new Circle((int) (Math.random() * (600 - 100)),
				(int) (Math.random() * (400 - 100)), 20, Color.RED);
	}

	public static void main(String[] args) {
		DisappearListener disappear = new DisappearListener();
		JFrame window = new JFrame("Pop the Bubble");
		window.setSize(600, 400);
		window.setLocation(400, 200);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		createBubbles(START_NUMBER);
		NasPanel mojPanel = new NasPanel();
		mojPanel.addMouseListener(disappear);
		mojPanel.setBackground(Color.BLACK);
		window.add(mojPanel);
		window.setVisible(true);
		Timer frameTimer = new Timer(10, mojPanel);
		frameTimer.start();

	}

	public static class NasPanel extends JPanel implements ActionListener {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawFrame(g, frame++);
		}

		private void drawFrame(Graphics g, int frame) {

			for (Circle k : k1) {
				k.move(frame);
				k.draw(g, frame);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}

	public static class DisappearListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (inRange(e.getX(), e.getY()))
				createBubble(k1, getIndex);
			else
				addNewBubble();

		}

		private void addNewBubble() {
			Circle[] tmp = new Circle[k1.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				tmp[i] = k1[i];
				if (i == tmp.length - 1) {
					createBubble(tmp, i);
				}

			}

		}

		private boolean inRange(int x, int y) {
			for (int i = 0; i < k1.length; i++) {
				if ((x > k1[i].getPositionX())
						&& (x < k1[i].getPositionX() + 20)
						&& (y > k1[i].getPositionY())
						&& (y < k1[i].getPositionY() + 20)) {
					getIndex = i;
					return true;
				}
			}
			return false;
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

}