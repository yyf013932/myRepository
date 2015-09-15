package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import org.ioo.igframe.core.GContext;
import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.event.GKeyEvent;
import org.ioo.igframe.event.GMouseEvent;
import org.ioo.igframe.event.IGEvent;
import org.ioo.igframe.sprite.GSprite;
/**
 * 精灵测试
 * @author: ioozhuangzi 
 * @version: 0.1 
 * @Copyright: IGFrame
 */
public class SpriteTest extends GModel {
	//窗口宽高
	public static final int WIDTH = 256 *2;
	public static final int HEIGHT = 192 *2;
	
	private GSprite s;
	private GSprite s2;

	public void onLoad() {
		s = new GSprite("/res/images/2.png");
//		s.setScale(2);
		s2 = new GSprite("/res/images/igf_cursor.png");
		s2.setShowBounds(true);//显示精灵矩形
//		s2.setScale(2);
	}

	public void onRender(Graphics2D g2d) {
		s.render(g2d);
		s2.render(g2d);
		g2d.setFont(new Font("宋体", Font.BOLD, g2d.getFont().getSize()+5));
		if(s.collisionWith(s2)) {//矩形冲突检测
			g2d.setColor(Color.RED);
			g2d.drawString("鼠标移入图片", 10, 20);
		}
		else {
			g2d.setColor(Color.GREEN);
			g2d.drawString("鼠标移出图片", 10, 20);
		}
	}
	
	public void onKeyPressed(GKeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			GContext.getGFrame().exit();
		}
	}
	
	public void onMouseProc(GMouseEvent evt) {
		if(evt.getType() == IGEvent.MOUSE_DRAGGED || evt.getType() == IGEvent.MOUSE_MOVED) {
			s2.setX(evt.getMouseX());
			s2.setY(evt.getMouseY());
		}
		super.onMouseProc(evt);
	}

	public static void main(String[] args) {
		GFrame gFrame = new GFrame("IGFrame Sprite Test",
				new SpriteTest(), 50, WIDTH, HEIGHT);
		gFrame.setShowFPS(true);
		gFrame.setShowCursor(false);//隐藏鼠标
		gFrame.showFrame();
	}
}
