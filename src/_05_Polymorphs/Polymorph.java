package _05_Polymorphs;

import java.awt.Graphics;

public abstract class Polymorph {
    int x;
    int y;
    int width;
    int height;
    
    public Polymorph(int x, int y){
   	 this.x = x;
   	 this.y = y;
   	 width = 150;
   	 height = 150;
    }
    
    public abstract void update();
    
    public abstract void draw(Graphics g);
}
