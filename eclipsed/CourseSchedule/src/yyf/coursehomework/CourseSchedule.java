package yyf.coursehomework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * �γ̱��࣬��ſγ̣����ļ��洢�Ͷ�ȡ���ݣ������һϵ�����������ṩ����Ĳ鹦�ܡ� 
 * ʹ��������ģʽʹ�ô����빦���������㹦�ܵ�������ɾ��
 */
public class CourseSchedule extends ArrayList<Course> {
	// ���ڱ��������list
	private ArrayList<Handler> handlers;
	private final String filePath = "CurriculumSchedule.txt";

	public CourseSchedule() {
		// TODO �Զ����ɵĹ��캯�����
		//������
		readCourse();
		handlers = new ArrayList<Handler>();
		// ��Ӿ��幦��
		handlers.add(new CourseAdd(this));
		handlers.add(new CourseRemove(this));
		handlers.add(new CourseUpdate(this));
		handlers.add(new CourseFind(this));
		handlers.add(new CourseShow(this));
		// ��˳���趨�����ߵ�˳��
		for (int i = 0; i < handlers.size() - 1; i++)
			handlers.get(i).setNextHandler(handlers.get(i + 1));
	}

	public void operateRequest(String request) {
		handlers.get(0).handleRequest(request);
	}

	public ArrayList<Handler> getHandlers() {
		return handlers;
	}

	// ����γ�����
	public boolean saveCourse() {

		try {
			File file = new File(filePath);
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(file));
			// ����ʱ��Կγ�����
			Collections.sort(this);
			for (Course cou : this)
				writer.write(cou.getInformation() + "\n");
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("������Ϣʧ��");
			return false;
		}

	}

	// ��ȡ�γ�����
	public boolean readCourse() {
		try {
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String str;
			while ((str = reader.readLine()) != null)
				add(new Course(str));
			reader.close();
			return true;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("��ȡ��Ϣʧ��");
			return false;
		}

	}

	public static void main(String[] args) throws IOException {
		CourseSchedule courseSchedule = new CourseSchedule();
		for (int i = 0; i < 5; i++) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			courseSchedule.operateRequest(str);
		}
	}

}
