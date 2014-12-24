import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PopTheBubble {
	private static final int START_NUMBER = 4;
	static int frame = 0;
	public static Bubbles k;
	public static int getIndex;
	static int point=0;
	static JLabel points=new JLabel();

	public static void main(String[] args) {
		k = new Bubbles(START_NUMBER);
		DisappearListener disappear = new DisappearListener();
		JFrame window = new JFrame("Pop the Bubble");
		window.setSize(600, 400);
		window.setLocation(400, 200);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		//kreiram panel
		NasPanel mojPanel = new NasPanel();
		mojPanel.addMouseListener(disappear);
		mojPanel.setBackground(Color.YELLOW);
		mojPanel.add(points);
		//dodajem panel na frame
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
//crtanje
		private void drawFrame(Graphics g, int frame) {
			for (int i = 0; i < k.getBubbles().length; i++) {
				k.getBubbles()[i].move(frame);
				k.getBubbles()[i].draw(g, frame);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}
//ispituje da li je kliknut krug ili ne
	public static class DisappearListener implements MouseListener {

		@Override
		public void mousePressed(MouseEvent e) {
			if (inRange(e.getX(), e.getY())){
				k.addBubble(k.getBubbles(), getIndex);
			point++;
			points.setText(String.valueOf(point)); //povecava broj poena
			}
			//prosiruje niz
			else
				k.expandBubble();

		}
//da li je klik u okviru kruga
		private boolean inRange(int x, int y) {
			for (int i = 0; i < k.getBubbles().length; i++) {
				if ((x > k.getBubbles()[i].getPositionX())
						&& (x < k.getBubbles()[i].getPositionX() + 20)
						&& (y > k.getBubbles()[i].getPositionY())
						&& (y < k.getBubbles()[i].getPositionY() + 20)) {
					getIndex = i;
					return true;
				}
			}
			return false;
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

}