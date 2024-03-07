import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
public class Example 
{
	/*
	 * Central tendencies Mean, Median and Mode
	 * Accepts userInput of type ArrayList<Integer> and returns double value
	 */
	public double findMean(ArrayList<Integer> userInput)
	{
		double sum = 0;
		for (int i=0;i<userInput.size();i++)
		{
			sum = userInput.get(i) + sum;
		}
		double result = sum / userInput.size();
		
		return result;
		
	}
	
	/*
	 * Median method
	 * Calls Collections.sort to organize the list of userInput
	 */
	public double findMedian(ArrayList<Integer> userInput)
	{
		Collections.sort(userInput);
		if(userInput.size() % 2 == 1)
		{
			int mid = userInput.size() / 2;
			double median = userInput.get(mid);
			return median;
		}
		else
		{
			int mid = userInput.size() / 2;
			double median = (userInput.get(mid) + userInput.get(mid+1)) / 2;
			return median;
		}
	}
	
	/*
	 * Mode method
	 * Returns object type of Integer which will be one singular mode
	 * or will return null if two or more modes exist
	 * Calls Collections.sort to organize userInput
	 */
	public Integer findMode(ArrayList<Integer> userInput)
	{
		Integer mode = 0;
		int max = 0;
		int count = 0;
		Collections.sort(userInput);
		for(int i = 0; i<userInput.size();i++)
		{
			for(int j = i+1; j<userInput.size();j++)
			{
				if(userInput.get(i) == userInput.get(j))
				{
					count++;
				}
			}
			if(count>max)
			{
				max = count;
				mode = userInput.get(i);
			}
			else if(count==max)
			{
				mode = null;
			}
			count=0;
		}
		return mode;
	}
	
	/* Standard Deviation
	 * Accepts userInput of ArrayList<Integer> and returns the Standard Deviation as a double
	*/
	public double standardDeviation(ArrayList<Integer> userInput)
	{
		double n = findMean(userInput);
		double var = 0;
		for (int i = 0; i<userInput.size();i++)
		{
			double d = userInput.get(i) - n;
			var += d*d;
		}
		return var = Math.sqrt(var/(userInput.size()-1));
	}
	
	/*
	 * Set Operations
	 * Union Intersection and Complement
	 * These methods accept two inputs of ArrayList<Integer> and returns one ArrayList<Int>
	 * While working on union and intersection I was having trouble removing duplicates from the result array
	 * so I proceeded to google if there was a convenient way to remove duplicates
	 * I found the .contains method which confirms an element is in an arraylist
	 * Using this I made another arraylist in Union and Intersection for .contains which would get rid of duplicate
	 * numbers. This method was also helpful in creating the complement method. By using the opposite thinking, if the
	 * arraylist did not contain the element, then it would be added to the new arraylist.
	 */
	public ArrayList<Integer> union(ArrayList<Integer> a1, ArrayList<Integer> a2)
	{
		ArrayList<Integer> union = new ArrayList<Integer>();
		for (int i=0;i<a1.size();i++)
		{
			union.add(a1.get(i));
		}
		for (int i=0;i<a2.size();i++)
		{
			union.add(a2.get(i));
		}
		
		ArrayList<Integer> newUnion = new ArrayList<Integer>();
		for (int i=0;i<union.size();i++)
		{
			if (!newUnion.contains(union.get(i)))
			{
				newUnion.add(union.get(i));
			}
		}
		
		return newUnion;
	}
	
	public ArrayList<Integer> intersect(ArrayList<Integer> a1, ArrayList<Integer> a2)
	{
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		for (int i=0;i<a1.size();i++)
		{
			for (int j=0;j<a2.size();j++)
			{
				if (a2.get(j) == a1.get(i))
				{
					intersect.add(a2.get(j));
				}
			}
		}
		
		ArrayList<Integer> newIntersect = new ArrayList<Integer>();
		for (int i=0;i<intersect.size();i++)
		{
			if (!newIntersect.contains(intersect.get(i)))
			{
				newIntersect.add(intersect.get(i));
			}
		}
		
		return newIntersect;
	}
	
	public ArrayList<Integer> complement(ArrayList<Integer> full, ArrayList<Integer> sub)
	{
		//Determines which set is the subset and which is the universal set
		if (sub.size()>full.size())
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = full;
			full = sub;
			sub = temp;
			
		}
		
