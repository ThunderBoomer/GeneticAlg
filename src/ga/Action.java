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
public class Action extends I2F implements GAparams{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Chrom> chromsToCoupling = new ArrayList<Chrom>();
		ArrayList<Chrom> chromsFromCoupling;
		
		Chrom chromosone;
		Coupling couple = new Coupling();
		
		//read values from command line (equation using java equation class) - TO BE DONE LATER
		
		//create MAX_CHROMS number of CHROMS by calling constructor
		for (int i = 0; i < MAX_CHROMS; i++){	
			chromosone = new Chrom();
			chromsToCoupling.add(chromosone);	
		}
		
	}

}























//*****************

//OLD SILLINESS USED TO BE IN MAIN METHOD, NOW DOWN HERE SO I CAN FOCUST

/*//to check the chromosone int array values in index 0,1,2
chroms.get(0).printGenes();
System.out.print("\n");
chroms.get(1).printGenes();
System.out.print("\n");
chroms.get(2).printGenes();
*/

//temp call to Coupling to send arrays to Coupling class - STM HAS NOT BEEN IMPLEMENTED
//couple.setChroms(chromsToCoupling);

//temp call to receive arrays from Coupling class so getChroms wouldn't feel left out
//chromsFromCoupling = couple.getChroms();

/*//Testing: Prints values (Genes and Error) from "TO Coupling" arraylist:
for (int i = 0; i < MAX_CHROMS; i++){	
	(chromsToCoupling.get(i)).printGenes();
	System.out.println((chromsToCoupling.get(i)).getError());
}
*/

/*//Testing: Prints values (Genes and Error) from "FROM Coupling" arraylist:
for (int i = 0; i < MAX_CHROMS; i++){	
	(chromsToCoupling.get(i)).printGenes();
	System.out.println((chromsToCoupling.get(i)).getError());
}
*****************************/
