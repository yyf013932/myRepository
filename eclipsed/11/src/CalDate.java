import java.util.Scanner;

public class CalDate {
	// 默认今天是2015年3月25日
	static final int YEARNOW = 2015, MONTHNOW = 3, DAYNOW = 25;

	// 计算相差天数的函数
	int calTime(int day, int month, int year) {
		int result = 0;
		// 加上相差年的天数
		int k = year + 1;
		while (k < YEARNOW) {
			result += DaysOfYear(k);
			k++;
		}

		// 加上现在的时间所在年需计算的天数
		// 如果不是同年
		if (year < YEARNOW) {
			for (int i = 1; i < MONTHNOW; i++) {
				result += DaysOfMonth(i, YEARNOW);
			}
			result += DAYNOW;
			// 加上过去时间所在年需计算的天数
			for (int i = month; i <= 12; i++) {
				result += DaysOfMonth(i, year);
			}
			result -= day;
		}
		// 如果是同年但不同月
		else if (MONTHNOW != month) {
			int j = month;
			while (j < MONTHNOW) 
				result += DaysOfMonth(j, YEARNOW);
				result += DAYNOW;
				result -= day;
				j++;
			
		}
		//同年且同月
		else{
			result=result+DAYNOW-day;
		}
			

		return result;
	}

	//返回当年的天数
	int DaysOfYear(int year) {
		if (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0)
			return 366;
		else
			return 365;
	}

	int DaysOfMonth(int month, int year) {
		int days = 0;
		switch (month) {
		// 1、3、5、7、8、10、12月返回31天
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		// 4、6、9、11月返回30天
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		// 2月分闰年平年返回
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

		System.out.println("当前时间为" + YEARNOW + "年" + MONTHNOW + "月" + DAYNOW
				+ "日");

		// 通过输入获得过去的时间
		int day, month, year;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入过去的时间：（格式为2014 01 25）:");
		year = sc.nextInt();
		month = sc.nextInt();
		day = sc.nextInt();
		System.out.println("过去时间为" + year + "年" + month + "月" + day + "日");
		sc.close();

		CalDate cal = new CalDate();
		int days = cal.calTime(day, month, year);

		System.out.println("两个时间相差" + days + "天.");

	}

}