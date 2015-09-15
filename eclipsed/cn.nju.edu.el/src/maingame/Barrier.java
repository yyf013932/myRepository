package maingame;

public class Barrier implements Runnable {
	// 分别代表坐标、障碍物可通过的上坐标、可通过的空间、移动速度
	private double x, top, space, speed;
	private double width;

	// 判断障碍物是否生存以及是否到了绘制下一个障碍物的地方
	private boolean alive, ready;

	public Barrier() {
		x = 160;
		speed = 1;
		alive = true;
		ready = false;
		width=10;
		RandomTopAndSpace();
		new Thread(this).start();
	}

	public boolean isReady() {
		return ready;
	}


	public boolean isAlive() {
		return alive;
	}

	public double getX() {
		return x;
	}

	public double getTop() {
		return top;
	}

	public double getSpace() {
		return space;
	}

	public double getWidth() {
		return width;
	}

	private void move() {
		x -= speed;
		if (x < -width)
			alive = false;
		if (x == 120)
			ready = true;
	}

	// 生成随机的top,space值
	private void RandomTopAndSpace() {
		space = (int) (Math.random() * 40);
		while (space < 20)
		space = (int) (Math.random() * 40);
		top = (int) (Math.random() * (70 - space));
		while (top < 20)
		top = (int) (Math.random() * (70 - space));
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while (alive) {
				move();
				Thread.currentThread();
				Thread.sleep(30);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


}
