import java.util.ArrayList;

public class SudokuNode {
	public int true_value;
	public ArrayList<Integer> possible_value = new ArrayList<>();

	/**
	 * 默认为非初始化数
	 */
	public SudokuNode() {
		for (int i = 1; i < 10; i++)
			possible_value.add(i);
	}

	/**
	 * 根据value值确定该节点是否为初始化数进行初始化
	 * @param value
	 */
	public SudokuNode(int value) {
		if (value == 0)
			for (int i = 1; i < 10; i++)
				possible_value.add(i);
		else
			true_value = value;
	}

	/**
	 * 设定真值并清空候选值
	 * @return
	 */
	public boolean setTrueValue() {
		if (possible_value.size() == 1) {
			true_value = possible_value.get(0);
			possible_value.clear();
			return true;
		}
		return false;
	}

	/**
	 * 根据特定数设定真值
	 * @param k
	 */
	public void setTrueValue(int k) {
		possible_value.clear();
		true_value = k;
	}

	/**
	 * 删除候选值
	 * @param value
	 */
	public void deleValue(int value) {
		possible_value.remove((Object) value);
	}

	/**
	 * 猜真值
	 * @param k
	 */
	public void guess(int k) {
		true_value = possible_value.get(k);
		possible_value.clear();

	}

	/**
	 * 获得一个副本
	 * @return
	 */
	public SudokuNode copy() {
		SudokuNode sn = new SudokuNode();
		sn.possible_value.clear();
		sn.true_value = this.true_value;
		for (int i = 0; i < possible_value.size(); i++)
			sn.possible_value.add(possible_value.get(i));
		return sn;
	}
}
