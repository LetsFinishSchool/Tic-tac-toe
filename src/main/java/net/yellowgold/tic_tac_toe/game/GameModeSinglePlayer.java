package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

public abstract class GameModeSinglePlayer extends GameMode {
   protected GameModeSinglePlayer(String mode, TicTacToeGame game) {
      super(mode, game);
   }

   @Override
   public void onButtonPressed(int index) {
      this.getGame().setValue(index, Value.O);
      this.makeTurn();
   }

   @Override
   public void onStart() {
      this.getGame().setTitle("It's your turn! Set your 'O'");
      if (this.getStartPlayer().equals(Value.X)) {
         this.makeTurn();
      }
   }

   private void makeTurn() {
      this.getGame().setValue(this.calculateValuePosition(), Value.X);
   }

   protected abstract int calculateValuePosition();
}