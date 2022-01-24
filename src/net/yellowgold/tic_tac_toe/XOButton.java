package net.yellowgold.tic_tac_toe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class XOButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	public Value value = Value.NONE;

	public XOButton() {
		this.setText("-");
		this.setFont(new Font("Dialog", 0, 100));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.value == Value.NONE && Main.turn != Value.NONE) {
			this.value = Main.turn;
			this.setText(this.value.toString());
			Main.checkForWon();
			Main.turn = Main.turn.getNextValue();
		}
	}
}