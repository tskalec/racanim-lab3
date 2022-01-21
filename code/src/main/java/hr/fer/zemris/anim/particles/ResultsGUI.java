package hr.fer.zemris.anim.particles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ResultsGUI extends JFrame {
	
	int redTotal;
	int blackTotal;
	private static final long serialVersionUID = 1L;
	
	public ResultsGUI (int redTotal, int blackTotal) {
		
		this.redTotal = redTotal;
		this.blackTotal = blackTotal;
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocation(10, 10);
		setSize(400, 65);
		initGUI();
		
		setLocationRelativeTo(null);
	
	}

	private void initGUI() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		this.setTitle("Results");
		
		JPanel resultsPanel = new JPanel();
		
		JLabel text = new JLabel();
		
		if (blackTotal < redTotal) {
			resultsPanel.setBackground(Color.decode("0xb30f0f"));
			text.setText("You've painted " + blackTotal + " out of " + (redTotal + blackTotal) + " doors black.");
		} else {
			resultsPanel.setBackground(Color.BLACK);
			text.setText("You've painted " + blackTotal + " out of " + (redTotal + blackTotal) + " doors black. Good job!");
			
		}

		text.setForeground(Color.WHITE);
		resultsPanel.add(text);
		
		getContentPane().add(resultsPanel);
	}
}
