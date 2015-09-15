package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelWin extends JPanel {
    
	/**
	 * 
	 */
    ImageIcon nextpaper = new ImageIcon("pictures/nextpaper.png");
    ImageIcon exit = new ImageIcon("pictures/exitpaper.png");
    JLabel labnext,labexit;
    LabelListener listener;
    JFrame jframe;
    //PanelPaper panelPaper ;
    PanelDialoguePaper panelDialoguePaper;
	private static final long serialVersionUID = -1211449788312193159L;
	
	public PanelWin(JFrame jframe){
		
	    this.jframe=jframe;

		 labnext = new JLabel("", nextpaper, 0);
		 labexit=new JLabel("",exit,0);
		setLayout(null);
		labnext.setBounds(758, 338, nextpaper.getIconWidth(), nextpaper.getIconWidth());
		labexit.setBounds(796, 422, exit.getIconWidth(), exit.getIconWidth());
		this.add(labnext);
		this.add(labexit);
		listener = new LabelListener();
		labnext.addMouseListener(listener);
		labnext.addMouseMotionListener(listener);
		labexit.addMouseListener(listener);
		labexit.addMouseMotionListener(listener);
		
	}
	
	public void paintComponent(Graphics g){
		 Image background=new ImageIcon("pictures/backgroundw.jpg").getImage();
		 g.drawImage(background,0,0,getWidth(),getHeight(), null);		 
	}
	
	private class LabelListener extends JFrame implements MouseListener,
			MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(e.getX()+" "+e.getY());
			if(e.getSource() == labnext) {
				try {
					panelDialoguePaper = new PanelDialoguePaper(jframe);
					jframe.setContentPane(panelDialoguePaper);
				    panelDialoguePaper.startChange();
					jframe.validate();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
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
		
	}
//	public static void main(String[] args){
//          JFrame jframe=new JFrame();
//          jframe.setSize(1000, 700);
//          jframe.setContentPane(new PanelWin(jframe));
//          jframe.setVisible(true);
//	}
}

