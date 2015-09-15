package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.event.GMouseEvent;
import org.ioo.igframe.event.IGEvent;
import org.ioo.igframe.sprite.GAnimator;
import org.ioo.igframe.sprite.SpriteManager;

public class AnimatorTest2 extends GModel {
	//窗口宽高
	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	
	GAnimator g = null;
	GAnimator g2 = null;
	
	public void onLoad() {
		g = new GAnimator("/res/images/explosion.png", 5, 128, 128, 30 , 2);
		g.setLoop(1);
		g.setVisible(false);
		
		g2 = new GAnimator(g);//使用其他精灵初始化
		
		SpriteManager.add(g, g2);//使用自动渲染队列
	}
	
	public void onUpdate() {
//		g.update();
//		g2.update();
	}

	public void onRender(Graphics2D g2d) {
//		bg.render(g2d);
//		g.render(g2d);
//		g2.render(g2d);
		g2d.setColor(Color.GREEN);
		g2d.drawString("请在屏幕上点击鼠标左键或右键", 10, 20);
	}
	
	public void onMousePressed(GMouseEvent evt) {
		int mx = evt.getMouseX();
		int my = evt.getMouseY();
		if(evt.getButtonCode() == IGEvent.MOUSE_LEFT_BUTTON) {//左键
			g.reset();
			g.setX(mx - g.getFrameWidth()/2);
			g.setY(my - g.getFrameWidth()/2);
			g.setVisible(true);
		}
		else if(evt.getButtonCode() == IGEvent.MOUSE_RIGHT_BUTTON) {//左键
			g2.reset();
			g2.setX(mx - g.getFrameWidth()/2);
			g2.setY(my - g.getFrameWidth()/2);
			g2.setVisible(true);
		}
	}

	public static void main(String[] args) {
		GFrame gFrame = new GFrame("Animator Test2",
				new AnimatorTest2(), 50, WIDTH, HEIGHT);
		gFrame.setShowFPS(true);
//		gFrame.setFullScreen(true);//全屏,按Esc退出全屏
		gFrame.autoRender(true);//开启使用自动渲染队列
		gFrame.showFrame();
	}
}
