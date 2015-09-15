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


//竹子，石灰，饽饽，竹帘  历史板块：池塘，水槽，绳子，太阳晒
@SuppressWarnings("serial")
public class PanelPaper extends JPanel{
	
	Image background=new ImageIcon("pictures/backgroundpaper.jpg").getImage();
	 
	ImageIcon bambooL=new ImageIcon("pictures/bambooL.png");
	ImageIcon limeL=new ImageIcon("pictures/limeL.png");
	ImageIcon bowlL=new ImageIcon("pictures/bowlL.png");
	ImageIcon curtainL=new ImageIcon("pictures/curtainL.png");
	ImageIcon bambooB=new ImageIcon("pictures/bambooB.png");
	ImageIcon limeB=new ImageIcon("pictures/limeB.png");
	ImageIcon bowlB=new ImageIcon("pictures/bowlB.png");
	ImageIcon curtainB=new ImageIcon("pictures/curtainB.png");
	ImageIcon bambooD=new ImageIcon("pictures/bambooD.png");
	ImageIcon limeD=new ImageIcon("pictures/limeD.png");
	ImageIcon bowlD=new ImageIcon("pictures/bowlD.png");
	ImageIcon curtainD=new ImageIcon("pictures/curtainD.png");
	ImageIcon bambooOn=new ImageIcon("pictures/bambooOn.png");
	ImageIcon limeOn=new ImageIcon("pictures/limeOn.png");
	ImageIcon bowlOn=new ImageIcon("pictures/bowlOn.png");
	ImageIcon curtainOn=new ImageIcon("pictures/curtainOn.png");

	
    JLabel labbam=new JLabel("",bambooL,0);
    JLabel lablim=new JLabel("",limeL,0);
    JLabel labbow=new JLabel("",bowlL,0);
    JLabel labcur=new JLabel("",curtainL,0);
    JLabel labbamD=new JLabel("",bambooD,0);
    JLabel lablimD=new JLabel("",limeD,0);
    JLabel labbowD=new JLabel("",bowlD,0);
    JLabel labcurD=new JLabel("",curtainD,0);
    
	static JFrame jframe;
	LabelListener listener;
	
	public PanelPaper(JFrame jframe){
//		  this.jframe=jframe;
	
    	listener=new LabelListener();
		setLayout(null);
		
		labbam.setBounds(727,368, bambooL.getIconWidth(),bambooL.getIconHeight());
		lablim.setBounds(357,395, limeL.getIconWidth(),limeL.getIconHeight());
		labbow.setBounds(530,194,bowlL.getIconWidth(),bowlL.getIconHeight());
		labcur.setBounds(695,243,curtainL.getIconWidth(),curtainL.getIconHeight());
		
		labbamD.setBounds(630,294, bambooD.getIconWidth(),bambooD.getIconHeight());
		lablimD.setBounds(422,302, limeD.getIconWidth(),limeD.getIconHeight());
		labbowD.setBounds(450,101,bowlD.getIconWidth(),bowlD.getIconHeight());
		labcurD.setBounds(686,90,curtainD.getIconWidth(),curtainD.getIconHeight());

		 this.add(labbam);			
		 this.add(lablim);
		 this.add(labbow);
		 this.add(labcur);			

		 listener=new LabelListener();
		 this.addMouseListener(listener);
		 this.addMouseMotionListener(listener);
	     labbam.addMouseListener(listener);
	     lablim.addMouseListener(listener);	 	
	     labbow.addMouseListener(listener);
	     labcur.addMouseListener(listener);
	     labbam.addMouseMotionListener(listener);
	     lablim.addMouseMotionListener(listener);	 	
	     labbow.addMouseMotionListener(listener);
	     labcur.addMouseMotionListener(listener);

	     
	}
	public void paintComponent(Graphics g){
		 Image background=new ImageIcon("pictures/backgroundpaper.jpg").getImage();
		 g.drawImage(background,0,0,getWidth(),getHeight(), null);		 
	}
	
	private class LabelListener extends JFrame implements MouseListener,MouseMotionListener{

		//鼠标移动
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		//鼠标点击
		@Override
		//实现鼠标点击后变换图片
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			//System.out.println(e.getX()+","+e.getY());
//			if (e.getSource()==labbam){
//			     labbam.setIcon(bambooB);	
//			}
//			if (e.getSource()==lablim){
//	            lablim.setIcon(limeB);
//			}
//			if (e.getSource()==labbow){
//				labbow.setIcon(bowlB);
//			}
//	        if (e.getSource()==labcur){
//	             labcur.setIcon(curtainB);
//			}
//			
		}

		//鼠标按下
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			//System.out.println("鼠标按下");
			if (e.getSource()==labbam){
			     labbam.setIcon(bambooB);	
			}
			if (e.getSource()==lablim){
	            lablim.setIcon(limeB);
			}
			if (e.getSource()==labbow){
				labbow.setIcon(bowlB);
			}
	        if (e.getSource()==labcur){
	             labcur.setIcon(curtainB);
			}
			
		}

		
		//鼠标释放
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			//System.out.println("鼠标释放");
	        
		}

		//鼠标进入，图片变成不透明的图
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			//System.out.println("鼠标进入");
			if (e.getSource()==labbam){
				 this.add(labbamD);	
				 System.out.println("1");
			}
			if (e.getSource()==lablim){
				 this.add(lablimD);	
			}
			if (e.getSource()==labbow){
				 this.add(labbowD);	
			}
	        if (e.getSource()==labcur){
	   		 this.add(labcurD);	
			}

		}

		//鼠标离开，图片换回原来的那一张
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
		//	System.out.println("鼠标离开");
//	if (e.getSource()==labbam){
//				
//			}
//			if (e.getSource()==lablim){
//	            
//			}
//			if (e.getSource()==labbow){
//				//labhelp.setIcon(help2);
//			}
//	        if (e.getSource()==labcur){
//	             
//			}
//	        if (e.getSource()==labpoo){
//	            
//			}
//	       if (e.getSource()==labsun){
//	            
//			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 自动生成的方法存根
//	if (e.getSource()==labbam){
//				
//			}
//			if (e.getSource()==lablim){
//	            
//			}
//			if (e.getSource()==labbow){
//				//labhelp.setIcon(help2);
//			}
//	        if (e.getSource()==labcur){
//	             
//			}
//	        if (e.getSource()==labpoo){
//	            
//			}
//	       if (e.getSource()==labsun){
//	            
//			}
		}
	}
		public static void main(String[] args) {
		    jframe=new JFrame();
		    jframe.setSize(1000,700);
		    jframe.setContentPane(new PanelPaper(jframe));
			jframe.setVisible(true);
		
	}
	
	
}
