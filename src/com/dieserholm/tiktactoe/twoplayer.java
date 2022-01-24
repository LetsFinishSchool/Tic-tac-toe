package com.dieserholm.tiktactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class twoplayer extends TicTacToe {
	
	twoplayer() {
		start();
		if (Turn == true)
			textfield.setText("X's Turn");
		else
			textfield.setText("O's Turn");
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i <= 8; i++) {
			if (e.getSource() == button[i]) {
				button[i].setEnabled(false);
				if (Turn == true) {
					button[i].setForeground(Color.red);
					button[i].setText("X");
					textfield.setText("O's Turn");
					Turn = false;
				} else {
					button[i].setForeground(Color.blue);
					button[i].setText("O");
					textfield.setText("X's Turn");
					Turn = true;
				}
				checkresult();
			}
		}
	}
}