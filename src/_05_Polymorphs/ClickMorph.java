package _05_Polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class ClickMorph extends Polymorph{

	public ClickMorph(int x, int y) {
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
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}

}
