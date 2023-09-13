package com.company.world;

import java.awt.Color;
import java.awt.Graphics;

public class ScoreArea{
  public int width;
  public int height;
  public int x;
  public int y;
  public ScoreArea(int x, int y, int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public boolean isInside(int x_, int y_){
    if (x < x_ && x_ < x+width && y < y_ && y_ < y+height){
      return true;
    }
    return false;
  }

  public void draw(Graphics g){
    g.setColor(new Color(150, 150, 10));
    g.fillRect(x, y, width, height);
  }
}
