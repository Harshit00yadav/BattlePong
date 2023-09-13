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
  public void draw(Graphics g){
    g.setColor(Color.ORANGE);
    g.drawRect(x, y, width, height);
  }
}
