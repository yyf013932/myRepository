package maingame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Bird implements KeyListener, Runnable {
	private double y, ySpeed, yA, x, height,width,size;
	private boolean alive = true;
	Image runner= new ImageIcon("pictures/runner.jpg").getImage();
	public Bird() {
		x = 80;
		y = 45;
		size=4.5;
		height = runner.getHeight(null);
		width=runner.getWidth(null);
		ySpeed = 0;
		yA = 0.4;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getSize() {
		System.out.println(height);
		return size;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth(){
		return width;
	}

	private void move() {
			y += ySpeed;
		if (ySpeed <= 2)
			ySpeed += yA;
		if (y > 160)
			alive = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		//System.out.println("11");
		ySpeed = -2.5;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while (alive) {
				move();
				Thread.currentThread();
				Thread.sleep(50);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
