import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import yyf.gui.SwingConsole;


public class Demo1_0 extends JFrame{

	JTabbedPane jtp=null;
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	JPanel jp5=new JPanel();
	public void run(){
		SwingConsole.run(this,700,500);
		
		jtp=new JTabbedPane(JTabbedPane.TOP);
		jtp.add("����",jp1);
		jtp.add("����",jp2);
		jtp.add("���",jp3);
		jtp.add("�ļ�",jp4);
		jtp.add("�",jp5);
		jtp.setBackground(Color.yellow);
		jtp.setForeground(Color.blue);
		
		this.add(jtp);
	}
	public static void main(String[]args){
		Demo1_0 demo=new Demo1_0();
		demo.run();
	}
}
