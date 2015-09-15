package yyf.FlapyBird;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import yyf.gui.SwingConsole;

public class DrawerPanel extends JPanel implements Runnable {
	int width, height;
	Bird bird;
	ArrayList<Barrier> barriers;

	public DrawerPanel() {
		// TODO 自动生成的构造函数存根
		bird = new Bird(200,200);
		barriers = new ArrayList<Barrier>();
		Thread t = new Thread(this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, width, height);
		width = getWidth();
		height = getHeight();
		checkBarrier();
		System.out.println(barriers.size());
		for (int i = 0; i < barriers.size(); i++) {
			barriers.get(i).set(width, width, height);
			barriers.get(i).setW(width);
			barriers.get(i).setH(height);
			barriers.get(i).move();
			barriers.get(i).paintBarrier(g);
		}
	}
	
	private void checkBarrier(){
		if(barriers.size()==0){
			barriers.add(new Barrier());
		}
		Iterator<Barrier> it=barriers.iterator();
		Barrier bar;
		while(it.hasNext()){
			bar=it.next();
			if(!bar.isAlive()){
				it.remove();
			}
		}
		if(barriers.get(barriers.size()-1).isReady())
			barriers.add(new Barrier());
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			try {
				Thread.currentThread().sleep(10);
				repaint();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame f = new JFrame();
		SwingConsole.run(f, 800, 450);
		f.add(new DrawerPanel());
	}

}
