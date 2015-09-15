package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDialoguePaper extends JPanel{
	  JFrame jframe;   
	  PanelPaper panelPaper;
	 
	  
   	   	// 存有需要播放的图片的数组
   	   	BufferedImage[] images = new BufferedImage[14];
   	   	// 3张图片的地址（自己写）
   	   	String[] imagePath = { "pictures/DialoguePaper/1.jpg", "pictures/DialoguePaper/2.jpg", 
   	   			  "pictures/DialoguePaper/3.jpg",  "pictures/DialoguePaper/4.jpg", "pictures/DialoguePaper/5.jpg", 
   	   			  "pictures/DialoguePaper/6.jpg","pictures/DialoguePaper/7.jpg", "pictures/DialoguePaper/8.jpg",
   	   			  "pictures/DialoguePaper/9.jpg", "pictures/DialoguePaper/10.jpg",  "pictures/DialoguePaper/11.jpg", 
   	   			  "pictures/DialoguePaper/12.jpg","pictures/DialoguePaper/13.jpg"};
   	   	// 当前的图片
   	   	BufferedImage currentImage;
   	   	// 改变当前图片的线程
   	   	Thread changeThread;

   	   	public  PanelDialoguePaper(final JFrame jframe) throws FileNotFoundException, IOException {
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
   	   						Thread.currentThread().sleep(2000);
   	   					}catch (InterruptedException e) {
   	   						// TODO 自动生成的 catch 块
   	   						e.printStackTrace();
   	   					}
   	   				}
   	   			panelPaper=new PanelPaper(jframe);	
   	   			jframe.setContentPane(panelPaper);
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

