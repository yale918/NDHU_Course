package train;

import java.util.Scanner;

public class OrderDB {
	public Order[] OrderO ;
	public int numberOfOrders ;
	public static int orderCertificateNumber;
	public TrainDB TDB = new TrainDB();
	public int[] targetOrderList = new int[10];
	public int targetOrderListCount;
	
	public int startPosition;
	public int endPosition;
	
	public String[] positionName = {"台北","板橋","桃園","中壢","新竹","台中","彰化","斗六","嘉義","台南","高雄","屏東","台東","花連","宜蘭"}; 
	
	OrderDB(){
		targetOrderListCount = 0;
		numberOfOrders = 0;
		OrderO = new Order[100];
		for(int i=0; i<OrderO.length; i++){
            OrderO[i] = new Order();//this will call constructor.
        }
	}
	
	public void trainList(){
		TDB.printTrainInfo();
	}
	
	public void getStartAndEndPosition(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("請選擇起點(0.台北 1.板橋 2.桃園 3.中壢 4.新竹 5.台中 6.彰化 7.斗六 8.嘉義 9.台南 10.高雄 11.屏東 12.台東 13.花連 14.宜蘭)");
		startPosition = scan.nextInt();
		System.out.println("請選擇起點(0.台北 1.板橋 2.桃園 3.中壢 4.新竹 5.台中 6.彰化 7.斗六 8.嘉義 9.台南 10.高雄 11.屏東 12.台東 13.花連 14.宜蘭)");
		endPosition = scan.nextInt();
	}
	
