package net.yellowgold.tic_tac_toe.gui;

import net.yellowgold.tic_tac_toe.game.GameMode;
import net.yellowgold.tic_tac_toe.game.GameModeSinglePlayer;
import net.yellowgold.tic_tac_toe.game.GameModeVeryHard;
import net.yellowgold.tic_tac_toe.game.Value;

import java.awt.Color;
import java.util.Arrays;
import java.util.function.Consumer;

public class TicTacToeGame {
   protected static final int[][] matchers = new int[][]{
         {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
         {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
         {0, 4, 8}, {2, 4, 6}};
   private final XOButton[] buttons = new XOButton[9];
   private final Value[] values = new Value[9];
   private boolean isGameRunning = true;
   private GameMode gameMode = null;
   private Consumer<String> titleSetter;

   public static int[][] getMatchers() {
      return matchers;
   }

   public TicTacToeGame() {
      for (int i = 0; i < 9; i++) {
         buttons[i] = new XOButton(this, i);
      }
      Arrays.fill(values, Value.NONE);
      this.toggleAllButtons(false);
   }

   public void onButtonPressed(int idx) {
      if (this.getGameMode() != null && this.isGameRunning()) {
         this.getGameMode().onButtonPressed(idx);
      }
   }

   public void setValue(int idx, Value newValue) {
      if (idx >= 0 && idx < this.getValues().length && this.isGameRunning()) {
         this.getValues()[idx] = newValue;
         this.buttons[idx].setValue(this.values[idx]);
         this.buttons[idx].setEnabled(false);
         this.checkGameStatus();
      }
   }

   public XOButton[] getButtons() {
      return buttons;
   }

   public Value[] getValues() {
      return this.values;
   }

   public GameMode getGameMode() {
      return gameMode;
   }

   public void setGameMode(GameMode gameMode) {
      this.toggleAllButtons(true);
      for (int i = 0; i < 9; i++) {
         this.getButtons()[i].setEnabled(true);
         this.getValues()[i] = Value.NONE;
         this.getButtons()[i].setValue(Value.NONE);
         this.getButtons()[i].setBackground(null);
      }
      this.isGameRunning = true;
      this.gameMode = gameMode;
      this.gameMode.onStart();
   }

   public void setTitle(String text) {
      titleSetter.accept(text);
   }

   public void setTitleSetter(Consumer<String> titleSetter) {
      this.titleSetter = titleSetter;
   }

   public boolean isGameRunning() {
      return this.isGameRunning;
   }

   public void onGameEnd() {
      this.isGameRunning = false;
   }

   public void checkGameStatus() {
      java.util.List<int[]> rows = Arrays.stream(matchers).filter(idx -> isWinningSerie(this.getValues(), idx)).toList();
      if (rows.size() > 0) {
         Value winner = Value.NONE;
         for (int[] completeRow : rows) {
            for (int i : completeRow) {
               this.getButtons()[i].setBackground(Color.GREEN);
               winner = this.getValues()[i];
            }
         }
         this.toggleAllButtons(false);
         this.onGameEnd();
         if (this.gameMode instanceof GameModeSinglePlayer) {
            if (winner == Value.X) {
               this.setTitle("You have lost. Try again");
            } else if (winner == Value.O) {
               if (this.gameMode instanceof GameModeVeryHard) {
                  this.setTitle("What? You're a genius!? Congratulations!");
               } else {
                  this.setTitle("You won! What about trying harder modes?");
               }
            }
         } else {
            this.setTitle(String.format("Player '%s' won", winner));
         }
      } else if (Arrays.stream(buttons).allMatch(button -> button.getValue() != Value.NONE)) {
         for (XOButton button : buttons) {
            button.setBackground(Color.YELLOW);
            toggleAllButtons(false);
         }
         this.onGameEnd();
         this.setTitle("The game is over. There is no winner ...");
      }
   }

   protected static boolean isWinningSerie(Value[] buttons, int... idx) {
      if (idx == null) return false;
      if (idx.length < 1) return true;
      if (buttons[idx[0]] == Value.NONE) {
         return false;
      }
      return allButtonsHaveSameValue(buttons, idx);
   }

   public static boolean allButtonsHaveSameValue(Value[] values, int... idx) {
      if (idx == null) return false;
      Value lastValue = null;
      for (int i : idx) {
         Value value = values[i];
         if (lastValue != null && value != lastValue) {
            return false;
         }
         lastValue = value;
      }
      return true;
   }

   private void toggleAllButtons(boolean active) {
      Arrays.stream(buttons).forEach(button -> button.setEnabled(active));
   }
}