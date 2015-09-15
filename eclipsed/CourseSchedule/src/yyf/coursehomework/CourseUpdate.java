package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * �γ̸��¹���
 */
public class CourseUpdate implements Handler {
	private Handler handler;
	private CourseSchedule courseSchedule;
	private String handlerName = "Update";

	public String getName() {
		return handlerName;
	}

	public CourseUpdate(CourseSchedule courseSchedule) {
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
		if (result[0].equals(handlerName)) {
			// �������
			boolean updated = false;
			Course cou = new Course(result[1]);
			for (int i = 0; i < courseSchedule.size(); i++) {
				if (courseSchedule.get(i).compareTo(cou) == 0) {
					courseSchedule.set(i, cou);
					updated = true;
					break;
				}
			}
			if (!updated)
				System.out.println("�γ̱����޴�ʱ��γ�!!");
			else if (courseSchedule.saveCourse())
				System.out.println("�Ѹ����ļ�");
		} else if (handler != null)
			handler.handleRequest(request);
		else
			System.out.println("No such operation!!");

	}

}
