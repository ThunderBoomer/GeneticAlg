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
	private int error = 0; //value returned by STM - assumed to be fitness value - defaulted to 0
	
	public Chrom(){
	
		//randomly populate genes array
		for (int i = 0; i < MAX_GENES; i++){
			genes[i] = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
		}
	
	}
	
	public int getError(){
		return error;
	}
	
	public void setError(int fitVal){
		this.error = fitVal;
	}
	
	public int[] getGenes(){
		return genes;
	}
	
	//for testing values in genes array
	public void printGenes(){
		for (int i = 0; i < MAX_GENES; i++){
			System.out.print(genes[i]);
		}
	}
	
}
