package com.company.game;

import javax.swing.JPanel;

import com.company.entites.AI;
import com.company.entites.Football;
import com.company.entites.Inputs;
import com.company.entites.Player;
import com.company.world.GameWorld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel implements Runnable{
  private Thread gameThread;
  private KeyHandler keyHandler;
  private final int[] dimentions = new int[]{500, 250};
  private final int wallsPadding = 50;

  final int FPS = 60;

  // generating game world
  GameWorld gameWorld = new GameWorld(dimentions);

  public GamePanel() {
    initGameSettings();
    this.setBackground(new Color(10, 10, 10));
    this.setPreferredSize(new Dimension(dimentions[0], dimentions[1]));
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
  }

  public void initGameSettings(){
    Player player = new Player(wallsPadding, dimentions[1]/2, new Inputs());
    player.isAI = false;
    gameWorld.add(player);
    keyHandler = new KeyHandler(player.inputs);
    gameWorld.add(new Player(dimentions[0] - wallsPadding, dimentions[1]/2, new Inputs()));

    // gameWorld.add(bot);
  }

  public void update() {
    gameWorld.update();
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    gameWorld.draw(g);
    g.dispose();
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    double drawInterval = 1000000000 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;

    // --- FPS counter ---
    long timer = 0;
    int drawCount = 0;

    while(gameThread != null) {
      currentTime = System.nanoTime();
      timer += ( currentTime - lastTime ); // time elapsed
      delta += ( currentTime - lastTime ) / drawInterval;
      lastTime = currentTime;

      if (delta >= 1) {
        update();
        repaint();
        delta--;
        drawCount++;
      }

      if (timer >= 1000000000){
        System.out.print("\rFPS : " + drawCount);
        drawCount = 0;
        timer = 0;
      }
    }
  }
}
