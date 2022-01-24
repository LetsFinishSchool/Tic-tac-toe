package net.yellowgold.tic_tac_toe;

public class MiddleTicTacToeGame extends SinglePlayerTicTacToeGame {
   private final int[] places = new int[]{0, 2, 1, 8, 4, 6, 7, 3, 5};
   private int turn = -1;

   @Override
   protected void calculateAndSetValue(Value gameValue) {
      turn++;
      for (int i = 0; i < 9; i++) {
         XOButton button = this.getButtons()[places[(i + turn) % 9]];
         if (button.getValue() == Value.NONE) {
            button.setValue(gameValue);
            this.checkGameStatus();
            return;
         }
      }
   }
}