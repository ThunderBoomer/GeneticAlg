/**
 * 
 */
package ga;

//new comment
//new comment 2 HEY RUSSELL

import java.util.*;
/**
 * @author Corey
 *
 */
public class Action implements GAparams{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Chrom> chroms = new ArrayList<Chrom>();
		//Chrom[] chroms = new Chrom[MAX_CHROMS];
		Chrom chromosone;
		
		//read values from command line (equation using java equation class)
		
		//create MAX_CHROMS number of CHROMS by calling default constructor
		
		for (int i = 0; i < MAX_CHROMS; i++){	
			chromosone = new Chrom();
			chroms.add(chromosone);
			//chroms[i] = chromosone;	
		}
		
		//to check the chromosone int array values
		chroms.get(0).printGenes();

	}

}
