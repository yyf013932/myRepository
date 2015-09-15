package gui_exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import yyf.gui.SwingConsole;

public class PaintPlanel extends JFrame {

	Container cont = getContentPane();
	Mydrawer mydrawer = new Mydrawer();
	int x, y, width, height;

	void run() {
		SwingConsole.run(this, 700, 500);
		cont.add(mydrawer);
		cont.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				mydrawer.setArgrument(x, y, e.getX() - x, e.getY() - y);
				mydrawer.repaint();

			}
		});
		cont.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				x = e.getX();
				y = e.getY();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
	}

	public static void main(String[] args) {
		PaintPlanel pa = new PaintPlanel();
		pa.run();
	}
}

class Mydrawer extends JPanel {
	private int x, y, width, height;
	Color paintColor = Color.blue;

	public void setArgrument(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 700, 500);
		g.setColor(paintColor);
		g.drawRect(x, y, width, height);
	}

}
