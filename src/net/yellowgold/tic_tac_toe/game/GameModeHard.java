package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

public class GameModeHard extends GameModeSinglePlayer {

   public GameModeHard(TicTacToeGame game) {
      super("Hard", game);
   }

   @Override
   protected int calculateValuePosition() {
      int result = this.calculateWinPosition();
      result = result < 0 ? this.calculateSavePosition() : result;
      return result < 0 ? this.calculateRandomPosition() : result;
   }
}