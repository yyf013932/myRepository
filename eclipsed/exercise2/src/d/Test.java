package d;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student(1, "Lucy", 17);
		Student s2 = new Student(2, "Alice", 19);
		Student s3 = new Student(3, "Bill", 20);
		Student s4 = new Student(4, "David", 18);
		Student s5 = new Student(5, "Tom", 18);
		Student s6 = new Student(6, "Peter", 21);
		Student s7 = new Student(7, "����", 16);
		Student s8 = new Student(8, "����", 17);
		Student s9 = new Student(9, "����", 11);
		Student s10 = new Student(10, "����", 22);
		Student s11 = new Student(11, "����", 18);

		ArrayList<Student> list1 = new ArrayList<Student>();
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		list1.add(s4);
		list1.add(s5);
		list1.add(s8);

		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.add(s5);
		list2.add(s6);
		list2.add(s7);
		list2.add(s8);
		list2.add(s9);
		list2.add(s10);
		list2.add(s11);

		// �ϲ���ɾ����ͬԪ��
		for (Object o : list2)
			if (!list1.contains(o))
				list1.add((Student) o);
		System.out.println("����ǰ��");
		print(list1);
		System.out.println("��Name����");
		Student.setState("Name");
		Collections.sort((List<Student>) list1);
		print(list1);
		System.out.println("��Age����");
		Student.setState("Age");
		Collections.sort((List<Student>) list1);
		print(list1);
		System.out.println("��Stu_no����");
		Student.setState("Stu_no");
		Collections.sort((List<Student>) list1);
		print(list1);
	}

	// ��ӡArrayList�ķ���
	public static void print(ArrayList list) {
		Iterator li = list.iterator();
		while (li.hasNext()) {
			Student stu = (Student) li.next();
			System.out.print(stu.getStu_no() + " " + stu.getName() + " "
					+ stu.getAge() + "   ");
		}
		System.out.println();
	}

}
