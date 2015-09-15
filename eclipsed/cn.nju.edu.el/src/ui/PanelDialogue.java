package ui;

import javax.swing.Icon;
import javax.swing.JPanel;



import java.awt.Dimension;
//public class PanelDialogue extends JPanel{
           //private Thread dialogueThread;
           import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

           import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


    public class PanelDialogue extends JPanel {
    	       JFrame jframe;
    	       PanelStart panelStart;
        	   	// 存有需要播放的图片的数组
        	   	BufferedImage[] images = new BufferedImage[14];
        	   	// 3张图片的地址（自己写）
        	   	String[] imagePath = { "pictures/DialogueBegin/1.jpg", "pictures/DialogueBegin/2.jpg", 
        	   			  "pictures/DialogueBegin/3.jpg",  "pictures/DialogueBegin/4.jpg", "pictures/DialogueBegin/5.jpg", 
        	   			  "pictures/DialogueBegin/6.jpg","pictures/DialogueBegin/7.jpg", "pictures/DialogueBegin/8.jpg",
        	   			  "pictures/DialogueBegin/9.jpg", "pictures/DialogueBegin/10.jpg",  "pictures/DialogueBegin/11.jpg", 
        	   			  "pictures/DialogueBegin/12.jpg","pictures/DialogueBegin/13.jpg"};
        	   	// 当前的图片
        	   	BufferedImage currentImage;
        	   	// 改变当前图片的线程
        	   	Thread changeThread;

        	   	public  PanelDialogue( final JFrame jframe) throws FileNotFoundException, IOException {
        	   		// TODO 自动生成的构造函数存根
        	   		for (int i = 0; i < 13; i++)
        	   			images[i] = ImageIO.read(new FileInputStream(imagePath[i]));
        	   		
        	   		    changeThread = new Thread(new Runnable() {

        	   			@Override
        	   			public void run() {
        	   				// TODO 自动生成的方法存根
        	   				for (int i = 0;i<13; i++) {
        	   					currentImage = images[i];
        	   					repaint();
        	   					try {
        	   						Thread.currentThread().sleep(2500);
        	   					}catch (InterruptedException e) {
        	   						// TODO 自动生成的 catch 块
        	   						e.printStackTrace();
        	   					}
        	   				}
        	   			panelStart=new PanelStart(jframe);	
        	   			jframe.setContentPane(panelStart);
        	   			jframe.validate();
        	   			}
        	   		});
        	   		
        	   		    
        	   	}

        	   	public void startChange() {
        	   		changeThread.start();
        	   	}

        	   	public void paintComponent(Graphics g) {
        	   		super.paintComponent(g);
        	   		g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), null);
        	   	}
        	   	
 }
