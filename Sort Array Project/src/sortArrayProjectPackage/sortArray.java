package sortArrayProjectPackage;

import java.util.Arrays;

public class sortArray {

	public static void main(String[] args) {
		int arrayLength = 10;
		int[] myArray = new int[arrayLength];
		int myNum = arrayLength-1;
		for(int i=0; i<arrayLength; i++) {
			myArray[i] = myNum;
			myNum--;
		}
		System.out.println(Arrays.toString(myArray));
		arraySorter(myArray);
		System.out.println(Arrays.toString(myArray));
	}
	
	public static int[] arraySorter(int[] myArray) {
		int arrayLength = myArray.length;
		int temp;
		for(int n=0; n<(arrayLength-1); n++) {
			for(int i=0; i<arrayLength-1; i++) {
				if(myArray[i]>myArray[i+1]) {
					temp = myArray[i];
					myArray[i] = myArray[i+1];
					myArray[i+1] = temp;
				}
			}
		}
		return(myArray);
	}

}
