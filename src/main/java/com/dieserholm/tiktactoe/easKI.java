package com.dieserholm.tiktactoe;

import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Random;

public class easKI extends TicTacToe {

	Random r = new Random();
	Boolean firstTurn = r.nextBoolean();
	int Turn = 0;

	easKI() {
		start();
		if (firstTurn)
			textfield.setText("X's Turn");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == button[i]) {
				if (firstTurn) {
					denabler(i);
					Turn++;
				} else {
					
					KI();
				}
			}
		}
	}

	public void KI() {
		if (Turn == 0) {
			denabler(3);
		}
		if(Turn == 1 && Objects.equals(button[3].getText(), ""))
			denabler(3);
		else
			denabler(0);
	}

	public void denabler(int index) {

		if (firstTurn) {
			button[index].setText("X");
			firstTurn = false;
		} else {
			button[index].setText("O");
			firstTurn = true;
		}
		button[index].setEnabled(false);

	}
}
