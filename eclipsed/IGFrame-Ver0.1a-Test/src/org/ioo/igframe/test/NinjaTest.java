package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import org.ioo.igframe.core.GContext;
import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.event.GMouseEvent;
import org.ioo.igframe.event.IGEvent;
import org.ioo.igframe.sprite.GAnimator;
import org.ioo.igframe.sprite.GSprite;
import org.ioo.igframe.sprite.SpriteManager;
import org.ioo.igframe.util.GUtils;
/**
 * NinjaTest 某忍者跳跃测试
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 * 声明：本测试图片素材来源于网络，仅供测试学习技术之用，对此引起的任何问题本人概不负责
 */
public class NinjaTest extends GModel {
	//窗口宽高
	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	GSprite bg = null;
	Ninja ninja = null;
	WallTile wt = null;
	GAnimator j5;
	GAnimator j4;
	
	public void onLoad() {
		bg = new GSprite("/res/images/nj/background.jpg");
		wt = new WallTile("/res/images/nj/wall.png", WIDTH, HEIGHT);
		
		ninja = new Ninja(wt.getWidth() - 10, HEIGHT);
		
		j5 = new GAnimator("/res/images/nj/bird.png", 4, 125, 101, 15, 1);
		j5.setX(100);
		j5.setY(20);
		
		j4 = new GAnimator("/res/images/nj/star.png", 4, 64, 64, 8, 1);
		j4.setX(130);
		j4.setY(180);
		
		SpriteManager.add(bg, wt , ninja, j5, j4);
	}
	
	public void onRender(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		g2d.drawString("time:"+GUtils.formatPlayTime(GContext.getGClock().microTime()), 10, 20);
	}
	
	public void onMousePressed(GMouseEvent evt) {
		if(evt.getButtonCode() == IGEvent.MOUSE_LEFT_BUTTON) {
			ninja.jump();
		}
	}

	public static void main(String[] args) {
		GContext.autoRender(true);
		GFrame gFrame = new GFrame("Ninja Test",
				new NinjaTest(), 50, WIDTH, HEIGHT);
		gFrame.setShowFPS(true);
		gFrame.setAlias(true);
		gFrame.setRenderQuality(true);
		gFrame.showFrame();
	}
}
