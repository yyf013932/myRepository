package tools;

import java.util.Random;

public class Tools {
	
	/**
	 * ����һ������
	 * @param n ���鳤��
	 * @return
	 */
	public static int [] createArray(int n){
		int []result=new int[n];
		Random ra=new Random();
		for(int i=0;i<n;i++)
			result[i]=ra.nextInt();
		return result;
	}
}
