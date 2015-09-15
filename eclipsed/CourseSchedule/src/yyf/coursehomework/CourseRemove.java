package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * �γ�ɾ������
 */
public class CourseRemove implements Handler {
	private Handler handler;
	private CourseSchedule courseSchedule;
	private String handlerName = "Remove";

	public String getName() {
		return handlerName;
	}

	public CourseRemove(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	@Override
	public void setNextHandler(Handler nexthandler) {
		// TODO �Զ����ɵķ������
		this.handler = nexthandler;
	}

	@Override
	public void handleRequest(String request) {
		// TODO �Զ����ɵķ������
		String[] result = request.split(" ");
		if (result[0].equals(handlerName)) {
			Course cou=new Course(result[1]);
			if(!courseSchedule.contains(cou))
				System.out.println("�γ̱����޴��ſγ̣���");
			else 
				courseSchedule.remove(cou);
			if(courseSchedule.saveCourse())
				System.out.println("�Ѵ��ļ�ɾ��");

		} else if (handler != null)
			handler.handleRequest(request);
		else
			System.out.println("No such operation!!");

	}
}
