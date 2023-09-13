package com.company.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.company.entites.Inputs;

public class KeyHandler implements KeyListener {
    public Inputs inputs;
    public KeyHandler(Inputs inp){
      this.inputs = inp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_D:
            inputs.isRight = true;
            break;
            case KeyEvent.VK_A:
            inputs.isLeft = true;
            break;
            case KeyEvent.VK_W:
            inputs.isUp = true;
            break;
            case KeyEvent.VK_S:
            inputs.isDown = true;
            break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_D:
            inputs.isRight = false;
            break;
            case KeyEvent.VK_A:
            inputs.isLeft = false;
            break;
            case KeyEvent.VK_W:
            inputs.isUp = false;
            break;
            case KeyEvent.VK_S:
            inputs.isDown = false;
            break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
}
