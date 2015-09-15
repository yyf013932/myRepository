
package maingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.PanelLose;
import ui.PanelWin;

@SuppressWarnings("serial")
public class DrawPane extends JPanel implements Runnable {
	  private Bird bird;
	  private ArrayList<Barrier> barriers;
	  private JLabel time,leftTime;
	  private int maxTime=1*5;
	  
	  private Thread gameThread;
//	private int score;
	  private int leftTimes=maxTime;
	  private String timeMessage;
	  private boolean end=true;
//	  ImageIcon timecounter = new ImageIcon("pictures/start1.jpg");
	  Image runner= new ImageIcon("pictures/runner.png").getImage();
	  Image background = new ImageIcon("pictures/game4.jpg").getImage();
	  Image stone=new ImageIcon("pictures/b.png").getImage();
	  JFrame jframe;
	  PanelWin panelWin;
	  PanelLose panelLose;

	public DrawPane(JFrame jframe) {
        this.jframe=jframe;
		bird = new Bird();
		barriers = new ArrayList<Barrier>();	
		time=new JLabel("Time:");
		leftTime= new JLabel(getTimeMessage());
		setLayout(null);
		time.setBounds(0, 0, 60, 60);
		leftTime.setBounds(15,15,70,70);
		time.setFont(new Font("Cambria", Font.BOLD, 20));
		time.setForeground(Color.BLUE);
	    leftTime.setFont(new Font("Cambria", Font.BOLD, 20));
		leftTime.setForeground(Color.BLUE);
	   
	   
		add(time);
		add(leftTime);
		timeMessage=leftTimes/60+" : "+(leftTimes-60*(leftTimes/60));
	}
	
	public void startGame() {
		end = false;
		new Thread(bird).start();
		new BarrierManager(barriers);
		gameThread=new Thread(this);
		gameThread.start();
		
		Runnable runnable=new Runnable(){
			
			public void run(){
				try{
					 while(!end){						
						  if(leftTimes==0){
							   	 changeSucceed();	
							   Thread.currentThread().interrupt();	  	
							   gameThread.stop();
							   //System.out.println("11");
							    break;
					      }
						  leftTimes--;
					      timeMessage=leftTimes/60+" : "+(leftTimes-60*(leftTimes/60));
					      repaint();
					      Thread.currentThread();
						  Thread.sleep(1000);
				}
				//System.out.println("OVER");		
				
			}catch(InterruptedException iex) {
				   throw new RuntimeException("Interrupted",iex);
			}
		}
		  
	   };
	   Thread thread=new Thread(runnable,"time");
	   thread.start();
	   
	}
	
	
//	public int getScore() {
//		return score;
//	}
   public String getTimeMessage(){
	   return timeMessage;
   }
   
	public Bird getBird() {
		return bird;
	}

	public ArrayList<Barrier> getBarriers() {
		return barriers;
	}

	// 鐢婚笩
	private void paintBird(Graphics g, Bird b) {
		 int x = transX(b.getX()), y = transY(b.getY()), xSize = transX(b
				.getSize()), ySize = transY(b.getSize());
    //g.drawOval(x - xSize, y - ySize, 2 * xSize, 2 * ySize);
		 g.drawImage(background,0,0,getWidth(),getHeight(),null);
		 g.drawImage(runner,x,y,xSize*2, ySize*2,null);
         

	}

	// 鐢婚殰纰嶇墿
	private void paintBarriers(Graphics g, Barrier b) {
		int x = transX(b.getX()), top = transY(b.getTop()), space = transY(b
				.getSpace()), width = transX(b.getWidth());
       
//	    g.setColor(Color.RED);	   
//	    g.fillRect(x, 0, width, top);
//		g.fillRect(x, top + space, width, getHeight() - top - space);
		 g.drawImage(stone,x, 0, width, top,null);
			g.drawImage(stone,x, top + space, width, getHeight() - top - space,null);
           
	}

