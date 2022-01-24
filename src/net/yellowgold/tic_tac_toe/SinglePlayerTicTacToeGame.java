package net.yellowgold.tic_tac_toe;

public abstract class SinglePlayerTicTacToeGame extends TicTacToeGame {
   @Override
   public Value getPlayersValue() {
      return Value.X;
   }

   @Override
   public void playerSetValue() {
      if (this.checkGameStatus())
         this.calculateAndSetValue(Value.O);
   }

   protected abstract void calculateAndSetValue(Value gameValue);
}