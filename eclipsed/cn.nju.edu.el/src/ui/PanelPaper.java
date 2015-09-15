package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelPaper extends JPanel{
	 BufferedImage currentImage;
	  	// 存有需要播放的图片的数组
 	BufferedImage[] images = new BufferedImage[3];
 	// 3张图片的地址（自己写）
 	String[] imagePath = { "pictures/paper1.png", "pictures/paper2.png", 
 			  "pictures/paper3.png"};
 	
	Image background=new ImageIcon("pictures/backgroundpaper.jpg").getImage();
	ImageIcon []bamboo=new ImageIcon[2];
	ImageIcon []lime=new ImageIcon[2];
	ImageIcon []bowl=new ImageIcon[2];
	ImageIcon []curtain=new ImageIcon[2];
	JLabel [] tape=new JLabel[4];
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
	ImageIcon spare=new ImageIcon("pictures/");
	ImageIcon paper=new ImageIcon("pictures/");
	
    JLabel labbam=new JLabel("",bambooL,0);
    JLabel lablim=new JLabel("",limeL,0);
    JLabel labbow=new JLabel("",bowlL,0);
    JLabel labcur=new JLabel("",curtainL,0);
    JLabel labbamD=new JLabel("",spare,0);
    JLabel lablimD=new JLabel("",spare,0);
    JLabel labbowD=new JLabel("",spare,0);
    JLabel labcurD=new JLabel("",spare,0);
    JLabel labpap=new JLabel("",spare,0);
    
	static JFrame jframe;
	LabelListener listener;
	Thread changeThread;
	
	public PanelPaper(final JFrame jframe){
//		  this.jframe=jframe;
	   
    	listener=new LabelListener();
		setLayout(null);
		bamboo[0]=bambooL;
		bamboo[1]=bambooB;
	    lime[0]=limeL;
		lime[1]=limeB;
		bowl[0]=bowlL;
		bowl[1]=bowlB;
		curtain[0]=curtainL;
		curtain[1]=curtainB;
		
		for(int i=0;i<4;i++){
			tape[i]=new JLabel("",spare,0);
		}
		int w=bambooOn.getIconWidth();
		int h=bambooOn.getIconHeight();
		tape[0].setBounds(95, 68, w, h);
		tape[1].setBounds(93,200, w, h);
		tape[2].setBounds(85, 334, w, h);
		tape[3].setBounds(88, 467, w, h);
		add(tape[0]);
		add(tape[1]);
		add(tape[2]);
		add(tape[3]);
		
		labbam.setBounds(727,368, bambooL.getIconWidth(),bambooL.getIconHeight());
		lablim.setBounds(357,395, limeL.getIconWidth(),limeL.getIconHeight());
		labbow.setBounds(530,194,bowlL.getIconWidth(),bowlL.getIconHeight());
		labcur.setBounds(695,243,curtainL.getIconWidth(),curtainL.getIconHeight());
		
		labbamD.setBounds(505,297, bambooD.getIconWidth(),bambooD.getIconHeight());
		lablimD.setBounds(390,234, limeD.getIconWidth(),limeD.getIconHeight());
		labbowD.setBounds(450,101,bowlD.getIconWidth(),bowlD.getIconHeight());
		labcurD.setBounds(734,119,curtainD.getIconWidth(),curtainD.getIconHeight());
	    labpap.setBounds(500,280,paper.getIconWidth(),paper.getIconHeight());
	    
		 this.add(labbam);			
		 this.add(lablim);
		 this.add(labbow);
		 this.add(labcur);			
		 this.add(labbamD);			
		 this.add(lablimD);
		 this.add(labbowD);
		 this.add(labcurD);		
         this.add(labpap);
         
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
	     labbamD.addMouseListener(listener);
	     lablimD.addMouseListener(listener);	 	
	     labbowD.addMouseListener(listener);
	     labcurD.addMouseListener(listener);
	     labbamD.addMouseMotionListener(listener);
	     lablimD.addMouseMotionListener(listener);	 	
	     labbowD.addMouseMotionListener(listener);
	     labcurD.addMouseMotionListener(listener);
         labpap.addMouseListener(listener);
         labpap.addMouseMotionListener(listener);
	     
         changeThread = new Thread(new Runnable() {
        	
	   			@Override
	   			public void run() {
	   				// TODO 自动生成的方法存根
	   				for (int i = 0;i<13; i++) {
	   					currentImage = images[i%3];
	   					repaint();
	   					try {
	   						Thread.currentThread().sleep(500);
	   					}catch (InterruptedException e) {
	   						// TODO 自动生成的 catch 块
	   						e.printStackTrace();
	   					}
	   				}	
	   			PanelStart panelStart=new PanelStart(jframe);
	   			jframe.setContentPane(panelStart);
	   			jframe.validate();
	   			}
	   		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image background=new ImageIcon("pictures/backgroundpaper.jpg").getImage();
		 g.drawImage(background,0,0,getWidth(),getHeight(), null);
		 
		 g.drawImage(currentImage,300,300,500,500,null);
		 
	}
	
	public void checkstate(int times){
		if ((times%4==0)&(times>0)){
		    if ((tape[0].getIcon()==bambooOn)&&(tape[1].getIcon()==bowlOn)
		    		&&(tape[2].getIcon()==curtainOn)&&(tape[3].getIcon()==limeOn)){
		    	System.out.println("success");
		    	 // labpap.setIcon(paperwin);
		    	changeImage(jframe);
		    }
		    else{
		    	System.out.println("fail");
		    	//labpap.setIcon(paperfail);
		    }    
		    }
	}
	
	public void changeImage(JFrame jframe){
		PanelPaper panelPaper=new PanelPaper(jframe);
		changeThread.start();
		jframe.setContentPane(panelPaper);
	}
	
	private class LabelListener extends JFrame implements MouseListener,MouseMotionListener{
		private int times=0,time1=0,time2=0,time3=0,time4=0;

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override

		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getX()+" "+e.getY());
			if (e.getSource()==labbam){
				 tape[times%4].setIcon(bambooOn);
			     labbam.setIcon(bamboo[(++time1)%2]);
			     times++;
			}
			if (e.getSource()==lablim){
				 tape[times%4].setIcon(limeOn);
	            lablim.setIcon(lime[(++time2)%2]);
	            times++;
			}
			if (e.getSource()==labbow){
				 tape[times%4].setIcon(bowlOn);
				labbow.setIcon(bowl[(++time3)%2]);
				times++;
			}
	        if (e.getSource()==labcur){
	       	     tape[times%4].setIcon(curtainOn);
	             labcur.setIcon(curtain[(++time4)%2]);
	             times++;
			}
	        if(e.getSource()==labpap){
	        	
	        }
			checkstate(times);
		}

	
		@Override
		public void mousePressed(MouseEvent e) {

//			if (e.getSource()==labbam){
//			     labbam.setIcon(bamboo[times++%2]);	
//			}
//			if (e.getSource()==lablim){
//	            lablim.setIcon(lime[times++%2]);
//			}
//			if (e.getSource()==labbow){
//				labbow.setIcon(bowl[times++%2]);
//			}
//	        if (e.getSource()==labcur){
//	             labcur.setIcon(curtain[times++%2]);
//			}
//			
		}

		
		//榧犳爣閲婃斁
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
			//System.out.println("榧犳爣閲婃斁");
	        
		}

		//榧犳爣杩涘叆锛屽浘鐗囧彉鎴愪笉閫忔槑鐨勫浘
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
			//System.out.println("榧犳爣杩涘叆");
			if (e.getSource()==labbam){
				 labbamD.setIcon(bambooD);
			}
			if (e.getSource()==lablim){
				 lablimD.setIcon(limeD);
			}
			if (e.getSource()==labbow){
				 labbowD.setIcon(bowlD);	
			}
	        if (e.getSource()==labcur){
	       	     labcurD.setIcon(curtainD);
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		//	System.out.println("榧犳爣绂诲紑");
	       if (e.getSource()==labbam){
	    	   labbamD.setIcon(spare);
			}
			if (e.getSource()==lablim){
				  lablimD.setIcon(spare);
			}
			if (e.getSource()==labbow){
				  labbowD.setIcon(spare);
			}
	        if (e.getSource()==labcur){
	        	  labcurD.setIcon(spare);
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�

		}
	}
		public static void main(String[] args) {
		    jframe=new JFrame();
		    jframe.setSize(1000,700);
		    jframe.setContentPane(new PanelPaper(jframe));
			jframe.setVisible(true);
		
	}
	
	
}
