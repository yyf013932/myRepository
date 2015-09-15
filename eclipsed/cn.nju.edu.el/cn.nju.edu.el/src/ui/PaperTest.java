package ui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PaperTest extends JFrame {
     public static void main(String[] args){
    	 JFrame frame=new JFrame();
        PanelPaper paper=new PanelPaper(frame);
    	 frame.setSize(1000, 700);
    	 frame.setVisible(true);
    	 frame.setContentPane(paper);
     }
}
