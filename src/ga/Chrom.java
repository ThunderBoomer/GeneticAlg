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
	private double error = 0; //value returned by STM - assumed to be fitness value - defaulted to 0
	
	public Chrom(){
	
		//randomly populate genes array
		for (int i = 0; i < MAX_GENES; i++){
			genes[i] = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
		}
	
	}
	
	public Chrom(int gene[]){
		
		this.genes = gene;
		//test
		//printGenes();
		//****
	}
	
	public double getError(){
		return error;
	}
	
	public void setError(double d){
		this.error += d;
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
