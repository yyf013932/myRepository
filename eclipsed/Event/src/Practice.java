
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Practice {
	boolean runstate = false;
	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	Mydrawer drawer = new Mydrawer();
	int x = 0, y = 0;
	Color color = Color.red;

	public static void main(String[] args) {
		Practice pra = new Practice();
		pra.go();
	}

	void go() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1.setText("Run!!");
		button2.setText("Change the color!!");
		button3.setText("Clear!!");

		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.getContentPane().add(BorderLayout.WEST, button2);
		frame.getContentPane().add(BorderLayout.SOUTH, button3);
		frame.getContentPane().add(BorderLayout.CENTER, drawer);

		button1.addActionListener(new RunListener());
		button2.addActionListener(new ColorListener());
		button3.addActionListener(new ClearListener());

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int Red = (int) (Math.random() * 255);
			int Green = (int) (Math.random() * 255);
			int Blue = (int) (Math.random() * 255);
			color = new Color(Red, Green, Blue);
			drawer.repaint();
		}
	}

	class RunListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			new Thread(new Runnable() {
				public void run() {
					runstate = true;
					JButton b=(JButton)e.getSource();
					b.setEnabled(false);
					while (runstate) {
						int i = 0;
						if (i < 96) {
							x += 3;
							y += 4;
							drawer.repaint();
							i++;
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if(i==96)
							runstate=false;
					}
					b.setEnabled(true);
				}
			}).start();

		}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			runstate = false;
			x = 0;
			y = 0;
			color = Color.red;
			drawer.repaint();
		}
	}

	class Mydrawer extends JPanel {
		public void paintComponent(Graphics g) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(color);
			g.fillOval(x, y, 20, 20);
		}
	}
}
