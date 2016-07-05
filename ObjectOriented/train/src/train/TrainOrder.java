package train;
import java.util.*;
//import java.io.*;

public class TrainOrder {

	public static void main(String[] args) {

		System.out.println("程式啟動載入所有車次資訊");

		TrainDB TDB = new TrainDB();
		OrderDB ODB = new OrderDB();

		TDB.printTrainInfo();
		
		while(true){
			int userInput;
			System.out.println("選單: 1)查詢車次   2)訂票   3)查詢訂票紀錄   0)離開   .....ex: 輸入 1");
			System.out.println("------------------------------");
			Scanner scan = new Scanner(System.in);
			userInput = scan.nextInt();
			
			
			switch (userInput){
			case 1:
				ODB.trainList();
				break;
			case 2:
				ODB.getStartAndEndPosition();
				ODB.showPrice();
				
				break;
			case 3:
				ODB.orderQuery();
				break;
			case 0:
				System.out.println("program exited, thank you and have a nice day!");
				userInput = scan.nextInt();
				break;
			}
		}
		
	}

}
