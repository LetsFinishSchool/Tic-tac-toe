package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

public class GameModeMedium extends GameModeSinglePlayer {

   public GameModeMedium(TicTacToeGame game) {
      super("Medium", game);
   }

   @Override
   protected int calculateValuePosition() {
      int result = this.calculateWinPosition();
      return result < 0 ? this.calculateRandomPosition() : result;
   }
}