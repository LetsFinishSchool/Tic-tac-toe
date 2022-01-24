package net.yellowgold.tic_tac_toe;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EasyTicTacToeGame extends SinglePlayerTicTacToeGame {
   private final Random random = new Random();
   @Override
   protected void calculateAndSetValue(Value gameValue) {
      List<XOButton> openButtons = Arrays.stream(this.getButtons()).filter(button -> button.getValue() == Value.NONE).collect(Collectors.toList());
      if(openButtons.size() != 0) {
         openButtons.get(this.random.nextInt(openButtons.size())).setValue(gameValue);
         this.checkGameStatus();
      }
   }
}