package org.ioo.igframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import org.ioo.igframe.core.GFrame;
import org.ioo.igframe.core.GModel;
import org.ioo.igframe.event.GKeyEvent;
import org.ioo.igframe.event.GMouseEvent;
import org.ioo.igframe.event.IGEvent;
/**
 * IGFrame HelloWorld
 * @author: ioozhuangzi 
 * @version: 0.1a
 * @Copyright: IGFrame
 */
public class HelloWorld extends GModel {
	private static int width = 640;
	private static int height = 320;
	int x = 10,y = 20;
	
	//加载
	public void onLoad() {
		
	}
	
	//更新帧
	public void onUpdate() {
		
	}
	
	//渲染帧
	public void onRender(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		g2d.drawString("Hello World!", x, y);
	}
	
	//键盘按下
	public void onKeyPressed(GKeyEvent evt) {
		if(evt.getKeyCode() == IGEvent.VK_UP) {//上
			
		}
		else if(evt.getKeyCode() == IGEvent.VK_DOWN) {//下
			
		}
		else if(evt.getKeyCode() == IGEvent.VK_LEFT) {//左
			
		}
		else if(evt.getKeyCode() == IGEvent.VK_RIGHT) {//右
			
		}
	}
	
	//键盘抬起
	public void onKeyReleased(GKeyEvent evt) {
		
	}
	
	//鼠标移动
	public void onMouseMoved(GMouseEvent evt) {
//		int mx = evt.getMouseX();//x坐标
//		int my = evt.getMouseY();//y坐标
		
	}
	
	//鼠标按下
	public void onMousePressed(GMouseEvent evt) {
		int mx = evt.getMouseX();//x坐标
		int my = evt.getMouseY();//y坐标
		if(evt.getButtonCode() == IGEvent.MOUSE_LEFT_BUTTON) {//左键
			x = mx;
			y = my;
		}
		else if(evt.getButtonCode() == IGEvent.MOUSE_RIGHT_BUTTON) {//右键
			
		}
	}
	
	//鼠标抬起
	public void onMouseReleased(GMouseEvent evt) {
//		int mx = evt.getMouseX();//x坐标
//		int my = evt.getMouseY();//y坐标
		
	}
	
	//退出
	public void onExit() {
		
	}
	
	public static void main(String[] args) {
		GFrame gFrame = new GFrame("IGFrame Video Demo",//窗口标题
				new HelloWorld(),//游戏周期模型
				50, //fps
				width, height);//宽高
		gFrame.setShowFPS(true);//显示fps
//		gFrame.setFullScreen(true);//全屏
		gFrame.showFrame();//显示窗口
	}
}
