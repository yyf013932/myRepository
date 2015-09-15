import java.util.ArrayList;

public class SudokuNode {
	public int true_value;
	public ArrayList<Integer> possible_value = new ArrayList<>();

	/**
	 * Ĭ��Ϊ�ǳ�ʼ����
	 */
	public SudokuNode() {
		for (int i = 1; i < 10; i++)
			possible_value.add(i);
	}

	/**
	 * ����valueֵȷ���ýڵ��Ƿ�Ϊ��ʼ�������г�ʼ��
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
	 * �趨��ֵ����պ�ѡֵ
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
	 * �����ض����趨��ֵ
	 * @param k
	 */
	public void setTrueValue(int k) {
		possible_value.clear();
		true_value = k;
	}

	/**
	 * ɾ����ѡֵ
	 * @param value
	 */
	public void deleValue(int value) {
		possible_value.remove((Object) value);
	}

	/**
	 * ����ֵ
	 * @param k
	 */
	public void guess(int k) {
		true_value = possible_value.get(k);
		possible_value.clear();

	}

	/**
	 * ���һ������
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
