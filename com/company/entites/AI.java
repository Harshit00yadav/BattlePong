package com.company.entites;

import com.company.entites.Entity;
import com.company.entites.Inputs;

public class AI {
  private boolean allign = false;
  public AI(){}
  public void update(Entity p, Entity b){
    if (b.velocity.x >= 0){
      if (p.position.y - p.height/2 > b.position.y){ 
        p.velocity.set(0, -3f);
      } else if (p.position.y + p.height/2 < b.position.y){
        p.velocity.set(0, 3f);
      }
    }
  }
}
