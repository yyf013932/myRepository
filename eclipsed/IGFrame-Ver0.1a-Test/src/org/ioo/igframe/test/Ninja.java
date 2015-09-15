package org.ioo.igframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.ioo.igframe.sprite.GAnimator;
import org.ioo.igframe.util.ImageLoader;
/**
 * Ninja 某忍者跳跃测试
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 * 声明：本测试图片素材来源于网络，仅供测试学习技术之用，对此引起的任何问题本人概不负责
 */
public class Ninja extends GAnimator {
	public final static int STATE_RUNNING = 2;
	public final static int STATE_JUMPING = 3;
//	public static final int STATE_DEAD = 0;//super
	
	//当前Animator为跑动动画
	private GAnimator jumping = null;
//	private GAnimator failing = null;
	
	private BufferedImage filpImage = null;
	private BufferedImage orgImage = null;
	
	private BufferedImage jorgImage = null;
	private BufferedImage jumpFilpImage = null;
	
	private int jumpCnt = 0;
	private int orgX;
	
	public Ninja(int x, int y ) {
		super("/res/images/nj/climbing.png", 6, 40, 40, 16, 1);
		this.orgImage = image;
		this.filpImage = ImageLoader.loadBufferedImage("/res/images/nj/climbing_flip.png");
		
		this.x = x;
		this.orgX = x;
		this.y = y - this.getFrameHeight() * 3;
		
		jumping = new GAnimator("/res/images/nj/jumping.png", 5, 100, 100, 10, 1);
		jorgImage = jumping.getImage();
		this.jumpFilpImage = ImageLoader.loadBufferedImage("/res/images/nj/jumping_flip.png");
		jumping.setX(this.getX() - 40);
//		jumping.setX(100);
		jumping.setY(this.getY() - 30);
		jumping.setVisible(false);
		jumping.setLoop(1);
		
		super.direct = DIRECT_LEFT;
		super.state = STATE_RUNNING;
	}
	
	public void update() {
		if(state == STATE_RUNNING) {
			super.update();
		}
		else if(state == STATE_JUMPING) {
			if(!jumping.isVisible()) {
				state = STATE_RUNNING;
			}
			jumpCnt++;
			processJump();
			jumping.update();
		}
	}

	public void render(Graphics2D g2d) {
		if(state == STATE_RUNNING) {
			super.render(g2d);
		}
		else if(state == STATE_JUMPING) {
			jumping.render(g2d);
		}
	}

	public void jump() {
		if(state == STATE_JUMPING) return;
		state = STATE_JUMPING;
		jumping.setVisible(true);
		if(direct == DIRECT_LEFT) {
			direct= DIRECT_RIGHT;
			this.image = filpImage;
			jumping.setX(this.x-40);
			this.x = 320 - (orgX + getFrameWidth());
			
			jumping.setImage(jumpFilpImage);
//			System.out.println("Jump Right~");
		}
		else if(direct == DIRECT_RIGHT) {
			direct = DIRECT_LEFT;
			this.image = orgImage;
			jumping.setX(this.x-10);
			this.x = orgX;
			
			jumping.setImage(jorgImage);
//			System.out.println("Jump Left~");
		}
	}
	
	public void processJump() {
		if(direct == DIRECT_LEFT) {
			jumping.setX(jumping.getX()- 13);
//			System.out.println(jumping.getX());
		}
		else if(direct == DIRECT_RIGHT) {
			jumping.setX(jumping.getX()+ 13);
		}
		if((jumpCnt++) > this.getTotalFrames()+1) {
			jumpCnt = 0;
		}
	}
	
}
