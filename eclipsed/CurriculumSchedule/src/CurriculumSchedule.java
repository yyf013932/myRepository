import java.util.ArrayList;


public class CurriculumSchedule {
	static ArrayList<Course> courseList = new ArrayList<Course>();
	
	MyFileIO file;

	
	public CurriculumSchedule(String fileName){

		file = new MyFileIO(fileName);
		ArrayList<String> list = file.readFromFile();
		
		for(String s:list)
			courseList.add(new Course(s));
	}
	
	public static void main(String[] args) {
		CurriculumSchedule cs = new CurriculumSchedule("CurriculumSchedule.txt");
		cs.run();
		
	}
	
	public void run(){
		MyConsole console = new MyConsole();
		
		while(true){
			
			String input = console.inputFromConsole();
			
			Command command = new Command(input);
			
			int cmd = command.getCmd();
			Course course = command.getCourse();
			System.out.println("run:"+course);
			
			process(cmd, course);
		}
	}

	private void process(int cmd, Course course) {
		if (cmd==0){
			try{
				AddCommand.add(course);
			}catch(Exception e){	
			}
		}
		if (cmd==1){
			try{
				DeleteCommand.remove(course);
			}catch(Exception e){	
			}
		}
		if (cmd==2){
			try{
				UpdateCommand.update(course);
			}catch(Exception e){	
			}
		}
		if (cmd==3){
			try{
				FindCommand.find(course);
			}catch(Exception e){	
			}
		}
		if (cmd==4){
			try{
				ShowCommand.show();
			}catch(Exception e){	
			}
		}
	
	}
}
