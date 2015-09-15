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
	 
	  
   	   	// ������Ҫ���ŵ�ͼƬ������
   	   	BufferedImage[] images = new BufferedImage[14];
   	   	// 3��ͼƬ�ĵ�ַ���Լ�д��
   	   	String[] imagePath = { "pictures/DialoguePaper/1.jpg", "pictures/DialoguePaper/2.jpg", 
   	   			  "pictures/DialoguePaper/3.jpg",  "pictures/DialoguePaper/4.jpg", "pictures/DialoguePaper/5.jpg", 
   	   			  "pictures/DialoguePaper/6.jpg","pictures/DialoguePaper/7.jpg", "pictures/DialoguePaper/8.jpg",
   	   			  "pictures/DialoguePaper/9.jpg", "pictures/DialoguePaper/10.jpg",  "pictures/DialoguePaper/11.jpg", 
   	   			  "pictures/DialoguePaper/12.jpg","pictures/DialoguePaper/13.jpg"};
   	   	// ��ǰ��ͼƬ
   	   	BufferedImage currentImage;
   	   	// �ı䵱ǰͼƬ���߳�
   	   	Thread changeThread;

   	   	public  PanelDialoguePaper(final JFrame jframe) throws FileNotFoundException, IOException {
   	   		// TODO �Զ����ɵĹ��캯�����
   	   		for (int i = 0; i < 13; i++)
   	   			images[i] = ImageIO.read(new FileInputStream(imagePath[i]));
   	   		
   	   		    changeThread = new Thread(new Runnable() {

   	   			@Override
   	   			public void run() {
   	   				// TODO �Զ����ɵķ������
   	   				for (int i = 0;i<13; i++) {
   	   					currentImage = images[i];
   	   					repaint();
   	   					try {
   	   						Thread.currentThread().sleep(2000);
   	   					}catch (InterruptedException e) {
   	   						// TODO �Զ����ɵ� catch ��
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

