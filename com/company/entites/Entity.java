package com.company.entites;

import java.awt.Graphics;

import com.company.utils.Vector2D;


public class Entity {
  public Vector2D GRAVITY = new Vector2D(0, 0);
  public Vector2D position = new Vector2D(0, 0);
  public Vector2D velocity = new Vector2D(0, 0);
  public float friction = 1f;
  public int width;
  public int height;
  public boolean isAI = true;

  public Entity(){}

  public void update(){
    velocity.scalarMultiply(friction);
    position.add(velocity);
  }
  public void draw(Graphics g){}
}
