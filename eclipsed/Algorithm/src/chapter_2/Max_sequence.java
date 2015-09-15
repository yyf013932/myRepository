package chapter_2;

import java.util.Random;

import tools.Method_test;
import tools.Tools;

public class Max_sequence {

	public int max(int[] a) {
		int result = 0, tem = 0;
		for (int i = 0; i < a.length; i++) {
			tem += a[i];
			if (tem < 0)
				tem = 0;
			if (result < tem)
				result = tem;
		}
		return result;
	}

	public int max_2(int[] a) {
		if (a.length == 1)
			return a[0];
		int left = a.length / 2, right = a.length - left;
		int[] a_left = new int[left], a_right = new int[right];
		System.arraycopy(a, 0, a_left, 0, left);
		System.arraycopy(a, left, a_right, 0, right);
		int left_max = max_2(a_left);
		int right_max = max_2(a_right);
		int result = 0, tem = 0;
		int left_tem_max = 0, right_tem_max = 0;
		for (int i = left - 1; i >= 0; i--) {
			tem += a_left[i];
			if (left_tem_max < tem)
				left_tem_max = tem;
		}
		tem = 0;
		for (int i = 0; i < right; i++) {
			tem += a_right[i];
			if (right_tem_max < tem)
				right_tem_max = tem;
		}
		result = left_max;
		if (result < right_max)
			result = right_max;
		if (result < (left_tem_max + right_tem_max))
			result = left_tem_max + right_tem_max;
		return result;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int n = 10000000;
		int[] a = Tools.createArray(n);
		System.out.println(Method_test.testMethod("chapter_2.Max_sequence", "max", n, a));
		System.out.println(Method_test.testMethod("chapter_2.Max_sequence", "max_2", n, a));

	}

}
