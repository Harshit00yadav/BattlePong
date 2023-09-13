package com.company.utils;

public class Vector2D {
    public float x, y;
    private double magnitude;

    public Vector2D(){
        x = 0;
        y = 0;
        magnitude = 0;
    }
    public Vector2D(float x_, float y_){
        x = x_;
        y = y_;
        magnitude = Math.sqrt(x*x + y*y);
    }
    public void set(Vector2D v){
        x = v.x;
        y = v.y;
    }
    public void set(float vx, float vy){
        x = vx;
        y = vy;
    }
    public void add(Vector2D v){
        x += v.x;
        y += v.y;
    }
    public void scalarMultiply(float m){
      x *= m;
      y *= m;
    }
    public Vector2D iCap(){ return new Vector2D(x, 0);}
    public Vector2D jCap(){ return new Vector2D(0, y);}
    public double getMagnitude(){ return magnitude;}
    public String toString(){return "x:"+x+", y:"+y;}
}
