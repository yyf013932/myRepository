package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.media.sound.GSoundFactory;
import org.ioo.igframe.media.sound.IGPlayer;
/**
 * IGFrame Logo Test
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class LogoTest extends GModel {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private GLogo logo = null;
	private StarSky ss = null;
	IGPlayer bgm = null;
	
	public void onLoad() {
		ss = new StarSky(WIDTH, HEIGHT);
		
		logo = new GLogo();
		logo.loadImage("/res/images/igf_logo_bk.png");
		logo.setX((WIDTH - logo.getWidth())/2);
		logo.setY((HEIGHT - logo.getHeight())/2);
		
		//创建MP3播放器
		bgm = GSoundFactory.createSoundPlayer("/res/sound/STR0451.mp3", 
				GSoundFactory.MP3_PLAYER_SIMPLE);
		bgm.setLoop(IGPlayer.INFINITE_LOOP);//无限循环
		bgm.play();//播放
	}
	
	public void onExit() {
		bgm.release();//释放
	}
	
	public void onUpdate() {
		logo.update();
	}
	
	public void onRender(Graphics2D g) {
		ss.render(g);
		logo.render(g);
		g.setColor(Color.GREEN);
		g.drawString("MusicTime: " + bgm.getFormatPosition(), 10, 20);
	}
	
	public static void main(String[] args) {
		final GFrame gFrame = new GFrame("IGFrame Logo Test",
				new LogoTest(), 40, WIDTH, HEIGHT);
		gFrame.setShowFPS(true);
		gFrame.setAlias(true);
		gFrame.setRenderQuality(true);
		gFrame.showFrame();
	}
	
}
