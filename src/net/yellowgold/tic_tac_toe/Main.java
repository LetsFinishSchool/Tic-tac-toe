package net.yellowgold.tic_tac_toe;

import java.awt.*;
import java.util.Arrays;

public class Main {
   public static Value turn = Value.X;
   public static XOButton[] buttons = new XOButton[9];
   private static final int[][] matchers = new int[][]{
         {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
         {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
         {0, 4, 8}, {2, 4, 6}};

   public static void main(String[] args) {
      Frame frame = new Frame();
      for (int i = 0; i < 9; i++) {
         XOButton b = new XOButton();
         frame.getContentPane().add(b);
         buttons[i] = b;
      }
      frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      frame.setLayout(new java.awt.GridLayout(3, 3));
      frame.pack();
   }

   public static void checkForWon() {
      boolean flag = Arrays.stream(matchers).anyMatch(Main::match);
      if (flag) {
         turn = Value.NONE;
      }
      if (Arrays.stream(buttons).allMatch(button -> button.value != Value.NONE)) {
         for (XOButton button : buttons) {
            button.setBackground(Color.YELLOW);
            disableAllButtons();
         }
      }
   }

   private static boolean match(int... idx) {
      if (idx == null) return false;
      if (idx.length < 1) return true;
      if (buttons[idx[0]].value == Value.NONE) {
         return false;
      }
      boolean won = allButtonsHaveSameValue(idx);
      if (won) {
         for (int i : idx) {
            buttons[i].setBackground(Color.GREEN);
            disableAllButtons();
         }
      }
      return won;
   }

   private static boolean allButtonsHaveSameValue(int... idx) {
      if (idx == null) return false;
      Value lastValue = null;
      for (int i : idx) {
         XOButton button = buttons[i];
         if ((button.value == null) || (lastValue != null && button.value != lastValue)) {
            return false;
         }
         lastValue = button.value;
      }
      return true;
   }

   private static void disableAllButtons() {
      Arrays.stream(buttons).forEach(button -> button.setEnabled(false));
   }
}