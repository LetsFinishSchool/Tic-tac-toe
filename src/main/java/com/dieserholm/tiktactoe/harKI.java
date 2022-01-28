package com.dieserholm.tiktactoe;

import java.awt.event.ActionEvent;
import java.util.Random;

public class harKI extends TicTacToe {
	Random r = new Random();
	Boolean firstTurn = r.nextBoolean();
	int Turn = 0;
	String[] board = new String[9];
	Boolean win =false;

	harKI() {
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
		stringwriter();
		
	}

	public void stringwriter() {
		for (int i = 0; i < 9; i++) {
				board[i] = button[i].getText();
			}
		
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i]);
				i++;
			}
		}
	}
}
