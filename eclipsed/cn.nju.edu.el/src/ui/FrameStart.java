package ui;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameStart extends JFrame{
	 
	public FrameStart() throws FileNotFoundException, IOException{
		 PanelDialogue pd = new PanelDialogue(this); 
		 this.setTitle("Little Melon Seeds");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,700);
		
		//users cannot change the size
	     this.setResizable(false);
		
		//locate it in the middle
	   Toolkit toolkit=Toolkit.getDefaultToolkit();
	   Dimension screen=toolkit.getScreenSize();
	   int w=(screen.width-this.getWidth())/2;
	   int h=(screen.height-this.getHeight())/2-20;
	   setLocation(w,h);
	   this.setVisible(true);
	   
	  
	   pd.startChange();
	    this.setContentPane(pd);   
	    this.validate();
	   
		
		
		
		  /*
		 ImageIcon start=new ImageIcon("pictures/start.jpg");
		 JButton b1=new JButton(start);
		 b1.setIcon(start);
		// b1.setLayout(new GridLayout(6,2,200,2));
		 this.add(b1);
	*/
		
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO 自动生成的方法存根
		  @SuppressWarnings("unused")
		FrameStart frame=new  FrameStart();
	    //   PanelStart panel=new PanelStart();         
	}
}
