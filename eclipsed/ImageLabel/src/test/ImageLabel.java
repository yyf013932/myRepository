package test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabel extends JPanel {
	ImageIcon []icon=new ImageIcon[2];
	String iconpath = "111.jpg";
	JLabel label;
	LabelListener listener;

	ImageLabel() {
		setLayout(null);
		setSize(600, 400);
		icon[0] = new ImageIcon(iconpath);
		icon[1]=new ImageIcon("222.jpg");
		label = new JLabel(icon[0]);
		listener=new LabelListener();
		add(label);
		//设置label的位置及大小
		label.setBounds((getWidth() - icon[0].getIconHeight()) / 2,
				(getHeight() - icon[0].getIconWidth()) / 2, icon[0].getIconWidth(),
				icon[0].getIconHeight());
		//添加监听
		label.addMouseListener(listener);
		label.addMouseMotionListener(listener);
	}
	
	public static void main(String []args){
		JFrame f=new JFrame();
		f.setContentPane(new ImageLabel());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 400);
		f.setResizable(false);
	}
	
	//监听的类
	private class LabelListener implements MouseListener,MouseMotionListener{
		private int times=1;

		//鼠标点击拖动
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		//鼠标移动
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		//鼠标点击
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("鼠标点击");
			label.setIcon(icon[times++%2]);
		}

		//鼠标按下
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("鼠标按下");
		}

		
		//鼠标释放
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("鼠标释放");
		}

		//鼠标进入
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("鼠标进入");
		}

		//鼠标离开
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("鼠标离开");
		}
		
	}
}
