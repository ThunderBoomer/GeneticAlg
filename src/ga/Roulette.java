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
		System.out.println();
	}
	
	public Roulette(ArrayList<Chrom> currentPopulation, double[] eachFitnessRatio)
	{
		this.currentPopulation = currentPopulation;
		this.eachFitnessRatio = eachFitnessRatio;
	}
}
