/**
 * 
 */
package ga;

//import java.util.*;

/**
 * @author Corey
 *
 */
public class Chrom implements GAparams{

	private int[] genes = new int[MAX_GENES];
	private int error;
	
	public Chrom(){
	
			//randomly populate genes array
	
	}
	
	public int getError(){
		return error;
	}
	
	public int[] getGenes(){
		return genes;
	}
	
}
