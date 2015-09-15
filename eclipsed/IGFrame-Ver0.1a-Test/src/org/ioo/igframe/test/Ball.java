package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Ball
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class Ball {
	private int size = 5; //小球大小
	private int x, y; //小球左上角坐标
	private int vx, vy; //向量
	private int cx, cy; //小球中心点坐标
	private int ballType = 0;//0为实心球，1为空心球

	public Ball(int x, int y, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.cx = (size / 2 + x);
		this.cy = (size / 2 + y);
	}
	
	public Ball(int x, int y, int vx, int vy, int ballType) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.cx = (size / 2 + x);
		this.cy = (size / 2 + y);
		this.ballType = ballType;
	}
	
	public Ball(int x, int y, int vx, int vy, int ballType, int size) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.size = size;
		this.cx = (size / 2 + x);
		this.cy = (size / 2 + y);
		this.ballType = ballType;
	}

	public void move() {
		x += vx;
		y += vy;
		this.cx = (size / 2 + x);
		this.cy = (size / 2 + y);
		if (x < 0 || x > BallTest.WIDTH - size) {
			vx = -vx;
		}
		if (y < 0 || y > BallTest.HEIGHT - size) {
			vy = -vy;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		if(ballType ==0) {
			g.fillOval(x, y, size, size);
		}
		else if(ballType == 1) {
			g.drawOval(x, y, size, size);
		}
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

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public int getBallType() {
		return ballType;
	}

	public void setBallType(int ballType) {
		this.ballType = ballType;
	}

}
