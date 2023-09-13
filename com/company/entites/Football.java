package com.company.entites;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.company.entites.Entity;
import com.company.utils.Vector2D;

public class Football extends Entity{
  private final int restartCounterReset = 35;
  private Random random = new Random();
  private int genetateParticles = 5;
  private int restartCounter = restartCounterReset;
  public int radius = 5;
  public boolean restart = false;
  public LinkedList<Particle> explosionParticles = new LinkedList<Particle>();
  public boolean isDistroied = false;
  public Football(int x, int y, int vx, int vy){
    position.set(new Vector2D(x, y));
    velocity.set(new Vector2D(vx, vy));
  }

  public void goBoom(){
    this.isDistroied = true;
    for (int i=0; i<genetateParticles; i++){
      Particle p = new Particle(position.x, position.y, 5, 5);
      p.velocity.set(-(velocity.x - random.nextFloat(Math.abs(velocity.x))), random.nextFloat(2.5f));
      p.expansionRate = -0.1f;
      explosionParticles.addFirst(p);
    }
  }

  @Override
  public void update(){
    if (!isDistroied){
      super.update();
    } else {
      restartCounter--;
      if (restartCounter == 0){
        restartCounter = restartCounterReset;
        restart = true;
      }
      for (Particle particle : explosionParticles) {
        particle.update();
      }
    }
  }

  @Override
  public void draw(Graphics g) {
    super.draw(g);
    g.setColor(Color.CYAN);
    if (!isDistroied){
      g.fillOval((int)position.x - radius, (int)position.y - radius, 2*radius, 2*radius);
    } else {
      for (Particle particle : explosionParticles) {
        particle.draw(g);
      }
    }
  }
}
