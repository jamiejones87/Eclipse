package shuffleArrayProjectPackage;
import java.util.Arrays;

public class shuffleArray {

	public static void main(String[] args) {
		int arrayLength = 10;
		int[] myArray = new int[arrayLength];
		for(int i=0; i<arrayLength; i++) myArray[i] = i;
		arrayShuffler(myArray);
		System.out.println(Arrays.toString(myArray));
	}
	
	public static int[] arrayShuffler(int[] myArray) {
		int arrayLength = myArray.length;
		
		// Repeat for arrayLength*arrayLength times
		int rand1, rand2, temp;
		for(int i=0; i<arrayLength*arrayLength; i++) {
			// Randomly select 2 instances from myArray
			rand1 = (int) Math.floor(Math.random()*arrayLength);
			rand2 = rand1;
			while(rand2 == rand1) rand2 = (int) Math.floor(Math.random()*arrayLength);
			
			// Switch the 2 instances around
			temp = myArray[rand1];
			myArray[rand1] = myArray[rand2];
			myArray[rand2] = temp;
		}
		
		return(myArray);
	}

}
