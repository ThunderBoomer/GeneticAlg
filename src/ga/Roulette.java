/**
 * 
 */
package ga;

import java.util.ArrayList;

/**
 * @author Russell
 *
 */
public class Roulette {
	
	ArrayList<Chrom> currentPopulation;
	private double[] eachFitnessRatio;
	
	public Roulette()
	{
		
	}
	
	public Roulette(ArrayList<Chrom> currentPopulation, double[] eachFitnessRatio, double gen)
	{
		this.currentPopulation = currentPopulation;
		this.eachFitnessRatio = eachFitnessRatio;
		if(gen>7000 || gen==3000)
		{
			System.out.println();
			int count = 0;
			do{
				System.out.println("FIT RATIOOOOOOOOOOOO: "+ eachFitnessRatio[count]);
				count++;
			}while(count < 3000);	
			System.out.println();
		}
	}
	
}
