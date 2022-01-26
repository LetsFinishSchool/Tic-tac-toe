package net.yellowgold.tic_tac_toe.gui;

import net.yellowgold.tic_tac_toe.game.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class XOButton extends JButton implements ActionListener {
   @Serial
   private static final long serialVersionUID = 1L;
   private Value value = Value.NONE;
   private final TicTacToeGame game;
   private final int index;

   public XOButton(TicTacToeGame game, int index) {
      this.game = game;
      this.index = index;
      this.setOpaque(true);
      this.setFont(new Font("DejaVu Math TeX Gyre", Font.ITALIC, 100));
      this.setFocusable(false);
      this.addActionListener(this);
      this.setText("");
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      this.game.onButtonPressed(this.index);
   }

   public void setValue(Value value) {
      this.value = value;
      this.setText(value == Value.NONE ? "" : value.toString());
   }

   public Value getValue() {
      return value;
   }
}