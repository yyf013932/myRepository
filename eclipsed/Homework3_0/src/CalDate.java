import java.util.Scanner;

/**计算相差天数的程序
 * 
 * @author YangYanfei
 * @version 1.0
 * @since 20150319
 *
 */
public class CalDate {
	//默认当前日期为2015年3月19日
	static int YEAR=2015,MONTH=3,DAY=25;
	public int caldate(String str){
		int days=0;
		int year=Integer.parseInt(str.substring(0, 4));
		int month=Integer.parseInt(str.substring(4, 6));
		int day=Integer.parseInt(str.substring(6, 8));		
        //相差整年的天数（包括过去日期所在年全年的天数）
        for(int i=year;i<YEAR;i++)
        	days+=DaysInYear(i);
        //加上当天为今年的第几天
        days+=dayOfYear(DAY,MONTH,YEAR);
        //减去过去的日期为该年的第几天
        days-=dayOfYear(day,month,year);
		return days;
	}
	//计算该年有多少天的方法
	 int DaysInYear(int year){
		if(year%4==0&&!(year%100==0)||year%400==0)
			return 366;
		else return 365;
	}
	 
	 //计算某天为一年中的第几天
	 int dayOfYear(int day,int month,int year){
		 int days=0;
		 for(int i=1;i<month;i++)
			 days+=DaysInMonth(i,year);
		 days+=day;
		 return days;
	 }
	 
	 //计算某年的某一月有多少天
	 int DaysInMonth(int month,int year){
		 int days=0;
		 switch(month){
		 case 1:
		 case 3:
		 case 5:
		 case 7:
		 case 8:
		 case 10:
		 case 12:
			 days=31;break;
		 case 4:
		 case 6:
		 case 9:
		 case 11:
			 days=30;break;
		 case 2:
			 if(year%4==0&&!(year%100==0)||year%400==0)
					days=29;
			 else days=28;break;
		 }
		return days;
	 }

	public static void main(String [] arg){
		CalDate date=new CalDate();		
		System.out.println("请输入一个日期（像19960301这样的形式）:");
		Scanner sc=new Scanner(System.in);
		System.out.println("今天距离输入的日期有"+date.caldate(sc.nextLine())+"天。");
		sc.close();
	}

}
