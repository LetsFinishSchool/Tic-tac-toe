package net.yellowgold.tic_tac_toe;

public class Main {
	public static Value turn = Value.X;
	public static XOButton[] buttons = new XOButton[9];

	public static void main(String[] args) {
		Frame frame = new Frame();
		for (int i = 0; i < 9; i++) {
			XOButton b = new XOButton();
			frame.getContentPane().add(b);
			buttons[i] = b;
		}
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new java.awt.GridLayout(3, 3));
		frame.pack();
	}
	public static void checkForWon() {
		boolean flag;
		flag = match(0,1,2);
		flag |= match(3,4,5);
		flag |= match(6,7,8);
		flag |= match(0,3,6);
		flag |= match(1,4,7);
		flag |= match(2,5,8);
		flag |= match(0,4,8);
		flag |= match(2,4,6);
		if(flag) {
			new WonFrame(turn);
			turn = Value.NONE;
		}
	}

	private static boolean match(int i, int j, int k) {
		if(buttons[i].value == Value.NONE) {
			return false;
		}
		return buttons[i].value.equals(buttons[j].value) && buttons[i].value.equals(buttons[k].value);
	}
}