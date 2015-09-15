package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * 课程显示功能
 */
public class CourseShow implements Handler {
	private Handler handler;
	private CourseSchedule courseSchedule;
	private String handlerName = "Show";

	public String getName() {
		return handlerName;
	}

	public CourseShow(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	@Override
	public void setNextHandler(Handler nextHandler) {
		// TODO 自动生成的方法存根
		this.handler = nextHandler;
	}

	@Override
	public void handleRequest(String request) {
		// TODO 自动生成的方法存根
		String[] result = request.split(" ");
		if (result[0].equals(handlerName)) {
			for(Course cou:courseSchedule)
				System.out.println(cou.getInformation());
		} else if (handler != null)
			handler.handleRequest(request);
		else
			System.out.println("No such operation!!");
	}

}
