import java.awt.FlowLayout;

import javax.swing.*;

import yyf.gui.SwingConsole;

public class Faces extends JFrame {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Test();

	}
}

class Test {
	public static int i = 1;

	public Test() {
		System.out.println(i++);
	}
}
