package myPasswordEncryptorPackage;
import java.util.Scanner;

public class myPasswordEncryptor {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Would you like to encrypt or decrypt a password?");
		String myChoice = scn.next();
		if(myChoice.equals("encrypt")) myEncryptor();
		else myDecryptor();
	}
	
	public static void myEncryptor() {
		System.out.println("Please enter password to be encrypted: ");
		String myPass = scn.next();
		System.out.println("Please enter encryption codec: ");
		int myCodec = scn.nextInt();
		int codec1 = (int) Math.floor(myCodec/10);
		int codec2 = myCodec%10;
		
		myPass = myCodeWheel(myPass, codec1);
		myPass = myBackwards(myPass);
		myPass = myAddChars(myPass, codec2, codec1);
		System.out.println(myPass);
	}
	
	public static void myDecryptor() {
		System.out.println("Please enter password to be decrypted: ");
		String myPass = scn.next();
		System.out.println("Please enter encryption codec: ");
		int myCodec = scn.nextInt();
		int codec1 = (int) Math.floor(myCodec/10);
		int codec2 = myCodec%10;
		
		myPass = myRemoveChars(myPass, codec2);
		myPass = myBackwards(myPass);
		myPass = myCodeWheel(myPass, 26-codec1);
		System.out.println(myPass);
	}
	
	public static String myCodeWheel(String myPass, int myNum) {
		String myString = "";
		for(int i=0; i<myPass.length(); i++) {
			int myInt = myPass.charAt(i);
			myInt += myNum;
			if(myInt>122) myInt -= 26;
			myString += (char)(myInt);
		}
		return(myString);
	}
	
	public static String myBackwards(String myPass) {
		String myString = "";
		for(int i=myPass.length()-1; i>=0; i--) {
			myString += myPass.charAt(i);
		}
		return(myString);
	}
	
	public static String myAddChars(String myPass, int myInt, int myNum) {
		String myString = "";
		int myTemp = myNum + 97;
		if(myTemp>122) myTemp -= 26;
		for(int i=0; i<myPass.length(); i++) {
			myString += myPass.charAt(i);
			for(int x=0; x<myInt; x++) {
				myString += (char)(myTemp);
				myTemp += myNum;
				if(myTemp>122) myTemp -= 26;
			}
		}
		return(myString);
	}
	
	public static String myRemoveChars(String myPass, int myInt) {
		String myString = "";
		for(int i=0; i<myPass.length(); i+=myInt+1) {
			myString += myPass.charAt(i);
		}
		return(myString);
	}
	
	/*public static void myFence() {
		String myString = "";
		int num1 = 4;
		int num2 = num1 + (num1-2);
		for(int i=0; i<10; i++) {
			int x = i%6;
			if((x>=num1)&&(x<num2)) {
				myString += (x*-1)+num2;
			} else myString += x;
		}
		System.out.print(myString);
	}*/

}