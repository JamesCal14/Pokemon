import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class TestExample 
{
	public static void main(String[] args)
	{
		Example test = new Example();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter set number: ");
		//int n = in.nextInt();
		System.out.println("Enter subset number: ");
		//int k = in.nextInt();
		ArrayList<Integer> mySampleNumbers = new ArrayList<Integer>();
		mySampleNumbers.add(46);
		mySampleNumbers.add(69);
		mySampleNumbers.add(32);
		mySampleNumbers.add(60);
		mySampleNumbers.add(52);
		mySampleNumbers.add(41);
		boolean storeResults = test.dependency(.4, .6, .24);
		
		
		
		System.out.println(storeResults);
	}
}
