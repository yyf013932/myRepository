import java.util.Calendar;

import java.util.Scanner;

/**计算相差天数的程序
 * 
 * @author YangYanfei
 * @version 1.0
 * @since 20150319
 *
 */
public class CalDate_Calendar {

	public int caldate(String str){
		int year=Integer.parseInt(str.substring(0, 4));
		int month=Integer.parseInt(str.substring(4, 6))-1;
		int day=Integer.parseInt(str.substring(6, 8));		
		Calendar cal=Calendar.getInstance();
		long now=cal.getTimeInMillis();
		cal.set(year, month, day);
		long before=cal.getTimeInMillis();
		return (int) ((now-before)/(24*60*60*1000));
	}
	
	public static void main(String [] arg){
		CalDate date=new CalDate();		
		System.out.println("请输入一个日期（像19960301这样的形式）:");
		Scanner sc=new Scanner(System.in);
		System.out.println("今天距离输入的日期有"+date.caldate(sc.nextLine())+"天。");
		sc.close();
	}
}
