package net.yellowgold.tic_tac_toe.game;

import net.yellowgold.tic_tac_toe.gui.TicTacToeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class GameMode {
   private final String mode;
   private final TicTacToeGame game;
   private final Random random = new Random();
   private final Value startPlayer = this.random.nextBoolean() ? Value.X : Value.O;

   protected GameMode(String mode, TicTacToeGame game) {
      this.mode = mode;
      this.game = game;
   }

   public abstract void onButtonPressed(int index);

   public abstract void onStart();

   public String getMode() {
      return this.mode;
   }

   protected TicTacToeGame getGame() {
      return this.game;
   }

   protected Value getStartPlayer() {
      return this.startPlayer;
   }

   protected Random getRandom() {
      return this.random;
   }

   protected int calculateRandomPosition() {
      List<Integer> freeIndex = new ArrayList<>();
      for (int i = 0; i < 9; i++) {
         if (this.getGame().getValues()[i] == Value.NONE) {
            freeIndex.add(i);
         }
      }
      return freeIndex.size() == 0 ? -1 : freeIndex.get(this.getRandom().nextInt(freeIndex.size()));
   }

   protected int calculateWinPosition() {
      for (int i = 0; i < 9; i++) {
         Value[] values = Arrays.copyOf(this.getGame().getValues(), 9);
         if (values[i] == Value.NONE) {
            values[i] = Value.X;
            if (Arrays.stream(TicTacToeGame.getMatchers())
                  .anyMatch(idx ->
                        idx != null
                              && idx.length > 0
                              && values[idx[0]] != Value.NONE
                              && TicTacToeGame.allButtonsHaveSameValue(values, idx))) {
               return i;
            }
         }
      }
      return -1;
   }

   protected int calculateSavePosition() {
      for (int i = 0; i < 9; i++) {
         Value[] values = Arrays.copyOf(this.getGame().getValues(), 9);
         if (values[i] == Value.NONE) {
            values[i] = Value.O;
            if (Arrays.stream(TicTacToeGame.getMatchers())
                  .anyMatch(idx ->
                        idx != null
                              && idx.length > 0
                              && values[idx[0]] != Value.NONE
                              && TicTacToeGame.allButtonsHaveSameValue(values, idx))) {
               return i;
            }
         }
      }
      return -1;
   }

   protected int calculateStrategicPosition() {
      List<Integer> freeIndex = new ArrayList<>();
      for (int i = 0; i < 9; i++) {
         if (this.getGame().getValues()[i] == Value.NONE) {
            freeIndex.add(i);
         }
      }
      if (freeIndex.size() == 9) {
         return 0;
      } else if (freeIndex.size() == 7) {
         if (!freeIndex.contains(4)) {
            return 8;
         } else if (!freeIndex.contains(6) || !freeIndex.contains(3)) {
            return 2;
         } else {
            return 6;
         }
      } else if (freeIndex.size() == 5) {
         if (this.getGame().getValues()[2] == Value.X) {
            if(this.getGame().getValues()[8] == Value.NONE) {
               return 8;
            } else {
               return 6;
            }
         } else if (this.getGame().getValues()[6] == Value.X) {
            if(this.getGame().getValues()[8] == Value.NONE) {
               return 8;
            } else {
               return 2;
            }
         } else if (this.getGame().getValues()[8] == Value.X) {
            if(this.getGame().getValues()[2] == Value.NONE) {
               return 2;
            } else {
               return 6;
            }
         }
      }
      return -1;
   }
}