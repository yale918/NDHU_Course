package hmw2_bubbleSort;

import java.util.*;
import java.io.*;

public class hmw2_bubbleSort {
	  public static void main(String[] args){

			String[] name = new String[] {"날�@", "찶짨","켲짽","�焦|","ㆍㄽ"} ;
			int[] age = new int[] {56, 45, 51, 48, 35} ;
			int input=0;
			int dataLength = age.length;

			  do{ 
				System.out.print("please input selection: \n" +
					"1) Increase Order\n" +
					"2) Decrease Order\n" );
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
			  } while( input !=1 && input!= 2);

			for (int i=0; i<dataLength; i++){
				for (int j=i+1; j<dataLength; j++){
					if (age[i] > age[j]){
						int flag1 = age[i];
						age[i] = age[j];
						age[j] = flag1;
						
						String flag2 = name[i];
						name[i] = name[j];
						name[j] = flag2;
					} 
				}
			}	
			if (input ==1)	
				for (int i=0; i<dataLength; i++)
					System.out.print(name[i] +" " +age[i] +"럼, " );
				
			else 
				for (int i=dataLength-1; i>=0; i--)
					System.out.print(name[i] +" " +age[i] +"럼, " );
			
		  }
}
