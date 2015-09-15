package d;

import java.util.Comparator;

//实现Comparable接口
public class Student implements Comparable {

	private int stu_no;
	private String name;
	private int age;

	public int getStu_no() {
		return stu_no;
	}

	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getState() {
		return state;
	}

	public static void setState(String state) {
		Student.state = state;
	}

	private static String state = "Name"; // 用于判定比较器当前比较的参数,默认为按Name排序

	public Student(int sn, String n, int a) {
		this.stu_no = sn;
		this.name = n;
		this.age = a;
	}

	public int compareTo(Object o) {
		Student stu = (Student) o;
		if (state.equals("Name")) {
			if (this.getName().compareTo(stu.getName()) > 0)
				return 1;
			else if (this.getName().compareTo(stu.getName()) < 0)
				return -1;
			else
				return 0;
		} else if (state.equals("Age")) {
			if (this.getAge() > stu.getAge())
				return 1;
			else if (this.getAge() < stu.getAge())
				return -1;
			else
				return 0;
		} else {
			if (this.getStu_no() > stu.getStu_no())
				return 1;
			else if (this.getStu_no() < stu.getStu_no())
				return -1;
			else
				return 0;
		}

	}
}
