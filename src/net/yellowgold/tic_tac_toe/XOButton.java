package net.yellowgold.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton implements ActionListener {
   private static final long serialVersionUID = 1L;
   private Value value = Value.NONE;
   private final TicTacToeGame game;

   public XOButton(TicTacToeGame game) {
      this.game = game;
      this.setOpaque(true);
      this.setFont(new Font("DejaVu Math TeX Gyre", Font.ITALIC, 100));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (this.isEnabled() && game.isGameRunning()) {
         this.setValue(this.game.getPlayersValue());
         this.game.playerSetValue();
      }
   }

   public void setValue(Value value) {
      if (this.isEnabled() && this.game.isGameRunning()) {
         this.value = value;
         this.setEnabled(false);
         this.setText(value.toString());
      }
   }

   public Value getValue() {
      return value;
   }
}