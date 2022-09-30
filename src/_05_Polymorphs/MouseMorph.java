package _05_Polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class MouseMorph extends Polymorph  {

	public MouseMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
	}
}
