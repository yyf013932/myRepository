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
		//����label��λ�ü���С
		label.setBounds((getWidth() - icon[0].getIconHeight()) / 2,
				(getHeight() - icon[0].getIconWidth()) / 2, icon[0].getIconWidth(),
				icon[0].getIconHeight());
		//��Ӽ���
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
	
	//��������
	private class LabelListener implements MouseListener,MouseMotionListener{
		private int times=1;

		//������϶�
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		//����ƶ�
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		//�����
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			System.out.println("�����");
			label.setIcon(icon[times++%2]);
		}

		//��갴��
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			System.out.println("��갴��");
		}

		
		//����ͷ�
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO �Զ����ɵķ������
			System.out.println("����ͷ�");
		}

		//������
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO �Զ����ɵķ������
			System.out.println("������");
		}

		//����뿪
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			System.out.println("����뿪");
		}
		
	}
}
