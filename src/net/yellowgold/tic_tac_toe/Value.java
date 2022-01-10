package net.yellowgold.tic_tac_toe;

public enum Value {
	X("O"), O("X"), NONE("NONE");

	private final String nextValue;
	Value(String v) {
		this.nextValue = v;
	}

	public Value getNextValue() {
		return Value.valueOf(nextValue);
	}
}