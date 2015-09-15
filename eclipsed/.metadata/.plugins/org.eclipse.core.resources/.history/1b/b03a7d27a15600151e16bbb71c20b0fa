import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;

public class FileFinder {

	public void find(File file, int level) {
		File[] files = file.listFiles();
		if (files == null)
			return;
		for (File fil : files) {

			printFile(fil, level);
			if (fil.isDirectory())
				find(fil, level + 1);
		}
	}

	public void printFile(File file, int level) {
		for (int i = 0; i < level; i++)
			System.out.print("  ");
		System.out.print("---");
		System.out.println(file.getName());
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream pr = new PrintStream(new File("output.txt"));
		PrintStream pr1=System.out;
		System.setOut(pr);
		FileFinder file = new FileFinder();
		long a=System.currentTimeMillis();
		file.find(new File("d:/"), 0);
		long b=System.currentTimeMillis();
		System.setOut(pr1);
		System.out.println("Cost "+(b-a)/1000L+"s");
	}
}
