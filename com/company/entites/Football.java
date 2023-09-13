package com.company.entites;

import java.awt.Color;
import java.awt.Graphics;

import com.company.entites.Entity;
import com.company.utils.Vector2D;


public class Football extends Entity{
  public int radius = 5;
  public Football(int x, int y, int vx, int vy){
    position.set(new Vector2D(x, y));
    velocity.set(new Vector2D(vx, vy));
  }
  @Override
  public void draw(Graphics g) {
    super.draw(g);
    g.setColor(Color.CYAN);
    g.fillOval((int)position.x - radius, (int)position.y - radius, 2*radius, 2*radius);
  }
}
