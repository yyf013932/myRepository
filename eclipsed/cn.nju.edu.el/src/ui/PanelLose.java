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

public class PanelLose extends JPanel{

	ImageIcon restart;
	ImageIcon exit;
	JLabel labres;
	JLabel labexit ;
	LabelListener listener;
	JFrame jframe;
   DrawPane drawPane;
	
	public PanelLose(JFrame jframe){
		this.jframe = jframe;
		restart= new ImageIcon("pictures/restart.png");
	    exit= new ImageIcon("pictures/exitpaper.png");
		labres=new JLabel("",restart,0);
		 labexit = new JLabel("", exit, 0);
	
		
		setLayout(null);
		labres.setBounds(758, 338,restart.getIconWidth(),restart.getIconHeight());
		labexit.setBounds(796, 422,exit.getIconWidth(), exit.getIconHeight());

		this.add(labexit);
		this.add(labres);
		listener = new LabelListener();
		labexit.addMouseListener(listener);
		labexit.addMouseMotionListener(listener);
		labres.addMouseListener(listener);
		labres.addMouseMotionListener(listener);
		
	}
	public void paintComponent(Graphics g){
		 Image background=new ImageIcon("pictures/backgroundl.jpg").getImage();
		 g.drawImage(background,0,0,getWidth(),getHeight(), null);		 
	}
	
	private class LabelListener extends JFrame implements MouseListener ,MouseMotionListener{

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自动生成的方法存根

		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==labres){
				drawPane = new DrawPane(jframe);
				jframe.setContentPane(drawPane);
				   jframe.addKeyListener(drawPane.getBird());
				   drawPane.startGame();
				jframe.validate();
			}
			if(e.getSource()==labexit){
				jframe.dispose();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	public static void main(String[] args){
        JFrame jframe=new JFrame();
        jframe.setSize(1000, 700);
        jframe.setContentPane(new PanelLose(jframe));
        jframe.setVisible(true);
	}

}
