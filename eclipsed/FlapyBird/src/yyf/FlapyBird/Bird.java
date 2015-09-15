package yyf.FlapyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Bird implements Runnable{
	private int x, y;
	private int width, height;
	private boolean alive;
	private int upSpeed,downSpeed;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	Bird(int x, int y) {
		this.x = x;
		this.y = y;
		alive=true;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void paintBird(Graphics g) {
		Polygon p = new Polygon();
		p.addPoint(x, y);
		p.addPoint(x - 40, y - 20);
		p.addPoint(x - 30, y);
		p.addPoint(x - 40, y + 20);
		g.drawPolygon(p);
		p.reset();
		p.addPoint(x, y - 20);
		p.addPoint(x + 28, y);
		p.addPoint(x, y + 20);
		g.fillPolygon(p);
		g.setColor(Color.white);
		g.fillOval(x - 20, y - 20, 40, 40);
		g.setColor(Color.black);
		Tool2D.drawCircle(g, x, y, 20);
		Tool2D.fillCircle(g, x + 6, y - 6, 6);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			while(alive){
				
			}
		}
	}
}
