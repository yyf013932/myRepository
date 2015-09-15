import java.util.Random;


public class ClassTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num=1000;
		int [] numbers=new int[num];
		numbers=creadArray(num);
		long a=System.currentTimeMillis();
		sort(numbers);
		long b=System.currentTimeMillis();
		System.out.println("花费了"+(b-a)+"毫秒");
	    try {
			Class cla=Class.forName("bin/ClassTest");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static int[] sort(int[] array) {
		int len = array.length, len1 = len / 2, len2 = len - len1;
		if (len == 1 || len == 0)
			return array;
		int[] tem1 = new int[len1], tem2 = new int[len2], result = new int[len];
		System.arraycopy(array, 0, tem1, 0, len1);
		System.arraycopy(array, len / 2, tem2, 0, len2);

		tem1 = sort(tem1);
		tem2 = sort(tem2);
		int index1 = 0, index2 = 0, index = 0;
		while (index < len) {
			if (index1 < len1 && index2 < len2) {
				if (tem1[index1] < tem2[index2])
					result[index] = tem1[index1++];
				else
					result[index] = tem2[index2++];
			} else if (index1 >= len1) {
				result[index] = tem2[index2++];
			} else {
				result[index] = tem1[index1++];
			}
			index++;
		}

		return result;
	}

	public static void printArray(int[] ar) {
		for (int i : ar) {
			System.out.println(i);
		}
	}

	public static int[] creadArray(int total) {
		int[] result = new int[total];
		int index = 0;
		Random ran = new Random();
		while (index < total) {
			result[index++] = ran.nextInt(total*100);
		}
		return result;
	}
}
