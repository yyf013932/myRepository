import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import yyf.gui.SwingConsole;


public class MouseMotionPractice extends JFrame{
	JLabel label=new JLabel();
	JButton bo=new JButton("1111");
	int x,y;
	public void run(){
		SwingConsole.run(this,500,300);
		add(label);
		setLayout(null);
		add(bo);
		bo.setBounds(0, 0, 50, 50);
		MyMouse my=new MyMouse(bo);
		bo.addMouseListener(my);
		bo.addMouseMotionListener(my);
		
		
	}
	
	
	public static void main(String[]args){
		MouseMotionPractice mos=new MouseMotionPractice();
		mos.run();
	}
	
	class MyMouse implements MouseListener,MouseMotionListener{
		private Component co;
		int x,y;
		
		MyMouse(Component co){
			this.co=co;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 自动生成的方法存根
			co.setBounds(e.getX()-x, e.getY()-y,50,50);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			x=co.getX();
			y=co.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
	}

}
