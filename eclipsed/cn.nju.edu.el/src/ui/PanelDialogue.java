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
        	   	// ������Ҫ���ŵ�ͼƬ������
        	   	BufferedImage[] images = new BufferedImage[14];
        	   	// 3��ͼƬ�ĵ�ַ���Լ�д��
        	   	String[] imagePath = { "pictures/DialogueBegin/1.jpg", "pictures/DialogueBegin/2.jpg", 
        	   			  "pictures/DialogueBegin/3.jpg",  "pictures/DialogueBegin/4.jpg", "pictures/DialogueBegin/5.jpg", 
        	   			  "pictures/DialogueBegin/6.jpg","pictures/DialogueBegin/7.jpg", "pictures/DialogueBegin/8.jpg",
        	   			  "pictures/DialogueBegin/9.jpg", "pictures/DialogueBegin/10.jpg",  "pictures/DialogueBegin/11.jpg", 
        	   			  "pictures/DialogueBegin/12.jpg","pictures/DialogueBegin/13.jpg"};
        	   	// ��ǰ��ͼƬ
        	   	BufferedImage currentImage;
        	   	// �ı䵱ǰͼƬ���߳�
        	   	Thread changeThread;

        	   	public  PanelDialogue( final JFrame jframe) throws FileNotFoundException, IOException {
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
        	   						Thread.currentThread().sleep(2500);
        	   					}catch (InterruptedException e) {
        	   						// TODO �Զ����ɵ� catch ��
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
