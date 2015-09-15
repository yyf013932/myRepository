package yyf.coursehomework;

/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 *  �γ��࣬�����˿γ������Ͽ�ʱ�䣨�����ַ���������ְ棩���Ͽεص� ʵ��Comparable�ӿڣ�ʹ��Course����ʱ������
 *  ��дequals����������ArrayList��contains����ʹ��
 * ��Ӧ��дhashCode,�����ϵͳδʹ�õ��˷�������Ҫʱ�����)
 */

public class Course implements Comparable<Course> {
	private String name;
	// ���ֺ��ַ��������֣���������
	private int dayOfWeek_int;
	private String dayOfWeek;
	// ���ֺ��ַ��������֣��Ľ���
	private int timeInDay_int;
	private String timeInDay;
	// �Ͽεص�
	private String place;
	// ���ڴ洢���ļ�����Ϣ
	private String information;

	public Course(String information) {
		// ��Ӣ�ĵķֺ��滻information�����ĵķֺţ�����֮����ַ���split
		information = information.replaceAll("��", ";");
		this.information = information;

		String[] result = information.split(";");
		dayOfWeek = result[0];
		timeInDay = result[1];
		name = result[2];
		place = result[3];
		dayOfWeek_int = transDayOfWeek(dayOfWeek);
		timeInDay_int = transTimeInDay(timeInDay);
	}

	// ���ַ����͵����ڼ�ת��Ϊ����
	private int transDayOfWeek(String day) {
		switch (day.charAt(2)) {
		case 'һ':
			return 1;
		case '��':
			return 2;
		case '��':
			return 3;
		case '��':
			return 4;
		case '��':
			return 5;
		case '��':
			return 6;
		case '��':
			return 7;
		default:
			return -1;
		}
	}

	// ���ַ����͵��Ͽν���ת��Ϊ���֣�����һ�ڣ�
	private int transTimeInDay(String time) {
		switch (time.charAt(0)) {
		case 'һ':
			return 1;
		case '��':
			return 2;
		case '��':
			return 3;
		case '��':
			return 4;
		case '��':
			return 5;
		case '��':
			return 6;
		case '��':
		case '��':
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
		// TODO �Զ����ɵķ������
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

	// ��дequals�����ж����ſ��Ƿ���ͬ
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
