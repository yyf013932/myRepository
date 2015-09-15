package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 *�γ���ӹ���
 */

public class CourseAdd implements Handler {
	private Handler handler;
	private CourseSchedule courseSchedule;
	private String handlerName = "Add";

	public String getName() {
		return handlerName;
	}

	public CourseAdd(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	@Override
	public void setNextHandler(Handler nextHandler) {
		// TODO �Զ����ɵķ������
		this.handler = nextHandler;
	}

	@Override
	public void handleRequest(String request) {
		// TODO �Զ����ɵķ������
		String[] result = request.split(" ");
		//�ж������Ƿ���ִ��
		if (result[0].equals(handlerName)) {
			Course course=new Course(result[1]);
			if(courseSchedule.contains(course))
					System.out.println("�Ѵ��ڴ��ſγ̣�������ӣ���");
			else{
				courseSchedule.add(course);
				if(courseSchedule.saveCourse())
					System.out.println("����ӵ��ļ���");
			}
		} else if (handler != null)
			handler.handleRequest(request);  //���������һ��handler
		else
			System.out.println("No such operation!!");
	}

}
