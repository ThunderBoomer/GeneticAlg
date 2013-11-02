package ga;
/*
 *  A simple "STack" Machine that only understands 6 basic operations:
 *	 
 *	 DUP, SWAP, MUL, ADD, SUB, and OVER
 *
 *  STM.java
 *
 *  zxu@valdosta.edu
 *
 */
 
import java.util.*;
import java.io.*;

public class STM implements STMparams {

	
	/* Stack Depth */
	
	final static int STACK_DEPTH	= 25;
	
	private int[] stack; 
	
	// A pointer that shows where the NEXT element will be pushed into
	private int stackPointer;
	
	public STM (){
		stack = new int[STACK_DEPTH];
		stackPointer = 0;
	}

	// ASSERT Functions
	private int ASSERT_STACK_ELEMENTS(int x){
		// Does the stack have at least x number of elements inside?
		if (stackPointer < x) return STACK_VIOLATION;
		else return NONE;  
	}
	
	private int ASSERT_STACK_NOT_FULL(){
		if (stackPointer == STACK_DEPTH) return STACK_VIOLATION;
		else return NONE;  
	}
	
	private void SPUSH(int x){
		stack[stackPointer++] = x;
	}
	private int SPOP(){
		return stack[--stackPointer];
	}
	public int SPEEK(){
		return stack[stackPointer-1];
	}
	public int getStackPointer(){
		return stackPointer;
	}
	public void printStack(){
		for(int i=stackPointer-1; i>=0;i--){	
			System.out.println(stack[i] + " ");
		}
		System.out.println();
	}
	
/*
 *  interpretSTM()
 *
 *  This method is the stack machine interpreter.  The program, its
 *  length, and 'argsLength' number of arguments are passed to perform
 *  whatever function is provided within 'program'.  Upon completion,
 *  any error encountered is returned to the caller.  The private stack
 *  'stack' is used to determine the result of the program and to test
 *  what was expected (which determines the fitness).
 *
 */

public int interpretSTM(int[] program, int progLength, 
                   int[] args, int argsLength)
{
  int pc = 0;
  int i, error = NONE;
  int a, b;

  stackPointer = 0;

  /* Load the arguments onto the stack */
  for (i = argsLength-1 ; i >= 0 ; i--) {
    SPUSH(args[i]);
  }
  
  /* Execute the program */
  while ((error == NONE) && (pc < progLength)) {

    switch(program[pc++]) {

      case DUP:{
        	if( (error = ASSERT_STACK_ELEMENTS(1))!=NONE ) break;
			if( (error = ASSERT_STACK_NOT_FULL())!=NONE ) break;
	      SPUSH(SPEEK());
			//printStack();
         break;
		  }

      case SWAP:{
        	if( (error = ASSERT_STACK_ELEMENTS(2))!=NONE ) break;
        	a = stack[stackPointer-1];
        	stack[stackPointer-1] = stack[stackPointer-2];
        	stack[stackPointer-2] = a;
	//		printStack();
        	break;
		  }	

      case MUL:{
       	if( (error = ASSERT_STACK_ELEMENTS(2))!=NONE ) break;
        	a = SPOP(); b = SPOP();
        	SPUSH(a * b);
		//	printStack();
        	break;
		  }

      case ADD:{
        	if( ( error = ASSERT_STACK_ELEMENTS(2) ) != NONE ) break;
        	a = SPOP(); b = SPOP();
        	SPUSH(a + b);
		//	printStack();
        	break;
		  }
		  
	/*	case SUB:{
        	if( ( error = ASSERT_STACK_ELEMENTS(2) )!=NONE ) break;
        	a = SPOP(); b = SPOP();
        	SPUSH(a - b);
        	break;
		  }*/

      case OVER:{
        	if( (error = ASSERT_STACK_ELEMENTS(2))!=NONE ) break;
			if( (error = ASSERT_STACK_NOT_FULL())!=NONE ) break;
        	SPUSH(stack[stackPointer-2]);
        	break;
		  }
		case NOP:{
        	break;
		  }

    } /* Switch opcode */
	// printStack();

  } /* Loop */

  return(error);
}



} // end of class STM