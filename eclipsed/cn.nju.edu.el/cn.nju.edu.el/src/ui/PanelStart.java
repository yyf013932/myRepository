package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import maingame.DrawPane;

@SuppressWarnings("serial")
public class PanelStart extends JPanel {

	ImageIcon start1 = new ImageIcon("pictures/start1.jpg");
	ImageIcon start2 = new ImageIcon("pictures/start.jpg");
	ImageIcon exit1 = new ImageIcon("pictures/exit1.jpg");
	ImageIcon exit2 = new ImageIcon("pictures/exit.jpg");
	ImageIcon help1 = new ImageIcon("pictures/help1.jpg");
	ImageIcon help2 = new ImageIcon("pictures/help.jpg");
	JLabel labstart = new JLabel("", start1, 0);
	JLabel labexit = new JLabel("", exit1, 0);
	JLabel labhelp = new JLabel("", help1, 0);
	LabelListener listener;
	JFrame jframe;
	DrawPane drawPane;

	// LabelListener listener;
	public PanelStart(JFrame jframe) {
		// p1_lab2=new JLabel("",icon,0);
		// listener=new LabelListener();
		this.jframe = jframe;
		drawPane=new DrawPane(jframe);
		setLayout(null);
		labstart.setBounds(47, 123, start1.getIconWidth(),start1.getIconHeight());
		labexit.setBounds(47, 208, exit1.getIconWidth(), exit1.getIconHeight());
		labhelp.setBounds(47, 290, help1.getIconWidth(), help1.getIconHeight());

		this.add(labstart);
		this.add(labexit);
		this.add(labhelp);
		listener = new LabelListener();
		labstart.addMouseListener(listener);
		labstart.addMouseMotionListener(listener);
		labexit.addMouseListener(listener);
		labexit.addMouseMotionListener(listener);
		labhelp.addMouseListener(listener);
		labhelp.addMouseMotionListener(listener);
      //  addMouseListener(listener);
		//addMouseMotionListener(listener);
	}

	public void paintComponent(Graphics g) {
		Image background = new ImageIcon("pictures/background.jpg").getImage();
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

	}

	private class LabelListener extends JFrame implements MouseListener,
			MouseMotionListener {

		// 鼠标移动
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		// 鼠标点击
		@Override
		// 实现鼠标点击后变换图片
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
		//	System.out.println("鼠标点击");
			if (e.getSource()==labstart){				
			   jframe.setContentPane(drawPane);
			   jframe.addKeyListener(drawPane.getBird());
			   drawPane.startGame();
			//System.out.println(e.getX() + "," + e.getY());
			   jframe.validate();
			}

		}

		// 鼠标按下
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			// System.out.println("鼠标按下");
		}

		// 鼠标释放
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			// System.out.println("鼠标释放");

		}

		// 鼠标进入，图片变成不透明的图
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
	//		System.out.println("鼠标进入");
			if (e.getSource() == labstart) {
				labstart.setIcon(start2);
			}
			if (e.getSource() == labexit) {
				labexit.setIcon(exit2);
			}
			if (e.getSource() == labhelp) {
				labhelp.setIcon(help2);
			}
		}

		// 鼠标离开，图片换回原来的那一张
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
		//	System.out.println("鼠标离开");
			if (e.getSource() == labstart) {
				labstart.setIcon(start1);
			}
			if (e.getSource() == labexit) {
				labexit.setIcon(exit1);
			}
			if (e.getSource() == labhelp) {
				labhelp.setIcon(help1);
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 自动生成的方法存根

		}
	}

}
