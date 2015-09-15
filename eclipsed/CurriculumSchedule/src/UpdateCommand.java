
public class UpdateCommand {

	public static void update(Course course) {
		boolean OKToUpdate = true;
		OKToUpdate = ifOKToUpdate(course);
		if(OKToUpdate){
			CurriculumSchedule.courseList.add(course);
			MyFileIO.updateFile();
		}
		else{
			System.out.println("该课程不存在");
			}
	}
	
	private static boolean ifOKToUpdate(Course c){

		boolean flag = false;
		for(Course course:CurriculumSchedule.courseList){
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
	
			if(s1.equals(s2)&&course.time.equals(c.time)){
				flag = true;
				CurriculumSchedule.courseList.remove(course);
				break;
			}
		}
		return flag;
		
	}


}


