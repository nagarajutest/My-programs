package test;

import java.util.Scanner;

public class Primeno 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter one Value");
		int x=sc.nextInt();
		int flag=0;
		for(int i=2;i<x-1;i++)
		{
			if(x%i==0)
			{
				flag=1;
			}
		}
		if(flag==0)
		{
			System.out.println("Given No "+x+" Is PrimeNumber ");
		}
		else
		{
			System.out.println("Given No "+x+" Is Not prime");
		}
	}

}
