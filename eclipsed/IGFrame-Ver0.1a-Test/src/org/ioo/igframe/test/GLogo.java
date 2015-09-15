package org.ioo.igframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;

import org.ioo.igframe.sprite.GSprite;
/**
 * IGFrame Logo 精灵
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class GLogo extends GSprite {
	private BufferedImage bImage = null;
	private int alpha = 240;
	private int direct = 1;
	private List<BufferedImage> list = new ArrayList<BufferedImage>();
	private int index = 0;
	private int delta;
	private int delayCnt = 0;
	
	public GLogo() {
		this.delta = 15;
	}
	
	public void loadImage(String path) {
		try {
			super.loadImage(path);
			bImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2d = (Graphics2D) bImage.getGraphics();
			g2d.drawImage(this.getImage(), 0, 0, null);
			
			for(int i = 0; i < 28; i++) {
				int[] rgb = new int[3];
				BufferedImage temp = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
				for (int j1 = bImage.getMinY(); j1 < bImage.getHeight(); j1++) {
					for (int j2 = bImage.getMinX(); j2 < bImage.getWidth(); j2++) {
						int pixel = bImage.getRGB(j2, j1);
						rgb[0] = (pixel & 0xff0000 ) >> 16 ;   
						rgb[1] = (pixel & 0xff00 ) >> 8 ;   
						rgb[2] = (pixel & 0xff );  
						if(rgb[0] * 100 + rgb[1] * 10 + rgb[2] != 0)
							pixel = ( (alpha + 1) << 24) | (pixel & 0x00ffffff);
						else pixel = ( (0 + 1) << 24) | (pixel & 0x00ffffff);
						bImage.setRGB(j2, j1, pixel); 
						temp.setRGB(j2, j1, pixel);
					}
				}
				list.add(temp);
				temp = null;
				if(alpha >= 240) {
					direct = -1;
				}
				else if(alpha <= 30) {
					direct = 1;
				}
				alpha += (delta * direct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void render(Graphics2D g) {
//		if(list.size() >= 27) {
//			bImage = list.get(index);
//		}
		g.drawImage(bImage, this.getX(), this.getY(), null);
	}
	
	public void update() {
		if((delayCnt = (++delayCnt % 4)) == 0) {
			index++;
			if(index % 27 == 0) index = 0;
			bImage = list.get(index);
		}
	}
}
