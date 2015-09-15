import java.util.Arrays;

public class ALU1 {

	/**
	 * 取反操作
	 * @param operand
	 * @return operand的按位取反
	 */
	public String negation(String operand) {
		char[] re = new char[operand.length()];
		for (int i = 0; i < operand.length(); i++)
			if (operand.charAt(i) == '0')
				re[i] = '1';
			else
				re[i] = '0';
		return new String(re);
	}

	/**
	 * 左移
	 * @param operand 源操作数
	 * @param n  左移的位数
	 * @return 左移后的数
	 */
	public String leftShift(String operand, int n) {
		char[] re = new char[operand.length()];
		if (n >= operand.length()) {
			Arrays.fill(re, '0');
		} else {
			System.arraycopy(operand.toCharArray(), n, re, 0, operand.length()
					- n);
			Arrays.fill(re, operand.length() - n, operand.length(), '0');
		}
		return new String(re);
	}

	// 11
	/**
	 * 全加器运算
	 * @param x  第一位
	 * @param y  第二位
	 * @param c  进上的位
	 * @return  长度为2的字符串，第一位为和，第二位为进位
	 */
	public String fullAdder(char x, char y, char c) {
		char[] re = new char[2];
		boolean x1 = (x == '1'), x2 = (y == '1'), c1 = (c == '1');
		if (x1 ^ x2 ^ c1)
			re[0] = '1';
		else
			re[0] = '0';
		if (x1 && x2 || x1 && c1 || x2 && c1)
			re[1] = '1';
		else
			re[1] = '0';
		return new String(re);
	}

	/**
	 * 8位的先行进位加法器
	 * @param operand1  操作数1
	 * @param operand2 操作数2
	 * @param c  后面进的位
	 * @return  长度为9的字符串，前8位表示和，第9位表示进位
	 */
	public String claAdder(String operand1, String operand2, char c) {
		// op1、op2、Cb、G、P分别存放操作数一布尔值、操作数二布尔值、进位布尔值、对应位与运算布尔值、对应位或运算布尔值
		boolean[] op1 = new boolean[8], op2 = new boolean[8], P = new boolean[8], Cb = new boolean[8], G = new boolean[8];
		boolean carry;
		char[] re = new char[9], C = new char[8];
		if (c == '1')
			carry = true;
		else
			carry = false;
		// 将字符的1、0转换为真假，同时计算出所有的对应位与和或的结果。
		for (int i = 0; i < 8; i++) {
			if (operand1.charAt(7 - i) == '1')
				op1[i] = true;
			else
				op1[i] = false;
			if (operand2.charAt(7 - i) == '1')
				op2[i] = true;
			else
				op2[i] = false;
			P[i] = op1[i] || op2[i];
			G[i] = op1[i] && op2[i];
		}

		// 计算进位
		for (int i = 0; i < 8; i++) {
			boolean[] tem1 = new boolean[i + 1];
			for (int j = 0; j < i + 1; j++) {
				boolean[] tem2 = new boolean[j + 2];

				for (int k = 0; k < j + 2; k++) {
					if (k < j + 1) {
						tem2[k] = P[i - k];
					} else if (j == i) {
						tem2[k] = carry;
					} else {
						tem2[k] = G[i - k];
					}
				}
				tem1[j] = tem2[0] && tem2[1];
				for (int h = 2; h < j + 2; h++) {
					tem1[j] &= tem2[h];
				}
			}
			Cb[i] = G[i] || tem1[0];
			for (int t = 1; t < i + 1; t++) {
				Cb[i] |= tem1[t];
			}

			if (Cb[i])
				C[i] = '1';
			else
				C[i] = '0';
		}

		for (int i = 0; i < 8; i++) {
			if (i == 0)
				re[7 - i] = fullAdder(operand1.charAt(7 - i),
						operand2.charAt(7 - i), c).charAt(0);
			else {
				re[7 - i] = fullAdder(operand1.charAt(7 - i),
						operand2.charAt(7 - i), C[i - 1]).charAt(0);
			}
		}

		re[8] = C[7];

		return new String(re);
	}

