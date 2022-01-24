package net.yellowgold.tic_tac_toe;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame() {
		this.setTitle("Tic-Tac-Toe");
		this.setPreferredSize(new Dimension(600, 600));
		this.setLocation(50, 50);
		this.setVisible(true);
	}
}