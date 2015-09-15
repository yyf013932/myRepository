package yyf.graphy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import yyf.gui.SwingConsole;

public class Square extends JFrame {

	public void run() {
		SwingConsole.run(this, 700, 700);
		add(new MyDrawer());
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Square().run();
	}

}

class MyDrawer extends JPanel{
	double x1, y1, x2, y2, x3, y3, x4, y4;
	double tx1, ty1, tx2, ty2, tx3, ty3, tx4, ty4;
	double p = 0.97, q = 0.03;

	


	public void paintComponent(Graphics g) {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = getHeight();
		x3 = getWidth();
		y3 = getHeight();
		x4 = getWidth();
		y4 = 0;
		tx1 = x1;
		ty1 = y1;
		tx2 = x2;
		ty2 = y2;
		tx3 = x3;
		ty3 = y3;
		tx4 = x4;
		ty4 = y4;
		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		for (int i = 0; i < 150; i++) {
			g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
			g.drawLine((int) x2, (int) y2, (int) x3, (int) y3);
			g.drawLine((int) x3, (int) y3, (int) x4, (int) y4);
			g.drawLine((int) x4, (int) y4, (int) x1, (int) y1);
			getNext();
		}

	}

	void getNext() {
		x1 = p * tx1 + q * tx2;
		y1 = p * ty1 + q * ty2;
		x2 = p * tx2 + q * tx3;
		y2 = p * ty2 + q * ty3;
		x3 = p * tx3 + q * tx4;
		y3 = p * ty3 + q * ty4;
		x4 = p * tx4 + q * tx1;
		y4 = p * ty4 + q * ty1;
		tx1 = x1;
		ty1 = y1;
		tx2 = x2;
		ty2 = y2;
		tx3 = x3;
		ty3 = y3;
		tx4 = x4;
		ty4 = y4;
	}


}
