package yyf.FlapyBird;

import java.awt.Graphics;

public class Barrier implements Runnable {
	// 障碍物的坐标
	private int x;
	// 障碍物可通过的空间
	private double space;
	// 障碍物可通过空间的上部坐标
	private double top;
	// 画图面板大小
	private int h, w;
	// 移动速度
	private int speed ;
	// 是否设置过
	private boolean seted = false;
	// 判断是否删除障碍物
	private boolean alive, ready;

	public Barrier() {
		alive = true;
		ready = false;
		// new Thread(this).start();
	}

	public void move() {
		speed=w/300;
		if(speed==0)
			speed++;
		x = x - speed;
		if (x < (-w / 6))
			alive = false;
		if(x==w/3*2)
			ready=true;
		
	}

	public boolean isReady() {
		return ready;
	}

	public void clearReady() {
		ready = false;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void set(int x, int w, int h) {
		if (!seted) {
			this.x = x;
			this.w = w;
			this.h = h;
			randomTopAndSpace();
			seted = true;
		}
	}

	private void randomTopAndSpace() {
		space = Math.random() / 3;
		while (space < 0.2)
			space = Math.random() / 3;
		top = Math.random() * (0.8 - space);
		while (top < 0.2)
			top = Math.random() * (0.8 - space);
	}

	public void paintBarrier(Graphics g) {
		int width = w / 6, height = h / 10;
		int top1 = (int) (h * top), space1 = (int) (h * space);
		g.drawRect(x, 0, width, height);
		g.drawRect(x + width / 4, height, width / 2, top1 - height);
		g.drawRect(x + width / 4, top1 + space1, width / 2, h - top1 - space1
				- height);
		g.drawRect(x, h - height, width, height);

	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while (alive) {
				move();
				Thread.currentThread().sleep(10);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
