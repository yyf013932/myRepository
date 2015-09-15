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
 * 课程表类，存放课程，从文件存储和读取数据，并添加一系列责任链，提供增添改查功能。 
 * 使用责任链模式使得此类与功能类解耦，方便功能的增加与删除
 */
public class CourseSchedule extends ArrayList<Course> {
	// 用于保存操作的list
	private ArrayList<Handler> handlers;
	private final String filePath = "CurriculumSchedule.txt";

	public CourseSchedule() {
		// TODO 自动生成的构造函数存根
		//读数据
		readCourse();
		handlers = new ArrayList<Handler>();
		// 添加具体功能
		handlers.add(new CourseAdd(this));
		handlers.add(new CourseRemove(this));
		handlers.add(new CourseUpdate(this));
		handlers.add(new CourseFind(this));
		handlers.add(new CourseShow(this));
		// 按顺序设定操作者的顺序
		for (int i = 0; i < handlers.size() - 1; i++)
			handlers.get(i).setNextHandler(handlers.get(i + 1));
	}

	public void operateRequest(String request) {
		handlers.get(0).handleRequest(request);
	}

	public ArrayList<Handler> getHandlers() {
		return handlers;
	}

	// 保存课程数据
	public boolean saveCourse() {

		try {
			File file = new File(filePath);
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(file));
			// 按照时间对课程排序
			Collections.sort(this);
			for (Course cou : this)
				writer.write(cou.getInformation() + "\n");
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("保存信息失败");
			return false;
		}

	}

	// 读取课程数据
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
			System.out.println("读取信息失败");
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
