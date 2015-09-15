package yyf.function.graphy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import yyf.gui.SwingConsole;

//��������
public class MyDrawer extends JPanel {

	// ���庯��
	private Function function = new Function() {

		@Override
		public String getName() {
			// TODO �Զ����ɵķ������
			return "f(x)=arctan(x)";
		}

		@Override
		public double f(int x) {
			// TODO �Զ����ɵķ������
			return f((double) x);
		}

		@Override
		public double f(double x) {
			// TODO �Զ����ɵķ������
			return Math.atan(x);
		}
	};

	// ����ԭ��
	private int orgX, orgY;

	// ��λ�����ж��ٸ����ص�
	private int interX, interY;

	public int getInterX() {
		return interX;
	}

	public void setInterX(int interX) {
		this.interX = interX;
	}

	public int getInterY() {
		return interY;
	}

	public void setInterY(int interY) {
		this.interY = interY;
	}

	public Function getFunction() {
		return function;
	}

	// Ĭ�ϵ�λ������5�����ص�
	public MyDrawer() {
		interX = 20;
		interY = 50;
	}

	public MyDrawer(int interX, int interY) {
		this.interX = interX;
		this.interY = interY;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	// ��ͼ����
	public void paintComponent(Graphics g) {

		orgX = (int) (getWidth() / 2);
		orgY = (int) (getHeight() / 2);

		// ����
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);

		// ����������
		g.drawLine(getWidth() / 14, orgY, getWidth() / 14 * 13, orgY);
		g.drawLine(orgX, getHeight() / 14, orgX, getHeight() / 14 * 13);
		g.drawLine(getWidth() / 14 * 13 - 5, orgY - 5, getWidth() / 14 * 13,
				orgY);
		g.drawLine(getWidth() / 14 * 13 - 5, orgY + 5, getWidth() / 14 * 13,
				orgY);
		g.drawLine(orgX, getHeight() / 14, orgX - 5, getHeight() / 14 + 5);
		g.drawLine(orgX, getHeight() / 14, orgX + 5, getHeight() / 14 + 5);

		// ������������
		Font font = new Font(null, Font.BOLD, 20);
		g.setFont(font);
		g.drawString(function.getName(), getWidth() / 14, getHeight() / 14);

		// ��������ͼ��
		g.setColor(Color.blue);
		double tx = getWidth() / 7, ty = orgY
				- function.f((tx - orgX) / interX) * interY;
		double x, y;
		for (int i = getWidth() / 7 + 1; i <= getWidth() / 7 * 6; i++) {
			x = i;
			y = orgY - function.f((x - orgX) / interX) * interY;
			g.drawLine((int) tx, (int) ty, (int) x, (int) y);
			tx = x;
			ty = y;
		}

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		SwingConsole.run(f, 700, 500);
		f.add(new MyDrawer());
	}
}
