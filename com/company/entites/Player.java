package com.company.entites;

import java.awt.Color;
import java.awt.Graphics;

import com.company.entites.Inputs;
import com.company.utils.Vector2D;

public class Player extends Entity{
  public Inputs inputs;
  float maxSpeed = 3f;

  public Player(int x, int y, Inputs keyH){
    width = 8;
    height = 50;
    this.inputs = keyH;
    position.set(new Vector2D(x, y));
  }

  @Override
  public void update(){
    super.update();

    if(inputs.isUp == true && inputs.isDown == false){
      if (velocity.y > -maxSpeed){
        velocity.add(new Vector2D(0, -(maxSpeed - velocity.y)/10));
      }
    } else if(inputs.isUp == false && inputs.isDown == true){
      if (velocity.y < maxSpeed){
        velocity.add(new Vector2D(0, (maxSpeed - velocity.y)/10));
      }
    } else {
      velocity.add(new Vector2D(0, (0 - velocity.y)/5));
    }
  }

  @Override
  public void draw(Graphics g){
    g.setColor(Color.RED);
    g.fillRect((int)position.x - width/2, (int)position.y - height/2, width, height);
  }
}
