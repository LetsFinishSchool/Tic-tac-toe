package net.yellowgold.tic_tac_toe;

public class MultiPlayerTicTacToeGame extends TicTacToeGame {
   private Value currentTurn = Value.X;

   @Override
   public Value getPlayersValue() {
      return this.currentTurn;
   }

   @Override
   public void playerSetValue() {
      this.currentTurn = this.currentTurn.getNextValue();
      this.checkGameStatus();
   }
}