package net.yellowgold.tic_tac_toe;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HardTicTacToeGame extends SinglePlayerTicTacToeGame {
   private final Random random = new Random();

   @Override
   protected void calculateAndSetValue(Value gameValue) {
      // If we can win with a simple value change lets do that
      for (int i = 0; i < 9; i++) {
         XOButton[] buttons = this.copyButtons();
         if (buttons[i].getValue() == Value.NONE) {
            buttons[i].setValue(gameValue);
            if (Arrays.stream(matchers).anyMatch(idx -> idx != null && idx.length > 0 && buttons[idx[0]].getValue() != Value.NONE && this.allButtonsHaveSameValue(buttons, idx))) {
               this.getButtons()[i].setValue(gameValue);
               this.checkGameStatus();
               return;
            }
         }
      }
      // If we need to prevent that the player win, let's do that
      for (int i = 0; i < 9; i++) {
         XOButton[] buttons = this.copyButtons();
         if (buttons[i].getValue() == Value.NONE) {
            buttons[i].setValue(gameValue.getNextValue());
            if (Arrays.stream(matchers).anyMatch(idx -> idx != null && idx.length > 0 && buttons[idx[0]].getValue() != Value.NONE && this.allButtonsHaveSameValue(buttons, idx))) {
               this.getButtons()[i].setValue(gameValue);
               this.checkGameStatus();
               return;
            }
         }
      }
      this.calculateAIPlacement(gameValue);
   }

   protected void calculateAIPlacement(Value gameValue) {
      List<XOButton> openButtons = Arrays.stream(this.getButtons()).filter(button -> button.getValue() == Value.NONE).collect(Collectors.toList());
      if (openButtons.size() != 0) {
         int i = this.random.nextInt(openButtons.size());
         openButtons.get(i).setValue(gameValue);
         this.checkGameStatus();
      }
   }

   protected XOButton[] copyButtons(){
      XOButton[] newButtons = new XOButton[this.getButtons().length];
      for(int i = 0; i < this.getButtons().length; i++){
         newButtons[i] = new XOButton(this);
         Value oldValue = this.getButtons()[i].getValue();
         if(oldValue != Value.NONE) {
            newButtons[i].setValue(oldValue);
         }
      }
      return newButtons;
   }
}