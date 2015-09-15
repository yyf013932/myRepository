import java.util.Collections;
import java.util.Comparator;

public abstract class ShowCommand implements Comparator{
	public static void show(){
		int i = 0;
		//这里必须要传另一个比较器参数
		Collections.sort(CurriculumSchedule.courseList,new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				// TODO 自动生成的方法存根
				int day1=transDay(o1.day),time1=transTime(o1.time);
				int day2=transDay(o2.day),time2=transTime(o2.time);
				//o1比o2小
				if(day1<day2||(day1==day2&&time1<time2))
					return -1;
				//o1比o2大
				if(day1>day2||(day1==day2&&time1>time2))
					return 1;
				//o1与o2相等
				if(day1==day2&&time1==time2)
					return 0;
				return 0;
			}
		});
		for(Course course:CurriculumSchedule.courseList){
			System.out.println(course.day+"；"+course.time+"；"+course.name+"；"+course.location);
		}
			
	}
	
	//将中文的星期几转换为数字
	private static int transDay(String day){
		switch (day.charAt(2)) {
		case '一':
			return 1;
		case '二':
			return 2;
		case '三':
			return 3;
		case '四':
			return 4;
		case '五':
			return 5;
		case '六':
			return 6;
		case '七':
		case '日':
			return 7;
		default:
			return -1;
	}
}

	//将中文的第几节课转换为数字
	private static int transTime(String time){
		switch (time.charAt(0)) {
		case '一':
			return 1;
		case '二':
			return 2;
		case '三':
			return 3;
		case '四':
			return 4;
		case '五':
			return 5;
		case '六':
			return 6;
		case '七':
			return 7;
		case '八':
			return 8;
		default:
			return -1;
		}
	}
}
