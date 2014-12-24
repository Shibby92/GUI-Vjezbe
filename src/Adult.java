import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Kreira prozor u kojem korisnik unese broj godina.
 * Izbacuje novi prozor ovisno o tome da li je korisnik
 * punoljetan ili ne
 */
public class Adult {
	static JTextField textBox = new JTextField();

	public static void main(String args[]) {
		// glavni prozor
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		JPanel panel = new JPanel();
		frame.setContentPane(panel);
		JButton ok = new JButton("OK");
		panel.setLayout(new GridLayout(3, 2));
		JTextArea text = new JTextArea("Koliko imate godina?");
		panel.add(text);
		panel.add(textBox);
		panel.add(ok);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// prozor za punoljetan
		final JFrame adult = new JFrame();
		adult.setSize(400, 200);
		adult.setLocation(300, 300);
		JPanel adultPanel = new JPanel(new BorderLayout());
		adult.setContentPane(adultPanel);
		JTextArea adultArea = new JTextArea("PUNOLJETNI STE!");
		adultPanel.add(adultArea, BorderLayout.CENTER);
		// prozor za maloljetan
		final JFrame nadult = new JFrame();
		nadult.setSize(400, 200);
		nadult.setLocation(300, 300);
		JPanel nadultPanel = new JPanel(new BorderLayout());
		nadult.setContentPane(nadultPanel);
		JTextArea nadultArea = new JTextArea("NISTE PUNOLJETNI!");
		nadultPanel.add(nadultArea, BorderLayout.CENTER);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int number = Integer.parseInt(textBox.getText());
				if (number >= 18)
					adult.setVisible(true);
				else
					nadult.setVisible(true);

			}

		});
	}

}
