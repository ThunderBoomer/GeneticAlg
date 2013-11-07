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
		
		//IT IS POSSIBLE stm needs to be created on every loop down below, but unlikely.
		STM stm = new STM();
		
		//for while loop
		int generationCount = 0;
		
		//local storage of args array in I2F -- POSSIBLY REDUNDANT
		int[] argsFromI2F;
		
		//return value of stm
		int error;
		
		//used to calculcate tier3 if answer is wrong
		double tier3Error;
		
		//read values from command line (equation using java equation class) - TO BE DONE LATER
		
		//create MAX_CHROMS number of CHROMS by calling constructor
		for (int i = 0; i < MAX_CHROMS; i++){	
			chromosone = new Chrom();
			chromsToCoupling.add(chromosone);	
		}
		
		//(1)NOT SURE WHERE THIS GOES
		//builds args array from I2F and stores it locally
		//generateTestCase();
		//argsFromI2F = I2F.args;
		
		//MEAT AND POTATOES
		do{
			
			//(2)NOT SURE WHERE THIS GOES
			//builds args array from I2F and stores it locally
			generateTestCase();
			argsFromI2F = I2F.args;
			
			//for every chrom in ArrayList
			for (int i = 0; i < MAX_CHROMS; i++){
				
				//for however many times the test for each chrom will run (currently 10 - set in I2F)
				for (int j = 0; j < COUNT; j++){
					
					//Sends array of genes belonging to the chromosone at index i of chromsToCoupling
					//and other required info to STM
					error = stm.interpretSTM(chromsToCoupling.get(i).getGenes(), MAX_GENES, argsFromI2F, argsFromI2F.length);
				
					//error returned by stm - if 0 then tier1 (1 by default)
					if (error == 0){
						chromsToCoupling.get(i).setError(TIER1);
						
						//if error0 && only one item left on stack, then ALSO tier2 (20 by default)
						if(stm.getStackPointer() == 1){
							chromsToCoupling.get(i).setError(TIER2);
							
							//if error0 && only one item && correct answer, then ALSO tier3 (400 by default)
							if(stm.SPEEK() == I2F.answer){
								chromsToCoupling.get(i).setError(TIER3);
							}
							//if error0 && only one item && NOT correct answer,
							//fitval ALSO tier3 * 1/1+absolute value of i2f answer - value on stack 
							else {
								tier3Error = Math.abs(I2F.answer - stm.SPEEK());
								
								chromsToCoupling.get(i).setError(TIER3 * (1/(1+tier3Error)));
							}
						}
							
					}
					//stm exited with error - fitval set to 0
					else
						chromsToCoupling.get(i).setError(0);
				}
				
			}
			
			
			//after assigning fitness values, sends current generation to Coupling
			couple.setChroms(chromsToCoupling);
				
			//Perhaps we can cut this down to operating with a single arrayList by using
			
			chromsToCoupling = couple.getChroms();
			
			//instead of
			//chromsFromCoupling = couple.getChroms();
				
			
			//GUESS WHAT THIS DOES
			generationCount++;
			if(generationCount % 1000 == 0)
			{
				System.out.println(generationCount);
				//couple.chooseParents();
				System.out.println();
			}
		}while (generationCount < MAX_GENERATIONS);
		
	}//END MAIN


}//END CLASS























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
