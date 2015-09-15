import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import yyf.gui.SwingConsole;


public class HelloWorld {
	    public static void main (String[] args){
		  ArrayList<Integer> list=new ArrayList<Integer>();
		  int a=1;
		  for(int i=0;i<10;i++){
			  list.add(a);
			  a++;
			  System.out.println(Arrays.toString(list.toArray()));
		  }
		}	
}