	// 灏嗗潗鏍囪浆鎹负褰撳墠绐楀彛涓嬬殑鍧愭爣
	private int transX(double x) {
		return (int) (x * getWidth() / 160);
	}

	private int transY(double y) {
		return (int) (y * getHeight() / 90);
	}
    
	// 鐢诲嚭鎵�湁鍏冪礌
	public void paintComponent(Graphics g) {
		//鐢昏儗鏅�姝讳簡涔嬪悗鐩存帴璺宠浆鍒板彟涓�釜鐣岄潰
//		Image background = new ImageIcon("pictures/game4.jpg").getImage();
//		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
         
		if (!end) {
			g.clearRect(0, 0, getWidth(), getHeight());
			paintBird(g, bird);
			for (Barrier b : barriers) {
				paintBarriers(g, b);
			}
			leftTime.setText(timeMessage);
		}

	}


	class BarrierManager implements Runnable {
		ArrayList<Barrier> b;

		public BarrierManager(ArrayList<Barrier> b) {
			this.b = b;
			new Thread(this).start();
		}

		@Override
		public void run() {
			
			try {
				while (!end) {
					if (b.size() == 0)
						b.add(new Barrier());
					if (!b.get(0).isAlive())
						b.remove(0);
					if (b.get(b.size() - 1).isReady())
						b.add(new Barrier());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	
	@Override
	public void run() {
	
		try {
			while (!end) {
				checkState();
				repaint();
				Thread.currentThread();
				Thread.sleep(50);
			}
			System.out.println("OVER");
		     changeFail();
		} catch (Exception e) {
			// TODO: handle exception
		}
     
	}
    
	public void changeFail(){
	  //  System.out.println("f");

        panelLose=new PanelLose(jframe);
	      jframe.setContentPane(panelLose);
	  
		  jframe.validate();
	}
	
	public void changeSucceed(){
		//System.out.println("w");
        panelWin=new PanelWin(jframe);
		  jframe.setContentPane(panelWin);
		  jframe.validate();
	}
	
	// 妫�煡娓告垙鐘舵�
	public void checkState() {
		double birdX = bird.getX(), birdY = bird.getY(),birdSize=bird.getSize();
				//birdHeight = bird.getHeight();birdWidth=bird.getWidth();
		for (Barrier b : barriers) {
			double x = b.getX(), top = b.getTop(), width = b.getWidth(), space = b.getSpace();
			if (((x - birdSize) < birdX) && (birdX < x) && (birdY < top)) {
				end = true;
				break;
			}
			if (((birdX - x) * (birdX - x) + (birdY - top) * (birdY - top)) < (birdSize* birdSize)) {
				end = true;
				break;
			}
			if ((x < birdX)
					&& (birdX < (x + width) && (birdY < top + birdSize))) {
				end = true;
				break;
			}
			if (((birdX - x - width) * (birdX - x - width) + (birdY - top)
					* (birdY - top)) < (birdSize * birdSize))
				if (((x - birdSize) < birdX) && (birdX < x)
						&& ((top + space) < birdY)) {
					end = true;
					break;
				}
			if (((birdX - x) * (birdX - x) + (birdY - top - space)
					* (birdY - top - space)) < (birdSize * birdSize)) {
				end = true;
				break;
			}
			if ((x < birdX)
					&& (birdX < (x + width) && (top + space - birdSize < birdY))) {
				end = true;
				break;
			}
			if (((birdX - x - width) * (birdX - x - width) + (birdY - top - space)
					* (birdY - top - space)) < (birdSize * birdSize)) {
				end = true;
				break;
			}
		}
		if (birdY < birdSize || birdY > (90 - birdSize))
			end = true;
	}
//
//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		DrawPane p = new DrawPane();
//		f.add(p);
//		f.addKeyListener(p.getBird());
//		p.startGame();
//		
//	}

}
