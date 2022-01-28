package com.dieserholm.tiktactoe;

import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Random;

public class medKI extends TicTacToe {

	Random r = new Random();
	Boolean firstTurn = r.nextBoolean();
	Boolean win =false;
	int Turn = 0;

	medKI() {
		start();
		if (firstTurn)
			textfield.setText("X's Turn");
		else {
			textfield.setText("O's Turn");
			KI();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == button[i]) {
				{
					denabler(i);
					Turn++;
					win = checkresult();
					if(!win)
					KI();
				}
			}
		}
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

	public void KI() {
		int pos;
		while (true) {
			Turn++;
			pos = r.nextInt(9);
			System.out.println(pos);
			if (Objects.equals(button[pos].getText(), "")) {
				denabler(pos);
				checkresult();
				break;
			}
		}
	}
}
