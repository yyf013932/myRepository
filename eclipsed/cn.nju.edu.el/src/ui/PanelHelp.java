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

public class PanelHelp extends JPanel {
	
	ImageIcon return1 = new ImageIcon("pictures/help1.jpg");
	ImageIcon return2 = new ImageIcon("pictures/help1.jpg");
	
	JLabel labreturn = new JLabel("",return1,0);
	
	LabelListener listener;
	JFrame jframe;
	DrawPane drawPane;
	
	public PanelHelp(JFrame jframe){
		this.jframe = jframe;
		drawPane=new DrawPane(jframe);
		setLayout(null);
		
		labreturn.setBounds(735, 555, return1.getIconWidth(), return1.getIconHeight());
		
		
		this.add(labreturn);
		listener = new LabelListener();
		labreturn.addMouseListener(listener);
		labreturn.addMouseMotionListener(listener);
	}
	
	public void paintComponent(Graphics g) {
		Image background = new ImageIcon("pictures/background.jpg").getImage();
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

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
			if (e.getSource()==labreturn){				
				jframe.setContentPane(drawPane);
				jframe.validate();
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

}

