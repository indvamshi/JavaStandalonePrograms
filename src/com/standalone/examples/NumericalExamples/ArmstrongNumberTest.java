package com.test.oops.examples;

import com.test.oops.test.DefaultTest1;

public class ArmstrongNumberTest extends DefaultTest1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isArmStrong(153));
	}
	
	private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while(number != 0){
            int remainder = number%10;
            result = result + remainder*remainder*remainder;
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
      
        return false;
    }
	

}
