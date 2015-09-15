package tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Method_test {

	public static Object testMethod(String class_name, String method_name,
			int n, Object... para) {
		try {
			Class<? extends Object> cla = Class.forName(class_name);
			Method[] meth = cla.getMethods();
			Method me = null;
			for (int i = 0; i < meth.length; i++) {
				if (meth[i].getName().contains(method_name)) {
					me = meth[i];
					break;
				}
			}
			long a = System.currentTimeMillis();
			Object obj = me.invoke(cla.newInstance(), para);
			long b = System.currentTimeMillis();
			System.out.println("N=" + n + ":" + "Method " + method_name
					+ " cost " + (b - a) + " millis");
			return obj;
		} catch (ClassNotFoundException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
}
