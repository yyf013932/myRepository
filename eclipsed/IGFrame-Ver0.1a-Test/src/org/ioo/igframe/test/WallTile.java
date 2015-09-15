package org.ioo.igframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.ioo.igframe.sprite.GSprite;
import org.ioo.igframe.util.ImageProcess;
/**
 * Ninja 某忍者跳跃Tile
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 * 声明：本测试图片素材来源于网络，仅供测试学习技术之用，对此引起的任何问题本人概不负责
 */
public class WallTile extends GSprite {
	private int scrWidth;
	@SuppressWarnings("unused")
	private int scrHeight;
	private int delta = 0;
	private BufferedImage flipImage = null;
	private int deltaY = 0;
	private int velocity = 5;
	
	public WallTile(String filePath, int scrWidth, int scrHeight) {
		super(filePath);
		flipImage = ImageProcess.flipImage(image);
		this.scrWidth = scrWidth;
		this.scrHeight = scrHeight;
		delta = (scrHeight / super.getHeight()) + 1;
		System.out.println(delta);
	}
	
	public void update() {
		if(deltaY >= 64) {
			deltaY = 0;
		}
		deltaY += velocity;
	}

	public void render(Graphics2D g2d) {
		for(int i = -2;i < delta;i++) {
			super.x = 0;
			super.y = (i * super.getHeight()) + deltaY;
			super.render(g2d);
			super.x = scrWidth - super.getWidth();
			this.flipRender(g2d);
		}
	}
	
	private void flipRender(Graphics2D g2d) {
		if(visible) {
			g2d.drawImage(flipImage, x, y, null);
		}
	}
	
}
