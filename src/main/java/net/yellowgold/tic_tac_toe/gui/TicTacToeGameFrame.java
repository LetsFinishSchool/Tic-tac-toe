package net.yellowgold.tic_tac_toe.gui;

import net.yellowgold.tic_tac_toe.game.*;

import java.awt.*;
import java.io.Serial;

import javax.swing.*;

public class TicTacToeGameFrame extends JFrame {
   @Serial
   private static final long serialVersionUID = 1L;
   private final TicTacToeGame ticTacToeGame = new TicTacToeGame();
   private final JButton easyGame = new JButton("Easy");
   private final JButton middleGame = new JButton("Medium");
   private final JButton hardGame = new JButton("Hard");
   private final JButton veryHardGame = new JButton("Very Hard");
   private final JButton twoPlayerButton = new JButton("Two Players");

   public TicTacToeGameFrame() {
      this.setTitle("Tic-Tac-Toe");
      this.setPreferredSize(new Dimension(600, 850));
      this.setLocation(50, 50);
      this.setVisible(true);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      JPanel gamePanel = new JPanel();
      gamePanel.setLayout(new java.awt.GridLayout(3, 3));
      for (XOButton button : this.ticTacToeGame.getButtons()) {
         gamePanel.add(button);
      }
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());

      JLabel title = new JLabel("Welcome to Tic-Tac-Toe. Try your luck");
      title.setBackground(Color.MAGENTA);
      title.setFont(new Font("DejaVu Math TeX Gyre", Font.PLAIN, 25));
      title.setOpaque(true);
      title.setHorizontalAlignment(JLabel.CENTER);
      title.setVerticalAlignment(SwingConstants.BOTTOM);
      this.ticTacToeGame.setTitleSetter(title::setText);

      JPanel titlePanel = new JPanel();
      titlePanel.setLayout(new BorderLayout());
      titlePanel.add(title, BorderLayout.NORTH);

      JPanel middlePanel = new JPanel();
      middlePanel.setLayout(new BorderLayout());

      easyGame.addActionListener((actionEvent) -> {
         this.ticTacToeGame.setGameMode(new GameModeEasy(this.ticTacToeGame));
         this.easyGame.setBackground(Color.LIGHT_GRAY);
         this.middleGame.setBackground(null);
         this.hardGame.setBackground(null);
         this.veryHardGame.setBackground(null);
         this.twoPlayerButton.setBackground(null);
      });
      easyGame.setPreferredSize(new Dimension(200, 50));
      middlePanel.add(easyGame, BorderLayout.WEST);

      middleGame.addActionListener((actionEvent) -> {
         this.ticTacToeGame.setGameMode(new GameModeMedium(this.ticTacToeGame));
         this.easyGame.setBackground(null);
         this.middleGame.setBackground(Color.LIGHT_GRAY);
         this.hardGame.setBackground(null);
         this.veryHardGame.setBackground(null);
         this.twoPlayerButton.setBackground(null);
      });
      middleGame.setPreferredSize(new Dimension(200, 50));
      middlePanel.add(middleGame, BorderLayout.CENTER);

      hardGame.addActionListener((actionEvent) -> {
         this.ticTacToeGame.setGameMode(new GameModeHard(this.ticTacToeGame));
         this.easyGame.setBackground(null);
         this.middleGame.setBackground(null);
         this.hardGame.setBackground(Color.LIGHT_GRAY);
         this.veryHardGame.setBackground(null);
         this.twoPlayerButton.setBackground(null);
      });
      hardGame.setPreferredSize(new Dimension(200, 50));
      middlePanel.add(hardGame, BorderLayout.EAST);

      veryHardGame.addActionListener((actionEvent) -> {
         this.ticTacToeGame.setGameMode(new GameModeVeryHard(this.ticTacToeGame));
         this.easyGame.setBackground(null);
         this.middleGame.setBackground(null);
         this.hardGame.setBackground(null);
         this.veryHardGame.setBackground(Color.LIGHT_GRAY);
         this.twoPlayerButton.setBackground(null);
      });
      veryHardGame.setPreferredSize(new Dimension(600, 50));
      middlePanel.add(veryHardGame, BorderLayout.SOUTH);

      twoPlayerButton.addActionListener((actionEvent) -> {
         this.ticTacToeGame.setGameMode(new GameModeMultiPlayer(this.ticTacToeGame));
         this.easyGame.setBackground(null);
         this.middleGame.setBackground(null);
         this.hardGame.setBackground(null);
         this.veryHardGame.setBackground(null);
         this.twoPlayerButton.setBackground(Color.LIGHT_GRAY);
      });
      twoPlayerButton.setPreferredSize(new Dimension(600, 50));
      middlePanel.add(twoPlayerButton, BorderLayout.NORTH);

      gamePanel.setPreferredSize(new Dimension(600, 600));
      mainPanel.add(titlePanel, BorderLayout.NORTH);
      mainPanel.add(middlePanel, BorderLayout.CENTER);
      mainPanel.add(gamePanel, BorderLayout.SOUTH);
      this.add(mainPanel);
      this.pack();
   }
}