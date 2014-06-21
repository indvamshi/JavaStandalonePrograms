package com.test.oops.examples;

public class PrimeNumberExample {

	private static boolean isPrimeNumber(int number) {
		
		for(int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void findPrime(int end) {
		for (int number = 2; number <= end; number++) {
			if(isPrimeNumber(number))
				System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		System.out.println(1/2);
		System.out.println(1%2);
		findPrime(4);*/
		
/*		int n, i, res;
		n = 20;
		boolean flag=true;
		for(i=2;i<=n/2;i++)
		{
			res=n%i;
			if(res==0)
			{
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println(n + " is Prime Number");
		else
			System.out.println(n + " is not Prime Number");*/
	}

}
