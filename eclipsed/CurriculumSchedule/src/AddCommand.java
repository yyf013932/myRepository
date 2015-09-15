import java.util.ArrayList;


public class AddCommand{

	public static void add(Course course) {
		boolean OKToAdd = true;
		OKToAdd = ifOKToAdd(course);
		if(OKToAdd){
			CurriculumSchedule.courseList.add(course);
			MyFileIO.appendToFile(course.toString()+"\n");
		} else {
			System.out.println("该时间有课无法添加");
		}
		
	}

	private static boolean ifOKToAdd(Course c) {

		boolean flag = true;
		for(Course course:CurriculumSchedule.courseList){
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
	
			if(s1.equals(s2)&&course.time.equals(c.time)){
				flag = false;
				break;
			}
		}
		return flag;
	}

}
