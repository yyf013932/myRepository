import java.util.Scanner;

public class CalDate {
	// Ĭ�Ͻ�����2015��3��25��
	static final int YEARNOW = 2015, MONTHNOW = 3, DAYNOW = 25;

	// ������������ĺ���
	int calTime(int day, int month, int year) {
		int result = 0;
		// ��������������
		int k = year + 1;
		while (k < YEARNOW) {
			result += DaysOfYear(k);
			k++;
		}

		// �������ڵ�ʱ������������������
		// �������ͬ��
		if (year < YEARNOW) {
			for (int i = 1; i < MONTHNOW; i++) {
				result += DaysOfMonth(i, YEARNOW);
			}
			result += DAYNOW;
			// ���Ϲ�ȥʱ������������������
			for (int i = month; i <= 12; i++) {
				result += DaysOfMonth(i, year);
			}
			result -= day;
		}
		// �����ͬ�굫��ͬ��
		else if (MONTHNOW != month) {
			int j = month;
			while (j < MONTHNOW) 
				result += DaysOfMonth(j, YEARNOW);
				result += DAYNOW;
				result -= day;
				j++;
			
		}
		//ͬ����ͬ��
		else{
			result=result+DAYNOW-day;
		}
			

		return result;
	}

	//���ص��������
	int DaysOfYear(int year) {
		if (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0)
			return 366;
		else
			return 365;
	}

	int DaysOfMonth(int month, int year) {
		int days = 0;
		switch (month) {
		// 1��3��5��7��8��10��12�·���31��
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		// 4��6��9��11�·���30��
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		// 2�·�����ƽ�귵��
		case 2:
			if (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0)
				days = 29;
			else
				days = 28;
			break;
		}
		return days;
	}

	public static void main(String[] args) {

		System.out.println("��ǰʱ��Ϊ" + YEARNOW + "��" + MONTHNOW + "��" + DAYNOW
				+ "��");

		// ͨ�������ù�ȥ��ʱ��
		int day, month, year;
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ȥ��ʱ�䣺����ʽΪ2014 01 25��:");
		year = sc.nextInt();
		month = sc.nextInt();
		day = sc.nextInt();
		System.out.println("��ȥʱ��Ϊ" + year + "��" + month + "��" + day + "��");
		sc.close();

		CalDate cal = new CalDate();
		int days = cal.calTime(day, month, year);

		System.out.println("����ʱ�����" + days + "��.");

	}

}