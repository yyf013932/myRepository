package org.ioo.igframe.test;

import java.awt.Graphics2D;


import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.sprite.GAnimator;
import org.ioo.igframe.sprite.GSprite;
import org.ioo.igframe.sprite.SpriteManager;

/**
 * AnimatorTest 鍔ㄧ敾娴嬭瘯
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class AnimatorTest extends GModel {
	//绐楀彛瀹介珮
	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	GAnimator g = null;
	GAnimator g2 = null;
	
	GAnimator j = null;
	GAnimator j2 = null;
	GAnimator j3 = null;
	
	GAnimator j4 = null;
	GAnimator j5 = null;
	GAnimator j6 = null;
	
	GAnimator j7 = null;
	GAnimator j8 = null;
	GAnimator j9 = null;
	
	GAnimator j10 = null;
	GAnimator j11 = null;
	
	GSprite bg = null;
	GSprite fg = null;
	
	public void onLoad() {//鍒濆鍖�
		j = new GAnimator("/res/images/nj/falling.png", 9, 55, 55, 18, 2);
		j.setX(50);
		j.setY(200);
		j2 = new GAnimator("/res/images/nj/climbing.png", 6, 40, 40, 16, 1);
		j2.setX(50);
		j2.setY(50);
		j3 = new GAnimator("/res/images/nj/jumping.png", 5, 100, 100, 10, 1);
		j3.setX(50);
		j3.setY(100);
		
		j4 = new GAnimator("/res/images/nj/star.png", 4, 64, 64, 8, 1);
		j4.setX(50);
		j4.setY(280);
		j5 = new GAnimator("/res/images/nj/bird.png", 4, 125, 101, 15, 1);
		j5.setX(150);
		j5.setY(20);
		j6 = new GAnimator("/res/images/nj/squirrel.png", 5, 85, 85, 15, 2);
		j6.setX(150);
		j6.setY(150);
		
		j7 = new GAnimator("/res/images/nj/climber2.png", 8, 60, 60, 16, 1);
		j7.setX(50);
		j7.setY(350);
		j8 = new GAnimator("/res/images/nj/bird2.png", 4, 40, 40, 12, 1);
		j8.setX(150);
		j8.setY(230);
		j9 = new GAnimator("/res/images/nj/squirrel2.png", 4, 50, 25, 8, 2);
		j9.setX(150);
		j9.setY(300);
		
		j10 = new GAnimator("/res/images/nj/bomb.png", 6, 67, 96, 6, 2);
		j10.setX(150);
		j10.setY(350);
		j11 = new GAnimator("/res/images/nj/star2.png", 4, 30, 30, 4, 1);
		j11.setX(60);
		j11.setY(420);
		
		bg = new GSprite("/res/images/nj/background.jpg");
		fg = new GSprite("/res/images/nj/foreground.png");
		
		//鍔犲叆娓叉煋闆嗗悎
		SpriteManager.add(bg, fg, j, j2, j3, j4, j5, j6 ,j7, j8, j9, j10, j11);
	}
	
	public void onRender(Graphics2D g2d) {//娓叉煋
		
	}
	
	public static void main(String[] args) {
		GFrame gFrame = new GFrame("Animator Test",//绐楀彛鏍囬
				new AnimatorTest(), //鍛ㄦ湡妯″瀷
				50, //FPS
				WIDTH, HEIGHT);//瀹姐�侀珮
		gFrame.setShowFPS(true);//鏄剧ずFPS
		gFrame.autoRender(true);//鑷姩娓叉煋
		gFrame.showFrame();//鏄剧ず绐楀彛
	}
}
