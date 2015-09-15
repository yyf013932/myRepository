package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelWin extends JPanel {
    JFrame jframe;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1211449788312193159L;
	public PanelWin(JFrame jframe){
		this.jframe=jframe;
	}
	
	public void paintComponent(Graphics g){
		 Image background=new ImageIcon("pictures/background.jpg").getImage();
		 g.drawImage(background,0,0,getWidth(),getHeight(), null);		 
	}
	

}
