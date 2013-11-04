/**
 * 
 */
package ga;
import java.util.*;

/**
 * @author Russell
 *
 */
public class Coupling {
	
	ArrayList<Chrom> currentPopulation = new ArrayList<Chrom>();
	ArrayList<Chrom> newPopulation = new ArrayList<Chrom>();

	/**
	 * @param args
	 */
	public Coupling(){
		
	}

	public void setChroms(ArrayList<Chrom> currentPopulation){
		
	}
	
	public ArrayList<Chrom> getChroms (){
		
		return newPopulation;
	}
	
	//chooseParents() will not be able to be coded properly without correct "fitness" values
	private void chooseParents(){
		int p1;
		int p2;
		
		Chrom parent1;
		Chrom parent2;
		
		int genePoint; //variable used to point to location of gene swap (and mutation) within chromosomes
		
		Random r = new Random();
		//Choose first Parent
		p1 = r.nextInt(100-0) + 0;
		//pass int value of p1 to CLASS Roulette
		//CLASS Roulette will judge which chromosome that p1 "falls" into
		//The returning value, from CLASS Roulette, is the chosen parent chromosome
		
		//However, because of the fore mentioned issue, p1 will be given a random int value between 0 and (MAX_CHROMS-1)
		//This will choose parents from the entire population and without weights attached to each chromosome
		System.out.println(currentPopulation.size());
		p1 = r.nextInt(currentPopulation.size() - 0) + 0;
		
		//Choose second Parent
		p2 = r.nextInt(100-0) + 0;
		while(p1==p2)
		{
			p2 = r.nextInt(100-0) + 0;
			//pass new p2 back to CLASS Roulette for a different parent
			//No a-sexual chromosomes allowed...ever
		}
		
		//Outright bypassing CLASS Roulette for right now
		//******
		parent1 = currentPopulation.get(p1);
		parent2 = currentPopulation.get(p2);
		//******
		
		//Time to "couple"
		
		int min = 1; //Can't choose the very first gene
		int max = (parent1.getGenes()).length-1; //Can't choose the very last gene
		
		if(r.nextDouble()*100 <= 80) //0.0 to 100.0 if <= 80.0 then crossover occurs (coupling)
		{
			genePoint = r.nextInt(max - min) + min;
			
			//genes before (or after) location "genePoint" will be swapped between the two parents
			//the outcome creates the two children chromosome which will be placed into the newPopulation
				
		}

		//Mutate? Or not to... I'll stop...
		if(r.nextDouble()*100 <= 2) //0.0 to 100.0 if <= 2.0 then mutate
		{
			//Mutation
			//Choose Mutation location within both chromosomes
			//int min = 1; //Can't choose the very first gene
			//int max = (parent1.getGenes()).length-1; //Can't choose the very last gene
			genePoint = r.nextInt(max - min) + min;
			
			//Mutation will alter a certain amount of genes before (or after) location "genePoint"
			
			
			
		}
		//else no Mutation
		
		
		
		
	}
}
