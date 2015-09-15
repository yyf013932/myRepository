
public class FindCommand {
	
	public static void find(Course course) {
		boolean OKToFind = true;
		
		OKToFind = ifOKToFind(course);
		if(!OKToFind){
			System.out.println("未找到相关课程");
		}
	}
	
	private static boolean ifOKToFind(Course c){

		//这里改了
		boolean flag = false;
		for(Course course:CurriculumSchedule.courseList){
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
	
			if(s1.equals(s2)&&course.time.equals(c.time)){
				//这里改了
				flag = true;
				//这里改了
				System.out.println(course.name+"；"+course.location);
				break;
			}
		}
		return flag;
	}

}
