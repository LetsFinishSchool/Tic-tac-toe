package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

public class GameModeMultiPlayer extends GameMode {
   private Value currentTurn = this.getStartPlayer();

   public GameModeMultiPlayer(TicTacToeGame game) {
      super("2 Players", game);
   }

   @Override
   public void onButtonPressed(int index) {
      this.getGame().setValue(index, this.currentTurn);
      this.currentTurn = this.currentTurn.getNextValue();
      this.updateTitle();
   }

   @Override
   public void onStart() {
      this.updateTitle();
   }

   private void updateTitle() {
      if (this.getGame().isGameRunning()) {
         this.getGame().setTitle(String.format("It's your turn, player '%s'", this.currentTurn));
      }
   }
}