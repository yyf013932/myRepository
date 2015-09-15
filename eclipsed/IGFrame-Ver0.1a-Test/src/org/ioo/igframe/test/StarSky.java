package org.ioo.igframe.test;

import java.awt.Graphics2D;

import org.ioo.igframe.sprite.GSprite;

/**
 * StarSky
 * @author: ioozhuangzi 
 * @version: 0.1a 
 * @Copyright: IGFrame
 */
public class StarSky extends GSprite {

	private double rot, dx, ddx;
	private int stars, type;
	private double defddx, max;
	private Star pol[];
	private int delay = 1;
	private int delta = 0;
	
	public StarSky(int width,int height) {
		setWidth(width);
		setHeight(height);
		rot = 0;
		dx = 0;
		ddx = 0;
		stars = 500;
		type = 0;
		rot = 0;
		max = .1;
		defddx = .005;
		
		pol = new Star[stars];
		for (int i = 0; i < stars; i++)
			pol[i] = new Star(getWidth(), getHeight(), 100, type);
	}
	
	public void render(Graphics2D g) {
		delta++;
		if(delta % delay == 0) {
			rot += dx;
			dx += ddx;
			if (dx > max)
				ddx = -defddx;
			if (dx < -max)
				ddx = defddx;
			for (int i = 0; i < stars; i++)
				pol[i].Draw(g, rot);
		}
	}

}
