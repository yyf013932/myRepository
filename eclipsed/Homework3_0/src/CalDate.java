import java.util.Scanner;

/**������������ĳ���
 * 
 * @author YangYanfei
 * @version 1.0
 * @since 20150319
 *
 */
public class CalDate {
	//Ĭ�ϵ�ǰ����Ϊ2015��3��19��
	static int YEAR=2015,MONTH=3,DAY=25;
	public int caldate(String str){
		int days=0;
		int year=Integer.parseInt(str.substring(0, 4));
		int month=Integer.parseInt(str.substring(4, 6));
		int day=Integer.parseInt(str.substring(6, 8));		
        //��������������������ȥ����������ȫ���������
        for(int i=year;i<YEAR;i++)
        	days+=DaysInYear(i);
        //���ϵ���Ϊ����ĵڼ���
        days+=dayOfYear(DAY,MONTH,YEAR);
        //��ȥ��ȥ������Ϊ����ĵڼ���
        days-=dayOfYear(day,month,year);
		return days;
	}
	//��������ж�����ķ���
	 int DaysInYear(int year){
		if(year%4==0&&!(year%100==0)||year%400==0)
			return 366;
		else return 365;
	}
	 
	 //����ĳ��Ϊһ���еĵڼ���
	 int dayOfYear(int day,int month,int year){
		 int days=0;
		 for(int i=1;i<month;i++)
			 days+=DaysInMonth(i,year);
		 days+=day;
		 return days;
	 }
	 
	 //����ĳ���ĳһ���ж�����
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
		System.out.println("������һ�����ڣ���19960301��������ʽ��:");
		Scanner sc=new Scanner(System.in);
		System.out.println("������������������"+date.caldate(sc.nextLine())+"�졣");
		sc.close();
	}

}
