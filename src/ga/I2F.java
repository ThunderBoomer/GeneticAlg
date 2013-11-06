package ga;
// Common constant definitions for GAI2F
public abstract class I2F {

	/* Constants used for fitness evaluation */

	final static int MAX_GENERATIONS		= 100000;
	final static int STEP = 100; // how often the output is produced

	final static int COUNT   = 10; // number of test cases per generation
	final static int TIER1   = 1;
	final static int TIER2   = 20;
	final static int TIER3   = 400;
	// Max possible fitness value for a chromosome per generation
	final static double MAX_FIT  = (double)((TIER3 * COUNT) + (TIER2 * COUNT) + (TIER1 * COUNT));


	/* Application-preferred number of genes per chromosome */

	final static int MAX_PROGRAM = 12;

	/* Temp storage of fitness data */
	double minFit[] = new double [MAX_GENERATIONS/STEP+1];
	double avgFit[] = new double [MAX_GENERATIONS/STEP+1];
	double maxFit[] = new double [MAX_GENERATIONS/STEP+1];

	/* Test cases */
	static int[] args;
	static double answer;

	public static void generateTestCase(){
		int[] a = {(int)(Math.random()*31) + 1,
		           (int)(Math.random()*31) + 1,
					  (int)(Math.random()*31) + 1
					 };
					 //{(int)(Math.random()*31) + 1,
					 // (int)(Math.random()*31) + 1,
					 // (int)(Math.random()*31) + 1
				    //};
		args = a;

		answer = args[0] + args[1] + args[2];
					// Math.pow(args[0], 4) + 2*args[1];
				   // args[0] * args[2] + 3  * args[1];

	}
}
