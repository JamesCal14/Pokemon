import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class TestExample 
{
	public static void main(String[] args)
	{
		Example test = new Example();
		
		ArrayList<Integer> mySampleNumbers = new ArrayList<Integer>();
		ArrayList<Integer> mySampleNumbers2 = new ArrayList<Integer>();
		
		mySampleNumbers.add(100);
		mySampleNumbers.add(57);
		mySampleNumbers.add(42);
		mySampleNumbers.add(2);
		mySampleNumbers.add(1);
		mySampleNumbers.add(24);
		mySampleNumbers.add(55);
		mySampleNumbers.add(39);
		mySampleNumbers.add(1);
		mySampleNumbers.add(99);
		mySampleNumbers.add(34);
		mySampleNumbers.add(2);
		
		mySampleNumbers2.add(100);
		mySampleNumbers2.add(75);
		mySampleNumbers2.add(89);
		mySampleNumbers2.add(4);
		mySampleNumbers2.add(7);
		mySampleNumbers2.add(24);
		mySampleNumbers2.add(77);
		mySampleNumbers2.add(0);
		mySampleNumbers2.add(11);
		mySampleNumbers2.add(39);
		mySampleNumbers2.add(63);
		mySampleNumbers2.add(2);
		
		// Central Tendencies
		double mean = test.findMean(mySampleNumbers);
		double median = test.findMedian(mySampleNumbers);
		Integer mode = test.findMode(mySampleNumbers);
		double stanDev = test.standardDeviation(mySampleNumbers);
		
		// Set Operations
		ArrayList<Integer> union = test.union(mySampleNumbers, mySampleNumbers2);
		ArrayList<Integer> intersect = test.intersect(mySampleNumbers, mySampleNumbers2);
		ArrayList<Integer> complement = test.complement(mySampleNumbers, mySampleNumbers2);
		
		// Factorial
		BigInteger factorial = test.factorial(10);
		double factorial2 = test.factorial2(10);
		long factorial3 = test.factorial3(10);
		
		// Permutation and Combination
		double permutation = test.permutation(52, 5);
		double combination = test.combination(52, 5);
		
		// Conditional Probability
		double conProbIn = test.conditionProbIndependent(.6, .4);
		double conProbDe = test.conditionProbDependent(.3, .5, .1);
		
		// Intersection
		double intersectIn = test.intersectionIndependent(.6, .4);
		double intersectDe = test.intersectionDependent(.5, conProbDe);
		
		// Union
		double unionEx = test.unionExclusive(.6, .4);
		double unionNonex = test.unionNonexclusive(.5, .3, .1);
		
		// Dependency
		boolean dependency = test.dependency(.6, .4, .24);
		boolean dependency2 = test.dependency(.5, .3, .1);
		
		// Binomial Distribution
		double binoDis = test.binomialDistribution(10, .80, .2, 7);
		double binoDisEx = test.getExpectedBD(10, .80);
		double binoDisV = test.getVarianceBD(10, .80, .2);
		double binoDisSD = test.getStanDevBD(10, .80, .2);
		
		// Geometric Distribution
		double geoDis = test.geometricDistribution(.90, .1, 3);
		double geoDisEx = test.getExpectedGD(.90);
		double geoDisV = test.getVarianceGD(.90);
		double geoDisSD = test.getStanDevGD(.9);
		
		// Negative Binomial Distribution
		double negDis = test.negBinoDistribution(3, .90, .1, 5);
		double negDisEx = test.getExpectedNBD(3, .90);
		double negDisV = test.getVarianceNBD(3, .90);
		double negDisSD = test.getStanDevNBD(3, .9);
		
		// Hypergeometric Distribution
		double hypDis = test.hyperGeoDistribution(8, 3, 5, 2);
		double hypDisEx = test.getExpectedHGD(8, 3, 5);
		double hypDisV = test.getVarianceHGD(8, 3, 5);
		double hypDisSD = test.getStanDevHGD(8, 3, 5);
		
		
		System.out.println("Central Tendancies of Premade Set\nMean: "+mean+"\nMedian: "+median+"\nMode: "+mode+"\nStandard Deviation: "+stanDev);
		System.out.println("\nFactorial of 10\nBigInteger: "+factorial+"\nDouble: "+factorial2+"\nLong: "+factorial3);
		System.out.println("\nSet Operations of Premade Sets\nUnion: "+union+"\nIntersection: "+intersect+"\nComplement: "+complement);
		System.out.println("\nSubset of 5 in Set of 52\nPermutation: "+permutation+"\nCombination: "+combination);
		System.out.println("\nTwo Independent Events A = 60% B = 40%\nP(A|B): "+conProbIn+"\nP(A Intersect B): "+intersectIn+"\nP(A Union B): "+unionEx+"\nIndependent: "+dependency);
		System.out.println("\nTwo Dependent Events A = 50% B = 30% A Intersect B = 10%\nP(B|A): "+conProbDe+"\nP(A Intersect B): "+intersectDe+"\nP(A Union B): "+unionNonex+"\nIndependent: "+dependency2);
		System.out.println("\nBinomial - Trials: 10 Success Rate: 80% Fail Rate: 20% Success Number: 7\nDistribution: "+binoDis+"\nExpected: "+binoDisEx+"\nVariance: "+binoDisV+"\nStandard Deviation: "+binoDisSD);
		System.out.println("\nGeometric - Success Rate: 90% Fail Rate: 10% Success Trial Number: 3\nDistribution: "+geoDis+"\nExpected: "+geoDisEx+"\nVariance: "+geoDisV+"\nStandard Deviation: "+geoDisSD);
		System.out.println("\nNegative Binomial - Trials: 5 Success Rate: 90% Fail Rate: 10% Success Trial Number: 3\nDistribution: "+negDis+"\nExpected: "+negDisEx+"\nVariance: "+negDisV+"\nStandard Deviation: "+negDisSD);
		System.out.println("\nHypergeometric - N = 8 n = 3 r = 5 y = 2\nDistribution: "+hypDis+"\nExpected: "+hypDisEx+"\nVariance: "+hypDisV+"\nStandard Deviation: "+hypDisSD);
	}
}
