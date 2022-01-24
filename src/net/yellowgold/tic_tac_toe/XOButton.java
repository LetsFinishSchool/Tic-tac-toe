package net.yellowgold.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	public Value value = Value.NONE;

	public XOButton() {
		this.setOpaque(true);
		this.setFont(new Font("DejaVu Math TeX Gyre", Font.ITALIC, 100));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.value == Value.NONE && Main.turn != Value.NONE) {
			this.value = Main.turn;
			this.setEnabled(false);
			this.setText(this.value.toString());
			Main.checkForWon();
			Main.turn = Main.turn.getNextValue();
		}
	}
}