package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Star
 * @author: ioozhuangzi 
 * @version: 0.1a 
 * @Copyright: IGFrame
 */
class Star {
	int	H, V;
	int	x, y, z;
	int	type;
	
	Star( int width, int height, int depth, int type ) {
		this.type = type;
		H = width/2;
		V = height/2;
		x = (int)(Math.random()*width) - H;
		y = (int)(Math.random()*height) - V;
		if( (x == 0) && (y == 0 ) ) x = 10;
		z = (int)(Math.random()*depth);
	}
	
	public void Draw( Graphics g, double rot ) {
		double	X, Y;
		int	h, v, hh, vv;
		int	d;
		z-=2;
		if( z < -63 ) z = 100;
		hh = (x*64)/(64+z);
		vv = (y*64)/(64+z);
		X = (hh*Math.cos(rot))-(vv*Math.sin(rot));
		Y = (hh*Math.sin(rot))+(vv*Math.cos(rot));
		h = (int)X+H;
		v = (int)Y+V;
		if( (h < 0) || (h > (2*H))) z = 100;
		if( (v < 0) || (v > (2*H))) z = 100;
		GrayMe(g);
		if( type == 0 ) {
			d=(100-z)/50;
			if( d == 0 ) d = 1;
			g.fillRect( h, v, d, d );
		}
		else {
			d=(100-z)/20;
			g.drawLine( h-d, v, h+d, v );
			g.drawLine( h, v-d, h, v+d );
			if( z < 50 ) {
				d/=2;
				g.drawLine( h-d, v-d, h+d, v+d );
				g.drawLine( h+d, v-d, h-d, v+d );
			}
		}
	}
	
	public void GrayMe(Graphics g) {
		if ( z > 50 ) {
			g.setColor( Color.gray );
		}
		else if ( z > 25 ) {
			g.setColor( Color.lightGray );
		}
		else {
			g.setColor( Color.white ); 
		}
	}
	
}
