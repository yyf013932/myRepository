import java.io.*;
import java.util.*;
public class InputAndOutput {
	int cmd;
	List<Integer> saver=new ArrayList<Integer>();
public void getcmd(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Please input a number(1 or 0):\n");
    cmd=Integer.parseInt(sc.nextLine());
    while(cmd!=1&&cmd!=0){
    	System.out.println("Wrong input!!\nPlease reinput.\n");
    	cmd=Integer.parseInt(sc.nextLine());
    }
	sc.close();
}
public void readtext(String filePath){
	try{
	BufferedReader reader=new BufferedReader(new FileReader(new File(filePath)));
    String sor=reader.readLine();
    String[] str=sor.split(" ");
    for(int i=0;i<str.length;i++){
    	saver.add(Integer.parseInt(str[i]));
    }
	reader.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}	
}
public void sort(){
	int i,j;
	if(cmd==0){
		for(i=0;i<saver.size()-1;i++)
			for(j=0;j<saver.size()-i-1;j++)
				if(saver.get(j)>saver.get(j+1)){
					int tem=saver.get(j+1);
					saver.set(j+1,saver.get(j));
					saver.set(j,tem);
			}
	}                       //…˝–Ú≈≈¡–
	else
		for(i=0;i<saver.size()-1;i++)
			for(j=0;j<saver.size()-i-1;j++)
				if(saver.get(j)<saver.get(j+1)){
					int tem=saver.get(j+1);
					saver.set(j+1,saver.get(j));
					saver.set(j,tem);
			}				//Ωµ–Ú≈≈¡–	
}
public void writetext(String filePath){
	try{
		FileWriter writer=new FileWriter(filePath);
		for(int i=0;i<saver.size();i++){
			writer.write(saver.get(i).toString()+"\n");
		}
		writer.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
public void read(){
	for(int i=0;i<saver.size();i++)
		System.out.print(saver.get(i)+"  ");
	System.out.println();
}
public static void main(String[] arg){
	InputAndOutput IAP=new InputAndOutput();
	IAP.readtext("D:\\input.txt");
	System.out.println("Original array:\n");
	IAP.read();
	IAP.getcmd();
	IAP.sort();
	System.out.println("Array after sorting:\n");
	IAP.read();
	IAP.writetext("D:\\output.txt");
}
}
