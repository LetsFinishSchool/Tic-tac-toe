package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

public class GameModeEasy extends GameModeSinglePlayer {
   public GameModeEasy(TicTacToeGame game) {
      super("Easy", game);
   }

   @Override
   protected int calculateValuePosition() {
      return this.calculateRandomPosition();
   }
}