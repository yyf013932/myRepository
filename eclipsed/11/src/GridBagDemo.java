import javax.swing.*;

import yyf.gui.SwingConsole;

import java.util.*;
import java.awt.*;

public class GridBagDemo {
	JFrame f = new JFrame();
	Container con = f.getContentPane();
	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints gcons = new GridBagConstraints();
	JTextArea t1 = new JTextArea();
	JTextArea t2 = new JTextArea();
	JScrollPane sc1 = new JScrollPane(t1);
	JScrollPane sc2 = new JScrollPane(t2);

	public static void main(String args[]) {
		new GridBagDemo().run();
	}

	void run() {
		con.setLayout(grid);
		gcons.insets = new Insets(4, 4, 4, 4);
		gcons.fill = GridBagConstraints.BOTH;
		f.setLocation(600, 100);

		sc1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sc1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sc2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// 设置自动换行功能
		t1.setLineWrap(true);
		t2.setLineWrap(true);

		// 添加组件
		addComponent(sc1, 0, 0, 3, 1, 0, 0.9);
		addComponent(sc2, 0, 1, 3, 1, 0, 0.3);
		addComponent(new JLabel(), 0, 2, 1, 1, 1.0, 0);
		addComponent(new JButton("关闭"), 1, 2, 1, 1, 0.05, 0);
		addComponent(new JButton("发送"), 2, 2, 1, 1, 0.05, 0);

		SwingConsole.run(f, 600, 700);

	}

	void addComponent(Component com, int x, int y, int w, int h, double wx,
			double wy) {
		con.add(com);
		gcons.gridx = x;
		gcons.gridy = y;
		gcons.gridheight = h;
		gcons.gridwidth = w;
		gcons.weightx = wx;
		gcons.weighty = wy;
		grid.setConstraints(com, gcons);

	}
}
