package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
/**
 * BallTest 乱球测试
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class BallTest extends GModel {
	//窗口宽高
	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	//小球数量
	private static final int NUM_BALLS = 100;//10 50 100
	//0实心或1空心球
	private int ballType = 0;
	//0无  1连线 2连线并填充
	private int lineFillType = 2;
	//小球大小
	private int size = 5;
	//随机数生成器
	private Random rand;
	//小球数组
	private Ball[] ball;
	//当前小球坐标集合
	int[] x = null;
	int[] y = null;
	
	public void onLoad() {
		rand = new Random(System.currentTimeMillis());//以当前时间(毫秒)作为随机数种子
		ball = new Ball[NUM_BALLS];
		// 初始化小球
		for (int i = 0; i < NUM_BALLS; i++) {
			int x = rand.nextInt(WIDTH);
			int y = rand.nextInt(HEIGHT);
			int vx = rand.nextInt(3)+1;
			int vy = rand.nextInt(3)+1;
			ball[i] = new Ball(x, y, vx, vy, ballType, size);
		}
		x = new int[NUM_BALLS];
		y = new int[NUM_BALLS];
	}

	public void onExit() {
		
	}
	
	public void onUpdate() {
		//更新小球位置
		for (int i = 0; i < NUM_BALLS; i++) {
			ball[i].move();
		}
	}

	public void onRender(Graphics2D g) {
		if(lineFillType == 1 || lineFillType == 2) {
			g.setColor(Color.GREEN);
			//连线
			for (int i = 0; i < NUM_BALLS; i++) {
				if(i == 0) {
					g.drawLine(ball[NUM_BALLS - 1].getCx(), ball[NUM_BALLS - 1].getCy()
							, ball[i].getCx(), ball[i].getCy());
				}
				else {
					g.drawLine(ball[i - 1].getCx(), ball[i - 1].getCy()
							, ball[i].getCx(), ball[i].getCy());
				}
				//获取每个小球的中心点坐标
				x[i] = ball[i].getCx();
				y[i] = ball[i].getCy();
			}
		}
		if(lineFillType == 2) {
			//根据小球坐标集合填充多边形
			g.setColor(Color.GRAY);
			g.fillPolygon(x, y, NUM_BALLS);
		}
		
		// 分别绘制相应球体
		for (int i = 0; i < NUM_BALLS; i++) {
			ball[i].draw(g);
		}
	}

	public static void main(String[] args) {
		GFrame gFrame = new GFrame("IGFrame Ball Test",
				new BallTest(),50, WIDTH, HEIGHT);
		gFrame.setShowFPS(true);
		gFrame.setAlias(true);
		gFrame.setRenderQuality(true);
		gFrame.showFrame();
	}
}
