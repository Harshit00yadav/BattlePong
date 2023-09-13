package com.company.game;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
  public GameFrame(GamePanel gamePanel){
    this.setTitle("UnderExplore");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.add(gamePanel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);

    gamePanel.startGameThread();
  }
}
