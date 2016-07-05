package OO_hmw3_g.c.d;

import java.util.*;
//import java.io.*;

public class hmw3 {
	public static void main(String[] args){
		hmw3 obj = new hmw3();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to G.C.D calculator");
		System.out.println("Input first number: ");
		int dividend = scan.nextInt();
		
		System.out.println("Input second number: ");
		int divisor = scan.nextInt();
		
		if (divisor>dividend){
			int buffNumber = divisor;
			divisor = dividend;
			dividend = buffNumber;
		}
		
		System.out.println("The gcd of two numbers is:" + obj.gcdCalculator(dividend, divisor));
	}

	
	
	
	
	static int gcdCalculator(int dividend, int divisor){
		return divisor==0 ? dividend : gcdCalculator(divisor, dividend % divisor );
		
	}
	
}
