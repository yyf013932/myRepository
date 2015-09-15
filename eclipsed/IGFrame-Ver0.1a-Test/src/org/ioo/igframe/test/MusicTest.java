package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.event.GKeyEvent;
import org.ioo.igframe.event.GMouseEvent;
import org.ioo.igframe.event.IGEvent;
import org.ioo.igframe.media.sound.GSoundFactory;
import org.ioo.igframe.media.sound.IGPlayer;
import org.ioo.igframe.sprite.GSprite;

/**
 * IGFrame音乐播放示例
 * @author: ioozhuangzi 
 * @version: 0.1 
 * @Copyright: IGFrame
 */
public class MusicTest extends GModel {
	private IGPlayer player = null;
	private String status = "STOP";
	
	private int mx = 0,my = 0;
	
	private GSprite s,t;

	public void onLoad() {
		//生源
		s = new GSprite("/res/images/s.png");
		s.setX(160);
		s.setY(90);
		//鼠标
		t = new GSprite();
		t.setX(160);
		t.setY(90);
		
		player = GSoundFactory.createSoundPlayer("/res/sound/STR0451.mp3", 
				GSoundFactory.MP3_PLAYER);
		
		//打开下边的代码为添加3D声效，绑定两个Sprite和最大距离,精灵s为声源，t为鼠标位置，移动鼠标试试,鼠标离生源越近，音量越大
//		player.addEffector(new G3DEffector(s, t, 180));
		
		player.setLoop(IGPlayer.INFINITE_LOOP);
	}

	public void onExit() {
		player.release();
	}

	public void onRender(Graphics2D g) {
		g.setColor(Color.GREEN);
		Font font = g.getFont();
		g.setFont(new Font("宋体", Font.BOLD, font.getSize()+3));
		g.drawString(status, 10, 20);
		g.drawString("文件:"+player.getFileName(), 10, 35);
		g.drawString("时长:"+player.getFormatLength(), 10, 50);
		g.drawString("时间:"+player.getFormatPosition(), 10, 65);
		g.drawString("模式:"+(player.getLastLoop() < 0 ? "INFINITE_LOOP" : player.getLastLoop()), 10, 80);
		g.drawString("音量:"+player.getVolume(), 10, 95);
		g.drawString("声相:"+String.format("%.3f", player.getPan()), 10, 110);
		g.setFont(new Font("宋体", Font.BOLD, font.getSize()));
		g.drawString("播放:Enter; 暂停/恢复:Space; 停止:Esc", 10, 175);
		g.drawString("音量:↑/↓; 声相:←/→", 10, 190);
		
		s.render(g);
		
		g.drawString(String.format("x:%s y:%s", mx, my), 200, 65);
	}
	
	public void onKeyPressed(GKeyEvent gKeyEvent) {
		if(gKeyEvent.getKeyCode() == IGEvent.VK_UP) {
			player.setVolume(player.getVolume() + 0.5f);
		}
		else if(gKeyEvent.getKeyCode() == IGEvent.VK_DOWN) {
			player.setVolume(player.getVolume() - 0.5f);
		}
		else if(gKeyEvent.getKeyCode() == IGEvent.VK_LEFT) {
			player.setPan(player.getPan() - 0.01f);
		}
		else if(gKeyEvent.getKeyCode() == IGEvent.VK_RIGHT) {
			player.setPan(player.getPan() + 0.01f);
		}
		else if(gKeyEvent.getKeyCode() == IGEvent.VK_ENTER) {
			if(!player.isPlaying()) {
				player.play();
				status = "PLAY";
			}
		}
		else if(gKeyEvent.getKeyCode() == IGEvent.VK_ESCAPE) {
			if(player.isPlaying()) {
				player.stop();
				status = "STOP";
			}
		}
		else if(gKeyEvent.getKeyCode() == IGEvent.VK_SPACE) {
			if(player.isPlaying()) {
				if(player.isPaused()) {
					player.resume();
					status = "PLAY";
				}
				else {
					player.pause();
					status = "PAUSE";
				}
			}
		}
	}
	
	public void onMouseMoved(GMouseEvent evt) {
		mx = evt.getMouseX();
		my = evt.getMouseY();
		t.setX(mx);
		t.setY(my);
	}

	public static void main(String[] args) throws Exception {
		GFrame gFrame = new GFrame("IGFrame-MusicTest",
				new MusicTest(), 30, 360, 200);
		gFrame.setShowFPS(true);
		gFrame.showFrame();
	}
}
