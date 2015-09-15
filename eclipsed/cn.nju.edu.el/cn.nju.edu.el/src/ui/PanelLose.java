package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelLose extends JPanel{

	public void paintComponent(Graphics g){
		 Image background=new ImageIcon("pictures/background1.jpg").getImage();
		 g.drawImage(background,0,0,getWidth(),getHeight(), null);		 
	}
	
}
