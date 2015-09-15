package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 *课程添加功能
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
		// TODO 自动生成的方法存根
		this.handler = nextHandler;
	}

	@Override
	public void handleRequest(String request) {
		// TODO 自动生成的方法存根
		String[] result = request.split(" ");
		//判断请求是否能执行
		if (result[0].equals(handlerName)) {
			Course course=new Course(result[1]);
			if(courseSchedule.contains(course))
					System.out.println("已存在此门课程，无需添加！！");
			else{
				courseSchedule.add(course);
				if(courseSchedule.saveCourse())
					System.out.println("已添加到文件中");
			}
		} else if (handler != null)
			handler.handleRequest(request);  //把请求给下一个handler
		else
			System.out.println("No such operation!!");
	}

}
