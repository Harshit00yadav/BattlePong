package com.company.world;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import com.company.entites.AI;
import com.company.entites.Entity;
import com.company.entites.Football;
import com.company.entites.Player;
import com.company.utils.Vector2D;

public class GameWorld {
  int[] dimentions;
  LinkedList<Entity> players = new LinkedList<Entity>();
  AI ai = new AI();
  Football ball;
  ScoreArea[] scoreAreas;

  public GameWorld(int[] dimentions) {
    this.dimentions = dimentions;
    this.ball = new Football(dimentions[0]/2, dimentions[1]/2, -5, 1);
    scoreAreas = new ScoreArea[2];
    int scoreAreaWidth = 20;
    scoreAreas[0] = new ScoreArea(0, 0, scoreAreaWidth, dimentions[1]);
    scoreAreas[1] = new ScoreArea(dimentions[0] - scoreAreaWidth, 0, scoreAreaWidth, dimentions[1]);
  }

  public void add(Entity p){
    players.addFirst(p);
  }

  public void update(){
    // constrain ball to the screen 
    if (ball.position.x + ball.velocity.x < 0 || ball.position.x + ball.velocity.x > dimentions[0]){
      ball.velocity.set(new Vector2D(-ball.velocity.x, ball.velocity.y));
    }
    if (ball.position.y + ball.velocity.y < 0 || ball.position.y + ball.velocity.y > dimentions[1]){
      ball.velocity.set(new Vector2D(ball.velocity.x, -ball.velocity.y));
    }
    ball.update(); 

    Vector2D futurePos = new Vector2D();
    for (int e=0; e<players.size(); e++){
      // futurePos.set(players.get(e).position);
      // 
      // futurePos.add(players.get(e).velocity.iCap());
      // if (worldData[((int)(futurePos.y+5))/25][((int)futurePos.x)/25] == '9' || worldData[((int)(futurePos.y+5))/25][((int)(futurePos.x+10))/25] == '9'){
      //     players.get(e).velocity.x = 0;
      // }
      // 
      // futurePos.add(players.get(e).velocity.jCap());
      // if (worldData[((int)futurePos.y)/25][((int)(futurePos.x+5))/25] == '9' || worldData[((int)(futurePos.y+10))/25][((int)(futurePos.x+5))/25] == '9'){
      //     players.get(e).velocity.y = 0;
      // }
      Entity player = players.get(e);

      if (player.isAI == true){
        ai.update(player, ball);
      }

      // constrain entities to the screen
      if (player.position.x + player.velocity.x < 0 || player.position.x + player.velocity.x > dimentions[0]){
        player.velocity.set(player.velocity.jCap());
      }
      if (player.position.y + player.velocity.y < 0 || player.position.y + player.velocity.y > dimentions[1]){
        player.velocity.set(player.velocity.iCap());
      }


      player.update();
      if (ball.position.x < player.position.x + player.width/2 && ball.position.x > player.position.x - player.width/2 && ball.position.y < player.position.y + player.height/2 && ball.position.y > player.position.y - player.height/2){
        ball.velocity.set(-ball.velocity.x, ball.velocity.y + player.velocity.y);
      }
    }
  }

  public void draw(Graphics g){
    ball.draw(g);
    for (int a=0; a<scoreAreas.length; a++){
      scoreAreas[a].draw(g);
    }
    for (int e=0; e<players.size(); e++){
      players.get(e).draw(g);
    }
  }
}