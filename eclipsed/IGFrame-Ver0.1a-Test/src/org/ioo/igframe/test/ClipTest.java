package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.event.GMouseEvent;
import org.ioo.igframe.event.IGEvent;
import org.ioo.igframe.media.sound.GSoundFactory;
import org.ioo.igframe.media.sound.IGClipPlayer;
/**
 * ClipTest Clip音效测试
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class ClipTest extends GModel {
	//窗口宽高
	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	IGClipPlayer clip = null;
	
	public void onLoad() {
		//创建ClipPlayer，仅支持wav文件
		clip = GSoundFactory.createClipPlayer("/res/sound/A5_04107.wav" , GSoundFactory.CLIP_PLAYER_SIMPLE);
	}
	
	public void onRender(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		g2d.drawString("请在屏幕上点击鼠标左键或右键", 10, 20);
	}

	public void onMousePressed(GMouseEvent evt) {
		if(evt.getButtonCode() == IGEvent.MOUSE_LEFT_BUTTON) {
			clip.load("/res/sound/A5_04107.wav");//加载
		}
		else if(evt.getButtonCode() == IGEvent.MOUSE_RIGHT_BUTTON) {
			clip.load("/res/sound/A5_04108.wav");//加载
		}
		clip.play();//播放
	}
	
	public void onExit() {
		clip.release();//释放
	}

	public static void main(String[] args) {
		GFrame gFrame = new GFrame("IGFrame Clip Test",
				new ClipTest(),50, WIDTH, HEIGHT);
		gFrame.setShowFPS(true);
		gFrame.showFrame();
	}

}
