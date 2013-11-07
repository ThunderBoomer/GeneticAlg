/**
 * 
 */
package ga;
import java.util.*;

/**
 * @author Russell
 *
 */
public class Coupling extends I2F implements GAparams {
	
	private ArrayList<Chrom> currentPopulation;
	private ArrayList<Chrom> newPopulation = new ArrayList<Chrom>();

	/**
	 * @param args
	 */
	public Coupling(){
		
	}

	public void setChroms(ArrayList<Chrom> currentPopulation){
		this.currentPopulation = currentPopulation;
		int count = 0;
		do
		{
			chooseParents();
		}while (count < MAX_GENERATIONS);
	}
	
	public ArrayList<Chrom> getChroms (){
		
		return newPopulation;
	}
	
	//chooseParents() will not be able to be coded properly without correct "fitness" values
	public void chooseParents(){
		int p1;
		int p2;
		
		Chrom parent1;
		Chrom parent2;

		
		
		int genePoint; //variable used to point to location of gene swap (and mutation) within chromosomes
		
		Random r = new Random();
		//Choose first Parent
		p1 = r.nextInt(MAX_CHROMS); //100-0) + 0;
		//pass int value of p1 to CLASS Roulette
		//CLASS Roulette will judge which chromosome that p1 "falls" into
		//The returning value, from CLASS Roulette, is the chosen parent chromosome
		
		//However, because of the fore mentioned issue, p1 will be given a random int value between 0 and (MAX_CHROMS-1)
		//This will choose parents from the entire population and without weights attached to each chromosome
		
		
		//p1 = r.nextInt(MAX_CHROMS); //-0) + 0
		
		
		//If we make the population of each "generation" dynamic, this code might be helpful.
		//*****
		//System.out.println(currentPopulation.size());
		//p1 = r.nextInt(currentPopulation.size() - 0) + 0;
		//*****
		
		
		
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
		
		//Currently unaware if only one option is to be used (cloning, coupling, and mutation).
		//I assume cloning happens regardless.
		//Then there are 2 cases:
		//	Only one of the following can happen: coupling, mutation, neither (cloning).
		//	Both coupling and mutation (independantly) have the possibility of occuring but might not.
		
		//ALSO, read somewhere that cloning and mutation may only use just one chromosome
		//But i dont think that is the case here.
		//Just leaving myself a note to check into this possibility.
		
		//Going off the assumption both, neither, or just one can happen.
		
		//*****
		int min = 1; //Can't choose the very first gene
		int max = MAX_GENES - 2;
		
		int[] ch1Genes = new int[MAX_GENES];
		int[] ch2Genes = new int[MAX_GENES];
		int[] tempGenes = new int[MAX_GENES];
		//int max = (parent1.getGenes()).length-1; //Can't choose the very last gene
		
		//Cloning: just in case "coupling" does not occur
		
		ch1Genes = parent1.getGenes();
		ch2Genes = parent2.getGenes();
		
		
		parent1.printGenes();
		System.out.println();
		parent2.printGenes();
		System.out.println();

		System.out.print("************");
		
		
		
		
		
		//Checking if parents "couple"
		
		//double randVal = r.nextDouble()*100;
		int randVal = r.nextInt(100);
		//System.out.println(randVal);
		
		
		
		
		if(randVal <= 80) //0.0 to 100.0 if <= 80.0 then crossover occurs (coupling)
		{
			genePoint = r.nextInt(max - min) + min; //crossover point
/*			System.out.println(genePoint);
			System.out.println("===========");
			for(int i = genePoint; i < MAX_GENES;  i++)
			{
				
				System.out.print(ch1Genes[i]);
				
				
			}
			System.out.println("===========");
			System.out.println("===========");
			for(int i = genePoint; i < MAX_GENES;  i++)
			{
				
				System.out.print(ch2Genes[i]);
				
			}
			System.out.println("===========");
*/
			for(int i = genePoint; i < MAX_GENES;  i++)
			{
				//System.out.println("====="+i+"======");
				//System.out.println(ch1Genes[i]);
				//System.out.println(ch2Genes[i]);
				//
				tempGenes[i] = ch2Genes[i];
				
				ch2Genes[i] = ch1Genes[i];
				ch1Genes[i] = tempGenes[i];
				//
				//System.out.println("After "+i+"======");
				//System.out.println(ch1Genes[i]);
				//System.out.println(ch2Genes[i]);
				//System.out.println("Next");
				
			}
			
			System.out.print("C is True "+ randVal +"\t");
			//genes before (or after) location "genePoint" will be swapped between the two parents
			//the outcome creates the two children chromosome which will be placed into the newPopulation
			
				
		}

		//Checking if children "mutate"
		randVal = r.nextInt(100);
		//if(r.nextDouble()*100 <= 2) //0.0 to 100.0 if <= 2.0 then mutate
		if(randVal <= 2)
		{

			
			//Mutation
			//Choose Mutation location within both chromosomes
			//int min = 1; //Can't choose the very first gene
			//int max = (parent1.getGenes()).length-1; //Can't choose the very last gene
			genePoint = r.nextInt(MAX_GENES-1);// - min) + min; //mutation point, in this case only one gene is altered.
			//So the mutation point changes to one of the other operators...maybe the same, should we let this happen?
			
			//will both children mutate at the same spot? will that spot only be just one gene?
			
			//Mutation will alter a certain amount of genes before (or after) location "genePoint"
			
			//maybe each child should be tested separately so that one, both or neither may mutate.
			int mValue = r.nextInt(6);
			/*
			System.out.println();
			System.out.println("Mutate Child1");
			System.out.println();
			System.out.println("genePoint: "+genePoint);
			System.out.println("mValue: "+mValue);
			System.out.println();			
			*/
			System.out.print("M1 is True "+ randVal +"\t");
			ch1Genes[genePoint] = mValue;
			
			
			
		} //else no Mutation
		
		//child2 mutate check
		randVal = r.nextInt(100);
		//if(r.nextDouble()*100 <= 2) //0.0 to 100.0 if <= 2.0 then mutate
		if(randVal <= 2)
		{
			genePoint = r.nextInt(MAX_GENES-1);// - min) + min;
			int mValue = r.nextInt(6);
			/*
			System.out.println();
			System.out.println("Mutate Child2");
			System.out.println();
			System.out.println("genePoint: "+genePoint);
			System.out.println("mValue: "+mValue);
			System.out.println();			
			*/
			System.out.print("M2 is True "+ randVal +"\t");
			
			ch2Genes[genePoint] = mValue;
			
		}
		
		
		
		
		
		
		
		Chrom child1 = new Chrom(ch1Genes);
		Chrom child2 = new Chrom(ch2Genes);
		
		System.out.println("************");
		
		child1.printGenes();
		System.out.println();
		child2.printGenes();
		System.out.println();
		
		newPopulation.add(child1);
		newPopulation.add(child2);
		
		
		
		//*****
	}
}