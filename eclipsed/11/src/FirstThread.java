public class FirstThread
{
	public static void main(String[] args)
	{
		TestThread tt = new TestThread();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
	}
}
class TestThread implements Runnable//extends Thread
{
	int numberA = 10; 
	int numberB = 20;
	String str = new String("");
	public void run()
	{
//		while(true)
		for(int i=0;i<20;i++)
		{
			synchronized(str)
			{			
				System.out.println("ForÄÚ²¿.");
				if(numberA > 0)
				{
					System.out.println("run():"+ Thread.currentThread().getName()+"  A is running "+numberA--);
				}
			}
		if(numberB > 0)
			{
				System.out.println("run():"+ Thread.currentThread().getName()+"  B is running "+numberB--);
			}
		}
			
	}
}