import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import yyf.gui.SwingConsole;


public class MouseEventPractice extends JFrame{
	public void run(){
		SwingConsole.run(this,500,300);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.print("鼠标被释放,释放的是");
				int i=e.getButton();
				System.out.println(i==MouseEvent.BUTTON1?"左键":(i==MouseEvent.BUTTON2?"中键":"右键"));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.print("鼠标被按下,按下的是");
				int i=e.getButton();
				System.out.println(i==MouseEvent.BUTTON1?"左键":(i==MouseEvent.BUTTON2?"中键":"右键"));
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("鼠标离开");
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("鼠标进入");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.print("鼠标被点击,点击的是");
				int i=e.getButton();
				System.out.println(i==MouseEvent.BUTTON1?"左键":(i==MouseEvent.BUTTON2?"中键":"右键"));
				System.out.println("点击了"+e.getClickCount()+"次.");
				
			}
		});
	}
	
	public static void main(String[]args){
		MouseEventPractice mo=new MouseEventPractice();
		mo.run();
	}

}
