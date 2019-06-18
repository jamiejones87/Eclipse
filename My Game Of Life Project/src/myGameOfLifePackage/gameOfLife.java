package myGameOfLifePackage;

public class gameOfLife {
	
	public static int[] isAlive = {
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
		0 , 0 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 0 ,
		0 , 0 , 1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 ,
		0 , 0 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 0 ,
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
		0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0
	};
	
	public static int[] myNeighbours = new int[100];

	public static void main(String[] args) {
		printState();
		int myLoopCount = 10;
		
		// Run life cycle loop
		for(int i=0; i<myLoopCount; i++) {
			checkSurrounds();
			updateState();
			printState();
		}

	}
	
	
	// Count the number of surrounding neighbours that are currently alive 	
	public static void checkSurrounds() {
		for(int i=0; i<100; i++) {
		
		int mySum = 0;
		int myX = (int) Math.floor(i/10);
		int myY = i%10;
		
		if((myX>0)&&(myY>0))	{ if(isAlive[((myX-1)*10)+(myY-1)] == 1) mySum++; }
		if(myX>0)				{ if(isAlive[((myX-1)*10)+(myY)] == 1) mySum++; }
		if((myX>0)&&(myY<9))	{ if(isAlive[((myX-1)*10)+(myY+1)] == 1) mySum++; }
		if(myY>0)				{ if(isAlive[(myX*10)+(myY-1)] == 1) mySum++; }
		if(myY<9)				{ if(isAlive[(myX*10)+(myY+1)] == 1) mySum++; }
		if((myX<9)&&(myY>0))	{ if(isAlive[((myX+1)*10)+(myY-1)] == 1) mySum++; }
		if(myX<9)				{ if(isAlive[((myX+1)*10)+(myY)] == 1) mySum++; }
		if((myX<9)&&(myY<9))	{ if(isAlive[((myX+1)*10)+(myY+1)] == 1) mySum++; }
		
		myNeighbours[i] =  mySum;
		}
	}
	
	public static void updateState() {
		for(int i=0; i<100; i++) {
			if((isAlive[i] == 1 && myNeighbours[i] == 2)||(myNeighbours[i] == 3)) isAlive[i] = 1;
			else isAlive[i] = 0;
		}
		System.out.println();
	}
	
	public static void printState() {
		for(int x=0; x<10; x++) {
			for(int y=0; y<10; y++) {
				int mySum = (x*10)+y;
				System.out.print(isAlive[mySum] + " ");
			}
			System.out.println();
		}
	}

}
