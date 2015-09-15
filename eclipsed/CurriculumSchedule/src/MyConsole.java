import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConsole {

	public String inputFromConsole() {
		String input=null;
		BufferedReader br1;
		
		System.out.println("«Î ‰»Î÷∏¡Ó£∫");
		try {
			br1 = new BufferedReader(new InputStreamReader(System.in,"gbk"));
			input = br1.readLine();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return input;
	}
	

}
