package net.yellowgold.tic_tac_toe;

import java.awt.Dimension;

import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame(XOButton[] buttons) {
		this.setTitle("Tic-Tac-Toe");
		this.setPreferredSize(new Dimension(600, 600));
		this.setLocation(50, 50);
		this.setVisible(true);
		JPanel buttonPanel = new JPanel();
		for(XOButton button : buttons) {
			buttonPanel.add(button);
		}
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		buttonPanel.setLayout(new java.awt.GridLayout(3, 3));
		this.add(buttonPanel);
		this.pack();
	}
}