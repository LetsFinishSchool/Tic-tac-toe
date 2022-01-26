package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

public class GameModeVeryHard extends GameModeSinglePlayer {
   public GameModeVeryHard(TicTacToeGame game) {
      super("Very Hard", game);
   }

   @Override
   protected int calculateValuePosition() {
      int result = this.calculateWinPosition();
      result = result < 0 ? this.calculateSavePosition() : result;
      result = result < 0 ? this.calculateStrategicPosition() : result;
      System.out.println(result);
      return result < 0 ? this.calculateRandomPosition() : result;
   }

   @Override
   public void onStart() {
      super.onStart();
      this.getGame().setValue(0, Value.X);
   }
}