package yyf.coursehomework;

/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 *  课程类，包含了课程名、上课时间（包括字符串版和数字版）、上课地点 实现Comparable接口，使得Course按照时间排序
 *  重写equals方法，用于ArrayList的contains方法使用
 * （应重写hashCode,但这个系统未使用到此方法，需要时可添加)
 */

public class Course implements Comparable<Course> {
	private String name;
	// 数字和字符串（汉字）的星期数
	private int dayOfWeek_int;
	private String dayOfWeek;
	// 数字和字符串（汉字）的节数
	private int timeInDay_int;
	private String timeInDay;
	// 上课地点
	private String place;
	// 用于存储于文件的信息
	private String information;

	public Course(String information) {
		// 用英文的分号替换information中中文的分号，方便之后的字符串split
		information = information.replaceAll("；", ";");
		this.information = information;

		String[] result = information.split(";");
		dayOfWeek = result[0];
		timeInDay = result[1];
		name = result[2];
		place = result[3];
		dayOfWeek_int = transDayOfWeek(dayOfWeek);
		timeInDay_int = transTimeInDay(timeInDay);
	}

	// 将字符串型的星期几转换为数字
	private int transDayOfWeek(String day) {
		switch (day.charAt(2)) {
		case '一':
			return 1;
		case '二':
			return 2;
		case '三':
			return 3;
		case '四':
			return 4;
		case '五':
			return 5;
		case '六':
			return 6;
		case '七':
			return 7;
		default:
			return -1;
		}
	}

	// 将字符串型的上课节数转换为数字（仅第一节）
	private int transTimeInDay(String time) {
		switch (time.charAt(0)) {
		case '一':
			return 1;
		case '二':
			return 2;
		case '三':
			return 3;
		case '四':
			return 4;
		case '五':
			return 5;
		case '六':
			return 6;
		case '七':
		case '日':
			return 7;
		default:
			return -1;
		}
	}

	// getter and setter

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDayOfWeek_int() {
		return dayOfWeek_int;
	}

	public void setDayOfWeek_int(int dayOfWeek_int) {
		this.dayOfWeek_int = dayOfWeek_int;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getTimeInDay_int() {
		return timeInDay_int;
	}

	public void setTimeInDay_int(int timeInDay_int) {
		this.timeInDay_int = timeInDay_int;
	}

	public String getTimeInDay() {
		return timeInDay;
	}

	public void setTimeInDay(String timeInDay) {
		this.timeInDay = timeInDay;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public int compareTo(Course o) {
		// TODO 自动生成的方法存根
		if (getDayOfWeek_int() > o.getDayOfWeek_int())
			return 1;
		else if (getDayOfWeek_int() < o.getDayOfWeek_int())
			return -1;
		else if (getTimeInDay_int() > o.getTimeInDay_int())
			return 1;
		else if (getTimeInDay_int() < o.getTimeInDay_int())
			return -1;
		else
			return 0;
	}

	// 重写equals方法判断两门课是否相同
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course o = (Course) obj;
			if (getInformation().equals(o.getInformation()))
				return true;
			else
				return false;
		} else
			return false;

	}

}