	public void showPrice(){
		System.out.println(positionName[startPosition]+" -> "+positionName[endPosition]);
		System.out.println("車次   發車點   終點站   票價\n");
		
		TDB.setPrice(startPosition, endPosition);   // 演算法所在
		
		for(int k=0; k<TDB.pointOfTargetTrainQueue; k++){	
			System.out.println(TDB.TrainT[TDB.targetTrainQueue[k]].TrainNO+"  "+ TDB.TrainT[TDB.targetTrainQueue[k]].PassStation.get(0) + "    " + TDB.TrainT[TDB.targetTrainQueue[k]].PassStation.get(TDB.TrainT[k].TrainFlag)+"   "+TDB.targetTrainQueuePrice[k]);
		}	
		
		if(TDB.pointOfTargetTrainQueue<=0){    
			System.out.println("[*][*] 抱歉，目前無此班次唷，返回選單 [*][*]");
			trainList();
		}
		else 
			orderTicket();
	}

	
	// [*][*][*][*][*][*]	Exception Handler	[*][*][*][*][*][*] //
	class numberOfTicketException extends Exception{
		public numberOfTicketException(int no){
			super("ERROR: "+no);
		}
		public void tryAgain(){
			System.out.println("車次輸入錯誤，請小心輸入");
		}
	}
	public void getTrainNOInput() throws trainNOException{
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("請輸入訂票車次：");
			OrderO[numberOfOrders].orderTrainNO = scan.nextInt();
			if(OrderO[numberOfOrders].orderTrainNO!=203 && OrderO[numberOfOrders].orderTrainNO!=401 && OrderO[numberOfOrders].orderTrainNO!=207 && OrderO[numberOfOrders].orderTrainNO!=211 && OrderO[numberOfOrders].orderTrainNO!=411 && OrderO[numberOfOrders].orderTrainNO!=402 && OrderO[numberOfOrders].orderTrainNO!=206 && OrderO[numberOfOrders].orderTrainNO!=408 && OrderO[numberOfOrders].orderTrainNO!=410 && OrderO[numberOfOrders].orderTrainNO!=412)
				throw new trainNOException(OrderO[numberOfOrders].orderTrainNO);
			else break;
		}
	}
	
	class trainNOException extends Exception{
		public trainNOException(int trainNO){
			super("ERROR: "+ trainNO);
		}
		
		public void tryAgain(){
			System.out.println("車票數量輸入錯誤，請小心輸入");
		}
	}

	public void getNumberOfTicketInput() throws numberOfTicketException{
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("購買張數：");
			OrderO[numberOfOrders].orderTrainNO = scan.nextInt();
			if(OrderO[numberOfOrders].orderNumberOfTicket<=0)
				throw new numberOfTicketException(OrderO[numberOfOrders].orderNumberOfTicket);
			else break;
		}
	}
	// [*][*][*][*][*][*]	Exception Handler	[*][*][*][*][*][*] //

	
	public void orderTicket(){
		Scanner scan = new Scanner(System.in);
		
		////////////	Exception try and catch
		try{
			getTrainNOInput();
		}
		catch(trainNOException e){
			System.out.println(e.getMessage());
		    e.tryAgain();
		}
		
		try{	
			getNumberOfTicketInput();	
		}
		catch(numberOfTicketException e){
			System.out.println(e.getMessage());
		    e.tryAgain();
		}
		////////////	End Of Exception try and catch
		
		/*
		while(true){
			System.out.println("請輸入訂票車次：");
			OrderO[numberOfOrders].orderTrainNO = scan.nextInt();
			if(OrderO[numberOfOrders].orderTrainNO!=203 && OrderO[numberOfOrders].orderTrainNO!=401 && OrderO[numberOfOrders].orderTrainNO!=207 && OrderO[numberOfOrders].orderTrainNO!=211 && OrderO[numberOfOrders].orderTrainNO!=411 && OrderO[numberOfOrders].orderTrainNO!=402 && OrderO[numberOfOrders].orderTrainNO!=206 && OrderO[numberOfOrders].orderTrainNO!=408 && OrderO[numberOfOrders].orderTrainNO!=410 && OrderO[numberOfOrders].orderTrainNO!=412)
				System.out.println("查無此車次唷, 請重新輸入");
			else break;
		}
		
		System.out.println("身分證字號：(純數字建議123)");
		OrderO[numberOfOrders].orderUserID = scan.nextInt();
		
		while(true){
			System.out.println("購買張數：");
			OrderO[numberOfOrders].orderNumberOfTicket = scan.nextInt();
			if(OrderO[numberOfOrders].orderNumberOfTicket<=0)
				System.out.println("車票數量輸入錯誤 , 請重新輸入");
			else break;
		}
		*/
		
		OrderO[numberOfOrders].orderNO = numberOfOrders+1;
	
		while(true){
			int randomorderCertificateNumber = (int )(Math.random() * 999 + 1000);
			System.out.println("請輸入驗證碼："+ randomorderCertificateNumber);
			orderCertificateNumber = scan.nextInt();
			if (orderCertificateNumber==randomorderCertificateNumber) {	System.out.println(" 驗證通過  / 訂票成功:");  break;	}
			else {	System.out.println("輸入錯誤 請重新輸入");	}
		}
//System.out.println("in orderTicket, numberOfOrders= "+numberOfOrders);
		System.out.println("************************************");
		System.out.println("身分證字號/訂單編號/車次/起程站/到達站/張數/票價");
		//System.out.println(TDB.TrainT[TDB.targetTrainQueue[k]].TrainNO+"  "+ TDB.TrainT[TDB.targetTrainQueue[k]].PassStation.get(1) + "    " + TDB.TrainT[TDB.targetTrainQueue[k]].PassStation.get(TDB.TrainT[k].TrainFlag)+"   "+TDB.targetTrainQueuePrice[k]);
		System.out.println(OrderO[targetOrderList[numberOfOrders]].orderUserID + "/" + OrderO[targetOrderList[numberOfOrders]].orderNO +"/" + TDB.TrainT[numberOfOrders].TrainNO +"/" + TDB.TrainT[numberOfOrders].PassStation.get(0) +"/" + TDB.TrainT[numberOfOrders].PassStation.get(TDB.TrainT[numberOfOrders].TrainFlag) +"/" +OrderO[targetOrderList[numberOfOrders]].orderNumberOfTicket + "/" +TDB.targetTrainQueuePrice[numberOfOrders]*OrderO[targetOrderList[numberOfOrders]].orderNumberOfTicket);
		System.out.println("************************************");
		numberOfOrders++;
		
		trainList();
	}
	
	public void orderQuery(){
		int userInputID, numberOfTargetOrders=0;
		System.out.println("請輸入身分證字號：(純數字建議123)");
		Scanner scan = new Scanner(System.in);
		userInputID = scan.nextInt();
		
		
		//search march order
		for(int i=0; i<numberOfOrders; i++){
			if(userInputID==OrderO[i].orderUserID){
				targetOrderList[numberOfTargetOrders] = i;
				numberOfTargetOrders++;
			}
		}
		System.out.println("*************************************");
		System.out.println("身分證字號/訂單編號/車次/起程站/到達站/張數/票價");
		
		for(int j=0; j<numberOfTargetOrders; j++){
			System.out.println(OrderO[targetOrderList[j]].orderUserID + "/" + OrderO[targetOrderList[j]].orderNO +"/" + TDB.TrainT[j].TrainNO +"/" + TDB.TrainT[j].PassStation.get(0) +"/" + TDB.TrainT[j].PassStation.get(TDB.TrainT[j].TrainFlag) +"/" +OrderO[targetOrderList[j]].orderNumberOfTicket + "/" +TDB.targetTrainQueuePrice[j]*OrderO[targetOrderList[numberOfOrders]].orderNumberOfTicket);
		}
		System.out.println("*************************************");
		
		trainList();
	}
	
	
	
	
	
	
}
