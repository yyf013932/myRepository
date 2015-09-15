package StoreHouse;

import java.io.*;
import java.util.*;

public class StoreHouse {
	ArrayList<Item> list = new ArrayList();

	// �ļ��洢·��
	final String FILEPATH = "src/storehouse.txt";

	File file = new File(FILEPATH);

	// ���ɶ���ʱ�������ļ�
	public StoreHouse() {
		Read();
	}

	// ��д�ķ���
	public void Save() {
		try {
			file.delete();
			FileWriter writer = new FileWriter(file);
			for (Item i : list)
				writer.write(i.getNumber() + ";" + i.getCategory() + ";"
						+ i.getName() + ";" + i.getModel() + ";" + i.getStock()
						+ "\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Read() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while (reader.ready()) {
				String[] str = reader.readLine().split(";");
				list.add(new Item(Integer.parseInt(str[0]), str[1], str[2],
						str[3], Integer.parseInt(str[4])));
			}
			reader.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public void Add(Item item) {
		int sta = 0;
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getNumber() == item.getNumber()) {
				sta = 1;
				break;
			}
		if (sta == 1)
			// ����Ѿ����ڣ���ӡ֪ͨ
			System.out.println("�ֿ������и���Ʒ������Update����");
		else {
			// ���û�У�ֱ�Ӽ���
			list.add(item);
			System.out.println("�����ӵ��ֿ���");
		}
	}

	public void Remove(int Number) {
		int i, sta = 0;
		for (i = 0; i < list.size(); i++)
			if (list.get(i).getNumber() == Number) {
				sta = 1;
				break;
			}
		if (sta == 0)
			System.out.println("�ֿ���û�д˱����Ʒ");
		else {
			list.remove(i);
			System.out.println("ɾ���ɹ�");
		}
	}

	public void Update(Item item) {
		int i, sta = 0;
		for (i = 0; i < list.size(); i++)
			if (list.get(i).getNumber() == item.getNumber()) {
				sta = 1;
				break;
			}
		if (sta == 0)
			System.out.println("�ֿ���û�д˱����Ʒ");
		else {
			list.get(i).setStock(item.getStock());
			System.out.println("�Ѹ��²ֿ�");
		}

	}

	public void Find(int Number) {
		int i, sta = 0;
		for (i = 0; i < list.size(); i++)
			if (list.get(i).getNumber() == Number) {
				sta = 1;
				break;
			}
		if (sta == 0)
			System.out.println("�ֿ���û�д˱����Ʒ");
		else
			System.out.println(list.get(i).getNumber() + ";"
					+ list.get(i).getCategory() + ";" + list.get(i).getName()
					+ ";" + list.get(i).getModel() + ";"
					+ list.get(i).getStock());
	}

	public void show() {
		Collections.sort(list, new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				if (i1.getNumber() > i2.getNumber())
					return 1;
				else
					return -1;
			}
		});
		for (Item i : list)
			System.out.println(i.getNumber() + ";" + i.getCategory() + ";"
					+ i.getName() + ";" + i.getModel() + ";" + i.getStock());
	}

	public void print() {
		System.out.println("���سɹ�������в���.");
		System.out.println("1>>����(Add)");
		System.out.println("2>>ɾ��(Remove)");
		System.out.println("3>>����(Update)");
		System.out.println("4>>����(Find)");
		System.out.println("5>>��ʾ(Show)");
		System.out.println("6>>�뿪������(Quit and Save)");
	}

	public void start() {
		print();
		String[] str1;
		int sta = 1;
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		while (sta == 1) {
			switch (ch) {
			case '1': {
				System.out.println("��������Ʒ��Ϣ���÷ֺŸ���");
				str1 = sc.nextLine().split(";");
				Add(new Item(Integer.parseInt(str1[0]), str1[1], str1[2],
						str1[3], Integer.parseInt(str1[4])));
				break;
			}
			case '2': {
				System.out.println("��������Ʒ���");
				Remove(Integer.parseInt(sc.nextLine()));
				break;
			}
			case '3': {
				System.out.println("��������º����Ʒ��Ϣ���÷ֺŸ���");
				str1 = sc.nextLine().split(";");
				Update(new Item(Integer.parseInt(str1[0]), str1[1], str1[2],
						str1[3], Integer.parseInt(str1[4])));
				break;

			}
			case '4': {
				System.out.println("��������Ʒ���");
				Find(Integer.parseInt(sc.nextLine()));
				break;
			}
			case '5': {
				show();
				break;
			}
			case '6': {
				Save();
				System.out.println("�˳��ɹ�.");
				sta = 0;
				break;
			}
			}
			if (sta == 1) {
				System.out.println("�����������");
				ch = sc.nextLine().charAt(0);
			}
		}
		sc.close();
	}

	public static void main(String[] arg) {
		StoreHouse storehouse = new StoreHouse();
		storehouse.start();

	}
}