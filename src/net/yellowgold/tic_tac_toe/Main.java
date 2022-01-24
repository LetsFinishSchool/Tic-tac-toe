package net.yellowgold.tic_tac_toe;

public class Main {

   public static void main(String[] args) {
      hardSinglePlayer();
   }

   private static void multiPlayer(){
      TicTacToeGame game = new MultiPlayerTicTacToeGame();
      game.start();
   }

   private static void easySinglePlayer(){
      TicTacToeGame game = new EasyTicTacToeGame();
      game.start();
   }

   private static void middleSinglePlayer(){
      TicTacToeGame game = new MiddleTicTacToeGame();
      game.start();
   }

   private static void hardSinglePlayer(){
      TicTacToeGame game = new HardTicTacToeGame();
      game.start();
   }
}