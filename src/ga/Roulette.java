/**
 * 
 */
package ga;

import java.util.ArrayList;
import java.util.*;

/**
 * @author Russell
 *
 */
public class Roulette {
	
	ArrayList<Chrom> currentPopulation;
	private double[] eachFitnessRatio;
	private double maxRatioVal;
	private int counter;
	public Roulette()
	{
		counter = 0;
	}
	
	public Roulette(ArrayList<Chrom> currentPopulation, double[] eachFitnessRatio, double gen)
	{
		this.currentPopulation = currentPopulation;
		this.eachFitnessRatio = eachFitnessRatio;
		maxRatioVal = eachFitnessRatio[0];
		if(gen>7000 || gen==3000)
		{int count = 0;
			do{
			if (eachFitnessRatio[count]>maxRatioVal)
			{
				maxRatioVal = eachFitnessRatio[count];
			}
			count++;
		}while(count < 3000);
			/*
			System.out.println();
			int count = 0;
			do{
				System.out.println("FIT RATIOOOOOOOOOOOO: "+ eachFitnessRatio[count]);
				count++;
			}while(count < 3000);	
			System.out.println();
			*/
			System.out.println("FIT RATIOOOOOOOOOOOO: "+ maxRatioVal);
		}
		
	}
	public int getCounter()
	{
		return counter;
	}
	public double spin(double point)
	{
		Random r = new Random();
		//double randVal = r.nextDouble()*100;
		point = ((r.nextDouble()*maxRatioVal)+point);
		
		while (point>maxRatioVal)
		{
			counter++;
			point-=maxRatioVal;
		}
		
		
		return point;
	}
	public Chrom findParent(double point)
	{
		int count = 0;
		while(point > eachFitnessRatio[count])
		{
			count++;
			point -= eachFitnessRatio[count];
		}
		
		
		return currentPopulation.get(count);
	}
	

	
}
