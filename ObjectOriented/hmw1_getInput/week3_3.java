import java.io.*;
import java.util.*;

public class week3_3
{
  public static void main(String[] args)
  {
//    Scanner scanner = new Scanner(System.in);

//    int num = scanner.nextInt();

    for(int i=1; i<=5; i++)
    {
      for(int j=5-i; j>=1; j--)
      {
        System.out.print("  ");
      }
      for(int k=1; k<=i; k++)
      {
        System.out.print(i + " ");
      }
      System.out.print("\n");
    }

  }
}
