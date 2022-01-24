package net.yellowgold.tic_tac_toe;

import java.awt.*;
import java.util.Arrays;

public abstract class TicTacToeGame {
   protected static final int[][] matchers = new int[][]{
         {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
         {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
         {0, 4, 8}, {2, 4, 6}};
   private final XOButton[] buttons = new XOButton[9];
   private boolean isGameRunning = true;

   public TicTacToeGame() {
      for (int i = 0; i < 9; i++) {
         buttons[i] = new XOButton(this);
      }
   }

   public void start() {
      new Frame(buttons);
   }

   protected XOButton[] getButtons() {
      return buttons;
   }

   public boolean isGameRunning() {
      return this.isGameRunning;
   }

   public abstract Value getPlayersValue();

   public abstract void playerSetValue();

   public void onGameEnd() {
      this.isGameRunning = false;
   }

   /**
    * Checks if the game should still run. Sets the winner, the game stop flag and also button colors
    *
    * @return if the game is still running
    */
   public boolean checkGameStatus() {
      if (Arrays.stream(matchers).anyMatch(idx -> this.isWinningSerie(this.buttons, idx))) {
         this.onGameEnd();
         return false;
      } else if (Arrays.stream(buttons).allMatch(button -> button.getValue() != Value.NONE)) {
         for (XOButton button : buttons) {
            button.setBackground(Color.YELLOW);
            disableAllButtons();
         }
         this.onGameEnd();
         return false;
      }
      return true;
   }

   protected boolean isWinningSerie(XOButton[] buttons, int... idx) {
      if (idx == null) return false;
      if (idx.length < 1) return true;
      if (buttons[idx[0]].getValue() == Value.NONE) {
         return false;
      }
      boolean won = allButtonsHaveSameValue(buttons, idx);
      if (won) {
         for (int i : idx) {
            buttons[i].setBackground(Color.GREEN);
            disableAllButtons();
         }
      }
      return won;
   }

   protected boolean allButtonsHaveSameValue(XOButton[] buttons, int... idx) {
      if (idx == null) return false;
      Value lastValue = null;
      for (int i : idx) {
         XOButton button = buttons[i];
         if ((button.getValue() == null) || (lastValue != null && button.getValue() != lastValue)) {
            return false;
         }
         lastValue = button.getValue();
      }
      return true;
   }

   private void disableAllButtons() {
      Arrays.stream(buttons).forEach(button -> button.setEnabled(false));
   }
}