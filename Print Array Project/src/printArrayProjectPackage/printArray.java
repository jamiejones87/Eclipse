package printArrayProjectPackage;

public class printArray {

	public static void main(String[] args) {
		int arrayLength = 10;
		int[] myArray = new int[arrayLength];
		for(int i=0; i<arrayLength; i++) myArray[i] = i;
		System.out.println(arrayPrinter(myArray));
	}
	
	public static String arrayPrinter(int[] myArray) {
		int arrayLength = myArray.length;
		String myString = "[";
		for(int i=0; i<arrayLength; i++) {
			myString += myArray[i];
			if(i != arrayLength-1) myString += ", ";
		}
		myString += "]";
		
		return(myString);
	}

}
