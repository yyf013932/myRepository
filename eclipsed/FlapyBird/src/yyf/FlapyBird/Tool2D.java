package yyf.FlapyBird;

import java.awt.Graphics;
import java.awt.Point;

public class Tool2D {
	public static void drawPolygon(Graphics g, Point... args) {
		for (int i = 1; i < args.length; i++)
			g.drawLine(args[i].x, args[i].y, args[i - 1].x, args[i - 1].y);
		g.drawLine(args[0].x, args[0].y, args[args.length - 1].x,
				args[args.length - 1].y);
	}
	
	public static void drawCircle(Graphics g,int x,int y,int r){
		g.drawOval(x-r, y-r, 2*r, 2*r);
	}
	
	public static void fillCircle(Graphics g,int x,int y,int r){
		g.fillOval(x-r, y-r, 2*r, 2*r);
	}
}