	/**
	 * 模拟部分先行进位加法器
	 * @param operand1  操作数1
	 * @param operand2  操作数2
	 * @param c  后面的进位
	 * @param length  存放操作数的寄存器的长度。length 不小于操作数的长度，当某个操作数的长
	度小于 length 时，需要在高位补符号位。当 length 不为 8 的整数倍，需要对高位补位并
	运算。
	 * @return  长度为 length+1 的字符串。从左向右，前 length 位计算结果，用补码表示；
	最后 1 位为是否溢出，其中溢出为 1，不溢出为 0
	 */
	public String integerAddition(String operand1, String operand2, char c,
			int length) {
		char[] temCh = new char[length - operand1.length()];
		// 操作数长度小于length时补位
		if (operand1.length() < length) {
			Arrays.fill(temCh, operand1.charAt(0));
			operand1 = new String(temCh) + operand1;
		}
		if (operand2.length() < length) {
			temCh = new char[length - operand2.length()];
			Arrays.fill(temCh, operand2.charAt(0));
			operand2 = new String(temCh) + operand2;
		}

		char[] re = new char[length + 1];
		char carry = c;
		int numByte = length / 8;
		int othe = length - 8 * numByte;
		String tem;
		for (int i = 0; i < numByte; i++) {
			tem = claAdder(
					operand1.substring(length - 8 * i - 8, length - 8 * i),
					operand2.substring(length - 8 * i - 8, length - 8 * i),
					carry);
			System.arraycopy(tem.substring(0, 8).toCharArray(), 0, re, length
					- 8 * i - 8, 8);
			carry = tem.charAt(8);
		}
		for (int i = othe - 1; i >= 0; i--) {
			tem = fullAdder(operand1.charAt(i), operand2.charAt(i), carry);
			re[i] = tem.charAt(0);
			carry = tem.charAt(1);
		}
		char c1 = operand1.charAt(0), c2 = operand2.charAt(0);
		// 判断溢出
		if ((re[0] == '1' && c1 == '0' && c2 == '0')
				|| (re[0] == '0' && c1 == '1' && c2 == '1'))
			re[length] = '1';
		else
			re[length] = '0';
		return new String(re);
	}

	// 14
	/**
	 * 模拟减法
	 * @param operand1  操作数1
	 * @param operand2  操作数2
	 * @param length  存放操作数的寄存器的长度。length 不小于操作数的长度，当某个操作数的长
	度小于 length 时，需要在高位补符号位。
	 * @return   长度为 length+1 的字符串。从左向右，前 length 位计算结果，用补码表示；
	最后 1 位为是否溢出，其中溢出为 1，不溢出为 0。
	 * 
	 */
	public String integerSubtraction(String operand1, String operand2,
			int length) {
		String re = null;
		re = integerAddition(operand1, negation(operand2), '1', length);
		return re;
	}

	/**
	 * 模拟恢复余数除法
	 * @param operand1 被除数，用补码表示
	 * @param operand2  除数，用补码表示
	 * @param length  存放操作数的寄存器的长度。length 不小于操作数的长度，当某个操作数的长
	度小于 length 时，需要在高位补符号位
	 * @return  长度为 length*2 的字符串。 从左向右， 前 length 位为商， 用补码表示； 后 length
	为余数，用补码表示。
	 */
	public String integerDivision(String operand1, String operand2, int length) {
		char[] temCh;
		// 操作数长度小于length时补位
		if (operand1.length() < length) {
			temCh = new char[length - operand1.length()];
			Arrays.fill(temCh, operand1.charAt(0));
			operand1 = new String(temCh) + operand1;
		}
		if (operand2.length() < length) {
			temCh = new char[length - operand2.length()];
			Arrays.fill(temCh, operand2.charAt(0));
			operand2 = new String(temCh) + operand2;
		}

		temCh = new char[length];
		String re, tem;
		Arrays.fill(temCh, operand1.charAt(0));
		re = new String(temCh) + operand1;
		for (int i = 0; i < length; i++) {
			re = leftShift(re, 1).substring(0, 2 * length - 1);
			// System.out.println(re);
			if (re.charAt(0) == operand2.charAt(0))
				tem = integerSubtraction(re.substring(0, length), operand2,
						length).substring(0, length);
			else
				tem = integerAddition(re.substring(0, length), operand2, '0',
						length).substring(0, length);
			/**
			 * 修改的地方
			 * 判定条件改变
			 */
			if (tem.charAt(0) == re.charAt(0)
					|| (!tem.contains("1") && !re.substring(length,
							2 * length - i - 1).contains("1"))) {
				re = tem + re.substring(length, 2 * length - 1) + "1";
				// System.out.println("enough");
			} else {
				re = re + "0";
				// System.out.println("not enough");
			}

		}
		// System.out.println(re);

		if (operand1.charAt(0) != operand2.charAt(0))
			re = re.substring(0, length)
					+ integerSubtraction("0", re.substring(length, 2 * length),
							length);

		return re.substring(length, 2 * length) + re.substring(0, length);
	}
}
