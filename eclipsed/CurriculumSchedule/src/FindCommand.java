
public class FindCommand {
	
	public static void find(Course course) {
		boolean OKToFind = true;
		
		OKToFind = ifOKToFind(course);
		if(!OKToFind){
			System.out.println("δ�ҵ���ؿγ�");
		}
	}
	
	private static boolean ifOKToFind(Course c){

		//�������
		boolean flag = false;
		for(Course course:CurriculumSchedule.courseList){
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
	
			if(s1.equals(s2)&&course.time.equals(c.time)){
				//�������
				flag = true;
				//�������
				System.out.println(course.name+"��"+course.location);
				break;
			}
		}
		return flag;
	}

}
