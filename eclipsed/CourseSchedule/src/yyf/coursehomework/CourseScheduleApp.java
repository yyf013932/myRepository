package yyf.coursehomework;

import java.util.Scanner;

/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0 
 * �γ̱�Ӧ��������
 */

public class CourseScheduleApp {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		CourseSchedule courseSch = new CourseSchedule();
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ֧�ֵĲ����У�");
		for (Handler handler : courseSch.getHandlers()) {
			System.out.print(handler.getName() + "  ");
		}
		System.out.println("End");
		System.out.println("���������ָ�����������ݣ���");
		String request = sc.nextLine();
		while (!request.equals("End")) {
			courseSch.operateRequest(request);
			request = sc.nextLine();
		}
		sc.close();
		System.out.println("�ѳɹ��˳���");

	}

}
