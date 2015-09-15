package gui_exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import yyf.gui.SwingConsole;

public class MyComponent extends JFrame{
Container cont=getContentPane();
MyButton bo=new MyButton();
	void run(){
		cont.setLayout(null);
		SwingConsole.run(this,700,500);
		cont.add(bo);
		bo.setBounds(50,50,100,100);
		bo.addActionListener(bo);
		bo.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
	}
	public static void main(String[]args){
		MyComponent my=new MyComponent();
		my.run();
	}
}

class MyButton extends JButton implements ActionListener{

	public void paint(Graphics g) {

		g.setColor(Color.red);
		g.fillRect(0, 0, 100, 100);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("Pressed.");
	}

}
