package com.dieserholm.tiktactoe;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

public class TicTacToe implements ActionListener {

	JFrame frame = new JFrame();
	JButton[] button = new JButton[9];
	JButton[] mbutton = new JButton[6];
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JPanel title_panel = new JPanel();
	JPanel mmnorth_panel = new JPanel();
	JPanel mmcenter_panel = new JPanel();
	JPanel mmsouth_panel = new JPanel();
	JPanel mainmenu_panel = new JPanel();
	Random r = new Random();
	Boolean Turn = r.nextBoolean();

	TicTacToe() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(810, 810);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		// frame.getContentPane().setBackground(new Color(50, 50, 50));

		title_panel.setLayout(new BorderLayout());

		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(Color.black);
		button_panel.setVisible(false);

		mmnorth_panel.setLayout(new GridLayout(1, 1));

		mmcenter_panel.setLayout(new GridLayout(1, 3));

		mmsouth_panel.setLayout(new GridLayout(1, 2));

		mainmenu_panel.setLayout(new GridLayout(3, 3));
		mainmenu_panel.setBackground(Color.white);
		mainmenu_panel.setPreferredSize(new Dimension(800, 650));
		mainmenu_panel.setVisible(true);

		textfield.setOpaque(true);
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.white);
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setText("Tic Tac Toe");
		textfield.setPreferredSize(new Dimension(800, 100));

		// setzt die buttons auf dem Array
		for (int i = 0; i <= 8; i++) {
			button[i] = new JButton();
			button_panel.add(button[i]);
			button[i].setOpaque(true);
			button[i].setFocusable(false);
			button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			button[i].addActionListener(this);
		}
		for (int i = 0; i < 6; i++) {
			mbutton[i] = new JButton();

			if (i < 2)
				mmnorth_panel.add(mbutton[i]);
			else if (i >= 2 && i <= 4)
				mmcenter_panel.add(mbutton[i]);
			else
				mmsouth_panel.add(mbutton[i]);

			mbutton[i].setOpaque(true);
			mbutton[i].setFocusable(false);
			mbutton[i].setFont(new Font("MV Boli", Font.BOLD, 60));
			mbutton[i].setVisible(true);
			mbutton[i].addActionListener(this);
		}
		mbutton[0].setText("1 Player");
		mbutton[1].setText("2 Player");
		mbutton[2].setText("Easy");
		mbutton[3].setText("Medium");
		mbutton[4].setText("Hard");
		mbutton[5].setText("Start");

		mbutton[0].setEnabled(false);
		mbutton[3].setEnabled(false);

		mainmenu_panel.add(mmnorth_panel, BorderLayout.NORTH);
		mainmenu_panel.add(mmcenter_panel, BorderLayout.CENTER);
		mainmenu_panel.add(mmsouth_panel, BorderLayout.SOUTH);

		frame.add(mainmenu_panel, BorderLayout.SOUTH);
		frame.add(button_panel);
		frame.add(title_panel, BorderLayout.NORTH);
		title_panel.add(textfield);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 6; i++) {
			if (e.getSource() == mbutton[i]) {
				if (i == 0) {
					mbutton[0].setEnabled(false);
					mbutton[1].setEnabled(true);
					mbutton[2].setEnabled(true);
					mbutton[3].setEnabled(false);
					mbutton[4].setEnabled(true);
				} else if (i == 1) {
					mbutton[0].setEnabled(true);
					mbutton[1].setEnabled(false);
					mbutton[2].setEnabled(false);
					mbutton[3].setEnabled(false);
					mbutton[4].setEnabled(false);
				} else if (i == 2) {
					mbutton[2].setEnabled(false);
					mbutton[3].setEnabled(true);
					mbutton[4].setEnabled(true);
				} else if (i == 3) {
					mbutton[2].setEnabled(true);
					mbutton[3].setEnabled(false);
					mbutton[4].setEnabled(true);
				} else if (i == 4) {
					mbutton[2].setEnabled(true);
					mbutton[3].setEnabled(true);
					mbutton[4].setEnabled(false);
				} else if (i == 5) {
					if (mbutton[0].isEnabled() == false && mbutton[2].isEnabled() == false) {
						new easKI();
					} else if (mbutton[0].isEnabled() == false && mbutton[3].isEnabled() == false) {
						new medKI();
					} else if (mbutton[0].isEnabled() == false && mbutton[4].isEnabled() == false) {
						new harKI();
					} else if (mbutton[1].isEnabled() == false) {
						new twoplayer();
					}
				}
			}
		}

	}

	// schaltet die Sichtbarkeit der Panel auf das tictactoe Feld um
	public void start() {
		mainmenu_panel.setVisible(false);
		button_panel.setVisible(true);
	}

	public void harKI() {
		start();
	}

	public boolean checkresult() {
		if (button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "X") {
			xwins(0, 1, 2);return true;
		} else if (button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "X") {
			xwins(3, 4, 5);return true;
		} else if (button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "X") {
			xwins(6, 7, 8);return true;
		} else if (button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "X") {
			xwins(0, 3, 6);return true;
		} else if (button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "X") {
			xwins(1, 4, 7);return true;
		} else if (button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "X") {
			xwins(2, 5, 8);return true;
		} else if (button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "X") {
			xwins(0, 4, 8);return true;
		} else if (button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "X") {
			xwins(2, 4, 6);return true;
		} else if (button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "O") {
			owins(0, 1, 2);return true;
		} else if (button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "O") {
			owins(3, 4, 5);return true;
		} else if (button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "O") {
			owins(6, 7, 8);return true;
		} else if (button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "O") {
			owins(0, 3, 6);return true;
		} else if (button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "O") {
			owins(1, 4, 7);return true;
		} else if (button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "O") {
			owins(2, 5, 8);return true;
		} else if (button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "O") {
			owins(0, 4, 8);return true;
		} else if (button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "O") {
			owins(2, 4, 6);return true;
		} else if (button[0].getText() != "" && button[1].getText() != "" && button[2].getText() != ""
				&& button[3].getText() != "" && button[4].getText() != "" && button[5].getText() != ""
				&& button[6].getText() != "" && button[7].getText() != "" && button[8].getText() != "") {
			textfield.setText("it is a tie");
			for (int i = 0; i < 9; i++) {
				button[i].setBackground(new Color(255,180,0));
			}
		return true;
		} else
			return false;
	}

	public void xwins(int a, int b, int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);

		textfield.setText("X has won");

		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
	}

	public void owins(int a, int b, int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);

		textfield.setText("O has won");

		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
	}

}
