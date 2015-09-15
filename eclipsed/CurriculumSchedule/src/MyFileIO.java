import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MyFileIO {
	
	static String fileName;
	
	public MyFileIO(String fileName){
		this.fileName = fileName;
	}

	public ArrayList<String> readFromFile() {
		ArrayList<String> list = new ArrayList<String>();
		
		try{
			File f = new File("CurriculumSchedule.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(f));
			String line;
			
			while((line=br1.readLine())!=null){
				list.add(line);
			}
			br1.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

		return list;
	}

	public static void appendToFile(String output) {
		try{
			FileWriter writer = new FileWriter(fileName,false);
			writer.write(output);
			System.out.println("已添加到文件中\n");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

	}


	public static void removeFromFile(){
		int i =0;
		try{
			FileOutputStream testfile =new FileOutputStream(fileName);
			testfile.write(new String("").getBytes());
			testfile.close();
			FileWriter writer = new FileWriter(fileName,true);
			//这里改了
			for(i=0;i<CurriculumSchedule.courseList.size();i++){
				writer.write(CurriculumSchedule.courseList.get(i).toString());
				writer.write("\n");	
			}
			
			writer.close();
			System.out.println("已从文件中删除\n");

		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}


	public static void updateFile() {
		int i =0;
		try{
			FileOutputStream testfile =new FileOutputStream(fileName);
			testfile.write(new String("").getBytes());
			testfile.close();
			FileWriter writer = new FileWriter(fileName,false);
			//这里改了
			for(i=0;i<CurriculumSchedule.courseList.size();i++){
				writer.write(CurriculumSchedule.courseList.get(i).toString());
				writer.write("\n");	
		    }
			writer.close();
			System.out.println("已更新文件\n");
	   }catch(IOException ex){
		   ex.printStackTrace();
	   }
    }
}
