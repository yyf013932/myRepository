  
  
import java.awt.AlphaComposite;  
import java.awt.BorderLayout;
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.image.BufferedImage;  
import java.io.File;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  





import javax.imageio.ImageIO;  
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;  

import yyf.gui.SwingConsole;
  
  
/** 
 * @author zakisoft.com 
 * 
 */  
public class ZPanel extends javax.swing.JComponent implements ActionListener {  
  
    private static final long serialVersionUID = 1L;  
    private BufferedImage image;  
  
    private static final int ANIMATION_FRAMES = 100;  
    private static final int ANIMATION_INTERVAL = 10;  
      
    private int frameIndex;  
    // ʱ��  
    private Timer timer;  
  
    public BufferedImage getImage() {  
        return image;  
    }  
  
    public void setImage(BufferedImage image) {  
        this.image = image;  
    }  
  
    private int imgWidth;  
    private int imgHeight;  
  
    public int getImgWidth() {  
        return imgWidth;  
    }  
  
    public void setImgWidth(int imgWidth) {  
        this.imgWidth = imgWidth;  
    }  
  
    public int getImgHeight() {  
        return imgHeight;  
    }  
  
    public void setImgHeight(int imgHeight) {  
        this.imgHeight = imgHeight;  
    }  
  
    public ZPanel() {  
    }  
  
    public void setImagePath(String imgPath) {  
        // �÷������Ƽ�ʹ�ã��÷����������أ�ͼ�񲢲����ص��ڴ棬����ͼ��Ŀ�͸�ʱ�᷵��-1��  
        // image = Toolkit.getDefaultToolkit().getImage(imgPath);  
        try {  
            // �÷����Ὣͼ����ص��ڴ棬�Ӷ��õ�ͼ�����ϸ��Ϣ��  
            image = ImageIO.read(new FileInputStream(imgPath));  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        setImgWidth(image.getWidth(this));  
        setImgHeight(image.getHeight(this));  
    }  
  
    public void paintComponent(Graphics g) {  
        int x = 0;  
        int y = 0;  
        if (null == image) {  
            return;  
        }  
        g.drawImage(image, x, y, image.getWidth(null), image.getHeight(null),  
                null);  
    }  
  
    public void paint(Graphics g) {  
        if (isAnimating()) {  
            // ���ݵ�ǰ֡��ʾ��ǰ͸���ȵ��������  
            float alpha = (float) frameIndex / (float) ANIMATION_FRAMES;  
            Graphics2D g2d = (Graphics2D) g;  
            g2d.setComposite(AlphaComposite.getInstance(  
                    AlphaComposite.SRC_OVER, alpha));  
            // Renderer��Ⱦ����  
            super.paint(g2d);  
        } else {  
            // ����ǵ�һ�Σ���������ʱ��  
            frameIndex = 0;  
            timer = new Timer(ANIMATION_INTERVAL, this);  
            timer.start();  
        }  
    }  
  
    // �жϵ�ǰ�Ƿ����ڽ��ж���  
    private boolean isAnimating() {  
        return timer != null && timer.isRunning();  
    }  
  
    // �ر�ʱ�ӣ����³�ʼ��  
    private void closeTimer() {  
        if (isAnimating()) {  
            timer.stop();  
            frameIndex = 0;  
            timer = null;  
        }  
    }  
  
    // ����ʱ�Ӵ����¼�  
    public void actionPerformed(ActionEvent e) {  
        // ǰ��һ֡  
        frameIndex++;  
        if (frameIndex >= ANIMATION_FRAMES)  
            // ���һ֡���رն���  
            closeTimer();  
        else  
            // ���µ�ǰһ֡  
            repaint();  
    }  
    
    public static void main(String []args) throws IOException{
    	ZPanel pa=new ZPanel();
    	JFrame fr=new JFrame();
    	JButton bu=new JButton("����ͼƬ");
    	fr.add(BorderLayout.SOUTH,bu);
    	bu.addActionListener(pa);
    	
    	fr.add(pa);
    	pa.setImage(ImageIO.read(new File("src/StartWindow.jpg")));
    	SwingConsole.run(fr,1000,600);
    }
} 
