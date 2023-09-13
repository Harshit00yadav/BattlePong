package com.company.entites;

import java.awt.Graphics;
import com.company.utils.Vector2D;

public class Particle extends Entity{
  public Vector2D dimention = new Vector2D();
  public float expansionRate = 0f;
  public Particle(float x, float y, int width, int height){
    dimention.set(width, height);
    position.set(x, y);
    friction = 0.95f;
  }
  
  @Override
  public void update(){
    if (dimention.x > 1f){
      dimention.x += expansionRate;
      dimention.y += expansionRate;
    }
    super.update();
  }

  public void draw(Graphics g){
    g.fillRect((int)(position.x - dimention.x/2), (int)(position.y - dimention.y/2), (int)dimention.x, (int)dimention.y);
  }
}
