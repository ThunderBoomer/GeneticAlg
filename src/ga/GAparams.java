package ga;

public interface GAparams{
	final static double CROSSOVER_PROB = 0.8;								
	final static double MUTATION_PROB = 0.02;									
	final static int MAX_CHROMS = 3000;
	final static int MAX_GENES = 10;
	
	//min and max values for int value of genes -- used in Chrom to generate random values 0-5
	final static int MIN = 0;
	final static int MAX = 5;
	
	//number of iterations program runs without successful solution - used in Action
	//SHOULD UPDATE TO BE LARGER/SMALLER BASED ON OUTCOME OF TRIALS
	final static int MAX_GENERATIONS = 10000;
	
}
