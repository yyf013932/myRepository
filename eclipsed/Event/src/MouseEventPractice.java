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
				// TODO �Զ����ɵķ������
				System.out.print("��걻�ͷ�,�ͷŵ���");
				int i=e.getButton();
				System.out.println(i==MouseEvent.BUTTON1?"���":(i==MouseEvent.BUTTON2?"�м�":"�Ҽ�"));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.print("��걻����,���µ���");
				int i=e.getButton();
				System.out.println(i==MouseEvent.BUTTON1?"���":(i==MouseEvent.BUTTON2?"�м�":"�Ҽ�"));
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("����뿪");
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("������");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.print("��걻���,�������");
				int i=e.getButton();
				System.out.println(i==MouseEvent.BUTTON1?"���":(i==MouseEvent.BUTTON2?"�м�":"�Ҽ�"));
				System.out.println("�����"+e.getClickCount()+"��.");
				
			}
		});
	}
	
	public static void main(String[]args){
		MouseEventPractice mo=new MouseEventPractice();
		mo.run();
	}

}