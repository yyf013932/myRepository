
public class DeleteCommand {

	public static void remove(Course course) {
			boolean OKToRemove = false;
	
			OKToRemove = isOKToRemove(course);
			if(OKToRemove){
				CurriculumSchedule.courseList.remove(course);
				MyFileIO.removeFromFile();
			}
			else{
				System.out.println("该课程不存在");
			}
			System.out.println("End Removing!");
		}
		
		private static boolean isOKToRemove(Course c){

			boolean flag = false;
			for(Course course:CurriculumSchedule.courseList){
				String s1 = course.toString();
				String s2 = c.toString();
		
				if(s1.equals(s2)){
					flag = true;
					break;
				}
			}
			return flag;
		}
}



