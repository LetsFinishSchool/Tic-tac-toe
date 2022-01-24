package com.dieserholm.tiktactoe;

import java.awt.event.ActionEvent;
import java.util.Random;

public class medKI extends TicTacToe {

	Random r = new Random();
	Boolean firstTurn = r.nextBoolean();
	Boolean win =false;
	int Turn = 0;

	medKI() {
		start();
		if (firstTurn == true)
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
					if(win ==false)
					KI();
				}
			}
		}
	}

	public void denabler(int index) {

		if (firstTurn == true) {
			button[index].setText("X");
			firstTurn = false;
		} else if (firstTurn == false) {
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
			if (button[pos].getText() == "") {
				denabler(pos);
				checkresult();
				break;
			}
		}
	}
}
