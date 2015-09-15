import java.util.Collections;
import java.util.Comparator;

public abstract class ShowCommand implements Comparator{
	public static void show(){
		int i = 0;
		//�������Ҫ����һ���Ƚ�������
		Collections.sort(CurriculumSchedule.courseList,new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				// TODO �Զ����ɵķ������
				int day1=transDay(o1.day),time1=transTime(o1.time);
				int day2=transDay(o2.day),time2=transTime(o2.time);
				//o1��o2С
				if(day1<day2||(day1==day2&&time1<time2))
					return -1;
				//o1��o2��
				if(day1>day2||(day1==day2&&time1>time2))
					return 1;
				//o1��o2���
				if(day1==day2&&time1==time2)
					return 0;
				return 0;
			}
		});
		for(Course course:CurriculumSchedule.courseList){
			System.out.println(course.day+"��"+course.time+"��"+course.name+"��"+course.location);
		}
			
	}
	
	//�����ĵ����ڼ�ת��Ϊ����
	private static int transDay(String day){
		switch (day.charAt(2)) {
		case 'һ':
			return 1;
		case '��':
			return 2;
		case '��':
			return 3;
		case '��':
			return 4;
		case '��':
			return 5;
		case '��':
			return 6;
		case '��':
		case '��':
			return 7;
		default:
			return -1;
	}
}

	//�����ĵĵڼ��ڿ�ת��Ϊ����
	private static int transTime(String time){
		switch (time.charAt(0)) {
		case 'һ':
			return 1;
		case '��':
			return 2;
		case '��':
			return 3;
		case '��':
			return 4;
		case '��':
			return 5;
		case '��':
			return 6;
		case '��':
			return 7;
		case '��':
			return 8;
		default:
			return -1;
		}
	}
}
