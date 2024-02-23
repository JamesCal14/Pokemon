import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
public class Example 
{
	/*
	 * Central tendencies Mean, Median and Mode
	 * Accepts userInput of type ArrayList<Integer> and returns double value
	 * -Fix mode
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
	
	//In the median method, the Collections.sort method is used to organize the list in order to locate the middle
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
	
	//mode - the number that occurs the most, but it must be unique, no 2 or more modes.
	//if two modes, return null
	public double findMode(ArrayList<Integer> userInput)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		double mode = 0;
		int maxCount = 0;
		Collections.sort(userInput);
		for(int i = 0; i<userInput.size();i++)
		{
			if(set.size()>maxCount)
			{
				maxCount = set.size();
				mode = userInput.get(i);
			}
			set.clear();
			for(int j = i+1; j<userInput.size();j++)
			{
				if(userInput.get(i) == userInput.get(j))
				{
					set.add(userInput.get(i));
				}
			}
		}
		return mode;
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
	
	public double premutation(int set, int subset)
	{
		// n! / (n-r)!
		double pre;
		pre = factorial2(set) / (factorial2(set - subset));
		return pre;
	}
	
	public double combination(int set, int subset)
	{
		// n! / r! (n-r)!
		double comb;
		comb = factorial2(set) / (factorial2(subset) * (factorial2(set - subset)));
		return comb;
	}
	
	/*
	 * Union, Intersect and Complement math helper methods
	 */
	public double unionMath(double a, double b)
	{
		double union;
		union = (a+b)-intersectMath(a, b);
		return union;
	}
	
	public double intersectMath(double a, double b)
	{	
		double intersect;
		intersect = a*b;
		return intersect;
	}
	
	public double complementMath(double a)
	{
		double nA;
		a = a*100;
		nA = 100 - a;
		return nA;
	}
	
	public double conditionProb(double aProb, double bProb, double iProb)
	{
		double cond = iProb / bProb;
		return cond;
	}
	
	//huge method header to determine which probabilities are present/ non-present
	public boolean dependency(double aProb, double bProb, double iProb)
	{
		//assumes all three values are given
		if(conditionProb(aProb, bProb, iProb)==aProb)
		{
			return true;
		}
		else if(conditionProb(bProb, aProb, iProb)==bProb)
		{
			return true;
		}
		else if(iProb==(aProb*bProb))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double totalProbability(double aProb, double bProb, double iProb)
	{
		//totalProb the probability of B is always changing, is it possible to program
		//with inputting a huge list of numbers?
		double total;
		total = conditionProb(aProb, bProb, iProb) * bProb;
		return total;
	}
	
	public double bayesRule(double aProb, double bProb, double aConProb, double bConProb)
	{
		double result;
		result = (bConProb*bProb) / ((bConProb*bProb) + (aConProb*aProb));
		return result;
	}
	
	public void pmf()
	{
		//uses premutation
	}
	
	public void binomialDistributions()
	{
		
	}
}
