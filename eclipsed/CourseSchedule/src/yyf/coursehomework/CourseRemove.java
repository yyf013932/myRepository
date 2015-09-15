package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * 课程删除功能
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
		// TODO 自动生成的方法存根
		this.handler = nexthandler;
	}

	@Override
	public void handleRequest(String request) {
		// TODO 自动生成的方法存根
		String[] result = request.split(" ");
		if (result[0].equals(handlerName)) {
			Course cou=new Course(result[1]);
			if(!courseSchedule.contains(cou))
				System.out.println("课程表中无此门课程！！");
			else 
				courseSchedule.remove(cou);
			if(courseSchedule.saveCourse())
				System.out.println("已从文件删除");

		} else if (handler != null)
			handler.handleRequest(request);
		else
			System.out.println("No such operation!!");

	}
}
