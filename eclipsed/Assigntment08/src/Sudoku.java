import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author YangYanfei
 * date:2015 7 16
 * Description:求解数独问题
 */
public class Sudoku {
	public SudokuNode[][] nodes = new SudokuNode[9][9];

	/**
	 * 读取数据
	 * @param filePath
	 */
	public void readData(String filePath) {
		try {
			Scanner ca = new Scanner(new File(filePath));
			for (int i = 0; i < 9; i++) {
				String[] str = ca.nextLine().split(" ");
				for (int j = 0; j < 9; j++)
					nodes[i][j] = new SudokuNode(new Integer(str[j]));
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * 设定每个格的候选值，并且设置唯一数
	 * @return
	 */
	public boolean setPossible_value() {
		boolean changed = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (nodes[i][j].true_value == 0) {
					for (int k = 0; k < 9; k++) {
						nodes[i][j].deleValue(nodes[i][k].true_value);
						nodes[i][j].deleValue(nodes[k][j].true_value);
					}
					for (int x = i / 3 * 3; x < i / 3 * 3 + 3; x++)
						for (int y = j / 3 * 3; y < j / 3 * 3 + 3; y++)
							nodes[i][j].deleValue(nodes[x][y].true_value);
					if (nodes[i][j].setTrueValue())
						changed = true;
				}
			}
		}
		return changed;
	}

	/**
	 * 判断隐含唯一数
	 * @return
	 */
	public boolean hide_number() {
		boolean changed = false;
		for (int i = 1; i < 10; i++) {
			int count;
			// 遍历每一行
			for (int j = 0; j < 9; j++) {
				count = 0;
				for (int k = 0; k < 9; k++)
					if (nodes[j][k].possible_value.contains(i))
						count++;
				if (count == 1)
					for (int k = 0; k < 9; k++)
						if (nodes[j][k].possible_value.contains(i)) {
							nodes[j][k].setTrueValue(i);
							changed = true;
						}
				setPossible_value();
			}
			// 遍历每一列
			for (int j = 0; j < 9; j++) {
				count = 0;
				for (int k = 0; k < 9; k++)
					if (nodes[k][j].possible_value.contains(i))
						count++;
				if (count == 1)
					for (int k = 0; k < 9; k++)
						if (nodes[k][j].possible_value.contains(i)) {
							nodes[k][j].setTrueValue(i);
							changed = true;
						}
				setPossible_value();
			}

			// 遍历每一宫
			for (int j = 0; j < 9; j++) {
				count = 0;
				for (int x = j / 3 * 3; x < j / 3 * 3 + 3; x++)
					for (int y = j % 3 * 3; y < j % 3 * 3 + 3; y++)
						if (nodes[x][y].possible_value.contains(i))
							count++;
				if (count == 1)
					for (int x = (j / 3) * 3; x < (j / 3) * 3 + 3; x++)
						for (int y = (j % 3) * 3; y < (j % 3) * 3 + 3; y++)
							if (nodes[x][y].possible_value.contains(i)) {
								nodes[x][y].setTrueValue(i);
								changed = true;
							}
				setPossible_value();
			}

		}
		return changed;

	}

	/**
	 * 主要计算方法
	 * @return
	 */
	public boolean calculate() {
		while (setPossible_value()) {
			while (hide_number())
				;
		}
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (nodes[i][j].true_value == 0
						&& nodes[i][j].possible_value.isEmpty())
					return false;
		int count = 0;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (nodes[i][j].true_value != 0)
					count++;
		if (count == 81)
			return true;
		int guessTimes = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				while (nodes[i][j].true_value == 0) {
					if (guessTimes >= nodes[i][j].possible_value.size())
						return false;
					SudokuNode[][] copy = copy();
					nodes[i][j].guess(guessTimes);
					if (calculate())
						return true;
					else {
						nodes = copy;
						guessTimes++;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 获得副本
	 * @return
	 */
	public SudokuNode[][] copy() {
		SudokuNode[][] su = new SudokuNode[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				su[i][j] = nodes[i][j].copy();
		return su;
	}

	/**
	 * 打印出数表
	 */
	public void printNodes() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				if (j % 3 != 2)
					System.out.print(nodes[i][j].true_value + "   ");
				else
					System.out.print(nodes[i][j].true_value + " | ");
			System.out.println();
			if (i % 3 == 2)
				System.out.println("—— —— —— —— —— —— —— —— —— —— —— ——");
		}
	}
}
