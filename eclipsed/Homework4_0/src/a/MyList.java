package a;

import java.util.ArrayList;
import java.util.Iterator;

public class MyList extends ArrayList{
	public static void main (String[] arg){
		new MyList().test();		
	}
	public void test(){
		MyList list1=new MyList();
		MyList list2=new MyList();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		print1(list1);
		list2.add("d");
		list2.add("e");
		list2.add("f");
		print2(list2);
		list1.addAll(list2);
		print3(list1);
		list1.remove(2);
		print1(list1);
		list1.removeAll(list2);
		print2(list1);
		list2.clear();
		print3(list2);
		System.out.println(list1.contains("b"));
	}
	
	//for循环遍历
	public void print1(MyList list){
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+"  ");
		System.out.println();
	}
	//加强版for循环遍历
	public void print2(MyList list){
		for(Object s:list)
			System.out.print(s.toString()+"  ");
		System.out.println();
	}
	//迭代器遍历
	public void print3(MyList list){
		Iterator li = list.iterator();
		while(li.hasNext()) {
			System.out.print(li.next().toString()+"  ");
			}
		System.out.println();
	}

}
