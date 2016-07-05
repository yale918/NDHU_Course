package train;

import java.util.Scanner;

public class TrainDB {
	public Train[] TrainT = new Train[10];

	public String[] positionName = {"台北","板橋","桃園","中壢","新竹","台中","彰化","斗六","嘉義","台南","高雄","屏東","台東","花蓮","宜蘭"}; 
	                                /*0    1     2     3    4     5    6     7     8    9     10   11    12    13   14*/
	public int[] targetTrainQueue = new int[15];
	public int[] targetTrainQueuePrice = new int[15];
	public int[] startPoint = new int[15];
	public int[] endPoint = new int[15];
	public int pointOfTargetTrainQueue;
	
	public int MaxOfArray;

	
	TrainDB(){
		for(int i=0; i<TrainT.length; i++){
            TrainT[i] = new Train();//this will call constructor.
        }
		
		pointOfTargetTrainQueue = 0 ;
		MaxOfArray=9;

		TrainT[0].TrainNO = 203; 
		TrainT[0].PassStation[0] = "花蓮";
		TrainT[0].PassStation[1] = "宜蘭";
		TrainT[0].PassStation[2] = "台北";
		TrainT[0].TrainFlag = 2;
		
		TrainT[1].TrainNO = 401;
		TrainT[1].PassStation[0] = "台東";
		TrainT[1].PassStation[1] = "花蓮";
		TrainT[1].PassStation[2] = "宜蘭";
		TrainT[1].PassStation[3] = "台北";
		TrainT[1].TrainFlag = 3;
		
		TrainT[2].TrainNO = 207;
		TrainT[2].PassStation[0] = "花蓮";
		TrainT[2].PassStation[1] = "宜蘭";
		TrainT[2].PassStation[2] = "台北";
		TrainT[2].TrainFlag = 2;
		
		
		TrainT[3].TrainNO = 211;
		TrainT[3].PassStation[0] = "花蓮";
		TrainT[3].PassStation[1] = "宜蘭";
		TrainT[3].PassStation[2] = "台北";
		TrainT[3].PassStation[3] = "板橋";
		TrainT[3].TrainFlag = 3;
		
		TrainT[4].TrainNO = 411;
		TrainT[4].PassStation[0] = "花蓮";
		TrainT[4].PassStation[1] = "宜蘭";
		TrainT[4].PassStation[2] = "台北";
		TrainT[4].PassStation[3] = "板橋";
		TrainT[4].PassStation[4] = "桃園";
		TrainT[4].TrainFlag = 4;
		
		

		TrainT[5].TrainNO = 402;
		TrainT[5].PassStation[0] = "板橋";
		TrainT[5].PassStation[1] = "台北";
		TrainT[5].PassStation[2] = "宜蘭";
		TrainT[5].PassStation[3] = "花蓮";
		TrainT[5].PassStation[4] = "台東";
		TrainT[5].TrainFlag = 4;
		
		TrainT[6].TrainNO = 206;
		TrainT[6].PassStation[0] = "台北";
		TrainT[6].PassStation[1] = "宜蘭";
		TrainT[6].PassStation[2] = "花蓮";
		TrainT[6].TrainFlag = 2;
		
		TrainT[7].TrainNO = 408;
		TrainT[7].PassStation[0] = "台北";
		TrainT[7].PassStation[1] = "宜蘭";
		TrainT[7].PassStation[2] = "花蓮";
		TrainT[7].PassStation[3] = "台東";
		TrainT[7].TrainFlag = 3;
		
		TrainT[8].TrainNO = 410;
		TrainT[8].PassStation[0] = "台北";
		TrainT[8].PassStation[1] = "宜蘭";
		TrainT[8].PassStation[2] = "花蓮";
		TrainT[8].TrainFlag = 2;

		TrainT[9].TrainNO = 412;
		TrainT[9].PassStation[0] = "台北";
		TrainT[9].PassStation[1] = "宜蘭";
		TrainT[9].PassStation[2] = "花蓮";
		TrainT[9].PassStation[3] = "台東";
		TrainT[9].TrainFlag = 3;

	}
	
	public void printTrainInfo(){
		System.out.println("..... 火 車 時 刻 表 .....");
		for (int i=0; i<=MaxOfArray; i++){
			
			System.out.print(TrainT[i].TrainNO+" ");
			for (int j=0; j<TrainT[i].TrainFlag; j++){
				System.out.print(TrainT[i].PassStation[j]+"->");
			}
			System.out.println("||");
		}
		System.out.println("");	
	}
	
	public void setPrice(int startPosition, int endPosition){
		pointOfTargetTrainQueue=0;
		int targetCount;
		
		for (int i=0; i<=MaxOfArray; i++){
			targetCount=0;

			for (int j=0; j<=TrainT[i].TrainFlag; j++){

				if(positionName[startPosition] == TrainT[i].PassStation[j]){

					targetCount++;
					startPoint[i] = j;
				}
				if(positionName[endPosition] == TrainT[i].PassStation[j]){
					targetCount++;
					endPoint[i] = j;
				}
				if(targetCount == 2){
					int price = (endPoint[i] - startPoint[i] )*100;
					if (price >0){
						
						targetTrainQueue[pointOfTargetTrainQueue] = i;
						targetTrainQueuePrice[pointOfTargetTrainQueue] = price ;
						pointOfTargetTrainQueue++;
					}
					break;
				}
				
			}
		}
		

	}


	
}
