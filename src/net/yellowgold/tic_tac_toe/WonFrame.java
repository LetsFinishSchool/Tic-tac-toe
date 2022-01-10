package net.yellowgold.tic_tac_toe;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.Serial;

import javax.swing.JFrame;

public class WonFrame extends JFrame {
	@Serial
	private static final long serialVersionUID = 1L;

	public WonFrame(Value winner) {
		this.getContentPane().add(new TextField("User " + winner.toString() + " won!"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setLocation((int)width / 2, (int)height / 2);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
	}
}