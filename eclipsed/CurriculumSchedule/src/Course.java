
public class Course {

	String day;
	String time;
	String name;
	String location;
	
	public Course(String s){
		String[] split = ((String) s).split("；");
		day = split[0];
		time = split[1];
		name = split[2];
		location = split[3];
	}
	
	//这里加了
	public String toString(){
		return day+"；"+time+"；"+name+"；"+location;
	}
	
	public boolean equals(Object o){
		Course c=(Course)o;
		return this.toString().equals(c.toString());
	}

}
