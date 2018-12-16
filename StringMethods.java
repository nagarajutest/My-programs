package samples;

import java.util.Scanner;

public class StringMethods 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String Value");
		String x=sc.nextLine();
		String  y[]=x.split(" ");
		System.out.println(y.length);
		System.out.println(y[2]);
	}

}
