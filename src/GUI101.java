import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI101 {
	public static void main(String args[]){
	JFrame okvir=new JFrame();
	okvir.setName("Muskatovec");
	okvir.setSize(300, 300);
	Dimension dim=new Dimension(600,600);
	okvir.setMaximumSize(dim);
	JPanel panel=new JPanel();
	okvir.setContentPane(panel);
	JButton kelef=new JButton ("KUSLATA");
	ButtonHandler listen=new ButtonHandler();
	panel.add(kelef);
	panel.add(new JButton ("KOSLAZTRAAA"));
	kelef.addActionListener(listen);
	okvir.setVisible(true);
	}
	private static class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("CLICK");
			JButton b=(JButton)e.getSource();
			b.setText("KLIKNUTO");
 			
		}
		
	}
}
