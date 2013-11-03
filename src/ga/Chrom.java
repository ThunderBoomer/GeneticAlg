/**
 * 
 */
package ga;


/**
 * @author Corey
 *
 */
public class Chrom implements GAparams{

	private int[] genes = new int[MAX_GENES];
	private int error; //value returned by STM - assumed to be fitness value
	
	public Chrom(){
	
		//randomly populate genes array
		for (int i = 0; i < MAX_GENES; i++){
			genes[i] = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
		}
	
	}
	
	public int getError(){
		return error;
	}
	
	public int[] getGenes(){
		return genes;
	}
	
	//for testing
	public void printGenes(){
		System.out.print(genes);
	}
	
}