		ArrayList<Integer> complement = new ArrayList<Integer>();
		for (int i=0;i<full.size();i++)
		{
			if (!sub.contains(full.get(i)))
			{
				complement.add(full.get(i));
			}
		}
		return complement;
	}
	
	/*
	 * Factorial
	 * Three methods for different data types
	 * One for BigInteger, one for long, and one for double
	 * BigInteger being the main one as double and long are limited, when a
	 * number grows too large it will become negative
	 */
	public BigInteger factorial(int n)
	{
		int factor = 1;
		BigInteger bigFactor = BigInteger.valueOf(factor);
		for (int i = 1;i<=n;i++)
		{
			BigInteger bigI = BigInteger.valueOf(i);
			bigFactor = bigFactor.multiply(bigI);
		}
		return bigFactor;
	}
	
	public double factorial2(int n)
	{
		double factor = 1;
		for (int i = 1;i<=n;i++)
		{
			factor *= i;
		}
		return factor;
	}
	
	public long factorial3(long n)
	{
		long factor = 1;
		for (int i = 1;i<=n;i++)
		{
			factor *= i;
		}
		return factor;
	}
	
	/*
	 * Permutation and Combination
	 * Uses BigInteger, its methods, and main factorial method 
	 * Converts and returns a number of type double
	 */
	public double permutation(int set, int subset)
	{
		BigInteger pre;
		pre = factorial(set).divide(factorial(set - subset));
		return pre.doubleValue();
	}
	
	public double combination(int set, int subset)
	{
		BigInteger comb;
		comb = factorial(set).divide(factorial(subset).multiply(factorial(set - subset)));
		return comb.doubleValue();
	}
	
	/*
	 * Conditional Probability
	 * Two methods
	 * One for two independent events
	 * One for two dependent events which assumes the probability of
	 * intersection is given and calculates based on the missing value A or B
	 */
	public double conditionProbIndependent(double eventA, double eventB)
	{
		return (eventA*eventB) / eventB;
	}
	
	public double conditionProbDependent(double eventA, double eventB, double eventI)
	{
		if(eventB==0)
		{
			return eventI / eventA;
		}
		else
		{
			return eventI / eventB;
		}
	}
	
	/*
	 * Intersection
	 * Two methods
	 * One for independent and dependent
	 * Independent method simply multiples the probability of the two events
	 * Dependent method assumes the conditional probability of event 2 given event 1
	 * and multiplies by the probability of event 1
	 */
	public double intersectionIndependent(double eventA, double eventB)
	{
		return eventA*eventB;
	}
	
	public double intersectionDependent(double eventA, double condProbB)
	{
		return eventA*condProbB;
	}
	
	/*
	 * Union
	 * Two Methods
	 * One for exclusive and one for nonexclusive
	 * Exclusive simply adds the probabilities
	 * Nonexclusive assumes Intersection is given and subtracts that from the sum
	 * of probabilities
	 */
	public double unionExclusive(double eventA, double eventB)
	{
		return eventA + eventB;
	}
	
	public double unionNonexclusive(double eventA, double eventB, double eventI)
	{
		return eventA + eventB - eventI;
	}
	
	/*
	 * Dependency returns whether two events are independent or not
	 * Assumes Intersection of events is given to calculate conditional probability
	 */
	public boolean dependency(double eventA, double eventB, double eventI)
	{
		if((eventI/eventB)==eventA)
		{
			return true;
		}
		else if((eventI/eventA)==eventB)
		{
			return true;
		}
		else if(eventI==(eventA*eventB))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Binomial Probability Distribution
	 * Uses combination method and Math.pow to return a result of double
	 * Included methods to calculate Expectance, Variance, and Standard Deviation
	 */
	public double binomialDistribution(int n, double p, double q, int y)
	{
		return combination(n,y)*Math.pow(p, y)*Math.pow(q, (n-y));
	}
	
	public double getExpectedBD(int n, double p)
	{
		return n*p;
	}
	
	public double getVarianceBD(int n, double p, double q)
	{
		return n*p*q;
	}
	
	public double getStanDevBD(int n, double p, double q)
	{
		return Math.sqrt(getVarianceBD(n,p,q));
	}
	
	/*
	 * Geometric Probability Distribution
	 * Uses Math.pow to return a result of double
	 * Included methods to calculate Expectance, Variance, and Standard Deviation
	 */
	public double geometricDistribution(double p, double q, int y)
	{
		return Math.pow(q, y-1) * p;
	}
	
	public double getExpectedGD(double p)
	{
		return 1/p;
	}
	
	public double getVarianceGD(double p)
	{
		return (1-p)/Math.pow(p, 2);
	}
	
	public double getStanDevGD(double p)
	{
		return Math.sqrt(getVarianceGD(p));
	}
	
	/*
	 * Negative Binomial Probability Distribution
	 * Uses combination method and Math.pow to return a result of double
	 * Included methods to calculate Expectance, Variance, and Standard Deviation
	 */
	public double negBinoDistribution(int r, double p, double q, int y)
	{
		return combination((y-1), (r-1)) * Math.pow(p, r) * Math.pow(q, (y-r));
	}
	
	public double getExpectedNBD(int r, double p)
	{
		return (r/p);
	}
	
	public double getVarianceNBD(int r, double p)
	{
		return (r*(1 - p))/Math.pow(p, 2);
	}
	
	public double getStanDevNBD(int r, double p)
	{
		return Math.sqrt(getVarianceNBD(r, p));
	}
	
	/*
	 * Hypergeometric Probability Distribution
	 * Splits the numerator and denominator to separate variables
	 * Uses combination method to return a result of double
	 * Included methods to calculate Expectance, Variance, and Standard Deviation
	 */
	public double hyperGeoDistribution(int N, int n, int r, int y)
	{
		double nA = combination(r, y) * combination((N-r),(n-y));
		double nS = combination(N, n);
		return (nA/nS);
	}
	
	public double getExpectedHGD(int N, int n, int r)
	{
		return (n*r)/(double) N;
	}
	
	public double getVarianceHGD(double N, int n, double r)
	{
		return n * (r/N) * ((N-r)/N) * ((N-n)/(N-1));
	}
	
	public double getStanDevHGD(int N, int n, int r)
	{
		return Math.sqrt(getVarianceHGD(N,n,r));
	}
}
