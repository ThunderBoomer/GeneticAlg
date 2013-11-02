// Common constant definitions shared by STM and GAI2F
package ga;

public interface STMparams {
	/* Virtual Computer STM Symbolics */
	final static int DUP = 0;
	final static int SWAP = 1;
	final static int MUL = 2;
	final static int ADD = 3;
	final static int OVER = 4;
	final static int NOP = 5;

	final static int MAX_INSTRUCTION = 6;

	final static String tins[]={"DUP","SWAP","MUL","ADD","OVER","NOP"};

	final static int  NONE = 0;
	final static int  STACK_VIOLATION = 1;
	final static int  MATH_VIOLATION = 2;
}
