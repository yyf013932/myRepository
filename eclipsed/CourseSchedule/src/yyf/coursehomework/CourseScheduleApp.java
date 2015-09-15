package yyf.coursehomework;

import java.util.Scanner;

/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0 
 * 课程表应用启动类
 */

public class CourseScheduleApp {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CourseSchedule courseSch = new CourseSchedule();
		Scanner sc = new Scanner(System.in);
		System.out.println("当前支持的操作有：");
		for (Handler handler : courseSch.getHandlers()) {
			System.out.print(handler.getName() + "  ");
		}
		System.out.println("End");
		System.out.println("请输入你的指令（操作码加数据）：");
		String request = sc.nextLine();
		while (!request.equals("End")) {
			courseSch.operateRequest(request);
			request = sc.nextLine();
		}
		sc.close();
		System.out.println("已成功退出。");

	}

}
