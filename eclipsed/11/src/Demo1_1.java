import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import yyf.gui.SwingConsole;

public class Demo1_1 extends JFrame {

	MyDrawer myd = new MyDrawer();

	public void run() {
		SwingConsole.run(this, 700, 500);
		add(myd);
		addKeyListener(myd);
	}

	public static void main(String[] args) {
		Demo1_1 demo = new Demo1_1();
		demo.run();
	}

}

class MyDrawer extends JPanel implements KeyListener {
	private ArrayList<Tank> tanks = new ArrayList<Tank>();
	public MyDrawer() {
		tanks.add(new Tank(100, 200, Direction.LEFT, Type.PLAYER));
		tanks.add(new Tank(50, 50));
		tanks.add(new Tank(100, 50));
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 700, 500);

		for (Tank tank : tanks) {
			drawTank(tank, g);
		}

	}

	private void drawTank(Tank tank, Graphics g) {
		switch (tank.getType()) {
		case PLAYER:
			g.setColor(Color.yellow);
			break;
		default:
			g.setColor(Color.blue);
			break;
		}
		switch (tank.getDir()) {
		case UP:
			g.fillRect(tank.getX() - 20, tank.getY() - 25, 10, 50);
			g.fillRect(tank.getX() - 10, tank.getY() - 20, 20, 40);
			g.fillRect(tank.getX() + 10, tank.getY() - 25, 10, 50);
			g.setColor(g.getColor().darker());
			g.drawRect(tank.getX() - 20, tank.getY() - 25, 10, 50);
			g.drawRect(tank.getX() - 10, tank.getY() - 20, 20, 40);
			g.drawRect(tank.getX() + 10, tank.getY() - 25, 10, 50);
			g.fillOval(tank.getX() - 10, tank.getY() - 10, 20, 20);
			g.fillRect(tank.getX() - 2, tank.getY() - 25, 4, 25);
			break;
		case RIGHT:
			g.fillRect(tank.getX() - 25, tank.getY() - 20, 50, 10);
			g.fillRect(tank.getX() - 20, tank.getY() - 10, 40, 20);
			g.fillRect(tank.getX() - 25, tank.getY() + 10, 50, 10);
			g.setColor(g.getColor().darker());
			g.drawRect(tank.getX() - 25, tank.getY() - 20, 50, 10);
			g.drawRect(tank.getX() - 20, tank.getY() - 10, 40, 20);
			g.drawRect(tank.getX() - 25, tank.getY() + 10, 50, 10);
			g.fillOval(tank.getX() - 10, tank.getY() - 10, 20, 20);
			g.fillRect(tank.getX(), tank.getY() - 2, 25, 4);
			break;
		case LEFT:
			g.fillRect(tank.getX() - 25, tank.getY() - 20, 50, 10);
			g.fillRect(tank.getX() - 20, tank.getY() - 10, 40, 20);
			g.fillRect(tank.getX() - 25, tank.getY() + 10, 50, 10);
			g.setColor(g.getColor().darker());
			g.drawRect(tank.getX() - 25, tank.getY() - 20, 50, 10);
			g.drawRect(tank.getX() - 20, tank.getY() - 10, 40, 20);
			g.drawRect(tank.getX() - 25, tank.getY() + 10, 50, 10);
			g.fillOval(tank.getX() - 10, tank.getY() - 10, 20, 20);
			g.fillRect(tank.getX() - 25, tank.getY() - 2, 25, 4);
			break;
		case DOWN:
			g.fillRect(tank.getX() - 20, tank.getY() - 25, 10, 50);
			g.fillRect(tank.getX() - 10, tank.getY() - 20, 20, 40);
			g.fillRect(tank.getX() + 10, tank.getY() - 25, 10, 50);
			g.setColor(g.getColor().darker());
			g.drawRect(tank.getX() - 20, tank.getY() - 25, 10, 50);
			g.drawRect(tank.getX() - 10, tank.getY() - 20, 20, 40);
			g.drawRect(tank.getX() + 10, tank.getY() - 25, 10, 50);
			g.fillOval(tank.getX() - 10, tank.getY() - 10, 20, 20);
			g.fillRect(tank.getX() - 2, tank.getY(), 4, 25);
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

		// TODO 自动生成的方法存根
				Tank tan = tanks.get(0);
				// TODO 自动生成的方法存根
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					tan.setDir(Direction.UP);
					tan.move();
					break;
				case KeyEvent.VK_DOWN:
					tan.setDir(Direction.DOWN);
					tan.move();
					break;
				case KeyEvent.VK_LEFT:
					tan.setDir(Direction.LEFT);
					tan.move();
					break;
				case KeyEvent.VK_RIGHT:
					tan.setDir(Direction.RIGHT);
					tan.move();
					break;
				}
				repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}
}

class Tank {
	private int x, y;
	private Direction dir;
	private Type type;
	private int speed = 8;

	public Tank() {

	}

	public Tank(int x, int y, Direction dir, Type type) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.type = type;
	}

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
		dir = Direction.DOWN;
		type = Type.ENIMY;
	}

	public int getX() {
		return x;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
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

	public void move() {
		switch (dir) {
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;
			break;
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		}
	}

}

enum Direction {
	LEFT, RIGHT, UP, DOWN
}

enum Type {
	PLAYER, ENIMY
}