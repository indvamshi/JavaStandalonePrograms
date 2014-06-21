package com.test.oops.examples;

public class FibonanciNumbersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int prev, next, sum, n;
		prev=next=1;
		for(n=1;n<=10;n++)
		{
			System.out.println(prev);
			sum=prev+next;
			prev=next;
			next=sum;
		}
	}

}
