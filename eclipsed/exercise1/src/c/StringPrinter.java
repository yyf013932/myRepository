package c;

import java.util.Collections;

public class StringPrinter implements Printer {

	@Override
	public void print1(String s) {
		for(int i=s.length()-1;i>=0;i--) 
			System.out.print(s.charAt(i));
		System.out.println();
	}

	@Override
	public void print2(String s) {
		int last,first;
//偶数的打印方法		
		if(s.length()%2==0){
			last=s.length()/2;
		    first=last-1;		
		}
//奇数的打印方法
		else{
			last=s.length()/2;
			first=last;
			
		}
		for(;first>=0;){
			for(int i=0;i<s.length();i++)
				if(i<first||i>last)
					System.out.print(" ");
				else
					System.out.print(s.charAt(i));
			System.out.println();
			first-=1;
			last+=1;
			}
		}
	

	@Override
	public void print3(String s) {
		char sma,big,pre=s.charAt(0);
		sma=s.charAt(0);
		big=sma;
		if(big<='Z')
			big+=32;
		if(sma<='Z')
			sma+=32;
		for(int i=1;i<s.length();i++){
			pre=s.charAt(i);
			if(pre<='Z')			
				pre+=32;                  //统一转换为小写字母比较大小
			if(pre<sma)
				sma=pre;
			if(pre>big)
				big=pre;
		}
		System.out.println(sma+"  "+big);
	}
	
	@Override
	public void print4(String s) {
		String[]str=s.split(" ");
		System.out.println(str[2]+","+str[0]+" "+str[1].charAt(0)+".");

	}
	
	public static void main(String[] args) {
		StringPrinter sp = new StringPrinter();
		sp.print1("123456 sd");
		sp.print2("1234567");
		sp.print2("123456");
		sp.print3("vxKjhAeSXdfa");
		sp.print4("William Jefferson Clinton");
	}
	
}
