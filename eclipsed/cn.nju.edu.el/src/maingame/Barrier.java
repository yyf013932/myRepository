package maingame;

public class Barrier implements Runnable {
	// �ֱ�������ꡢ�ϰ����ͨ���������ꡢ��ͨ���Ŀռ䡢�ƶ��ٶ�
	private double x, top, space, speed;
	private double width;

	// �ж��ϰ����Ƿ������Լ��Ƿ��˻�����һ���ϰ���ĵط�
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

	// ���������top,spaceֵ
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
		// TODO �Զ����ɵķ������
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
