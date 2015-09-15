package yyf.FlapyBird;

import java.awt.Graphics;

public class Barrier implements Runnable {
	// �ϰ��������
	private int x;
	// �ϰ����ͨ���Ŀռ�
	private double space;
	// �ϰ����ͨ���ռ���ϲ�����
	private double top;
	// ��ͼ����С
	private int h, w;
	// �ƶ��ٶ�
	private int speed ;
	// �Ƿ����ù�
	private boolean seted = false;
	// �ж��Ƿ�ɾ���ϰ���
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
		// TODO �Զ����ɵķ������
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
