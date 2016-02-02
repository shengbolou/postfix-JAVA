package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;

/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	private LinkedStack<Operand<Integer>> LS;



	/**
	 * Constructs an {@link ArithPostFixEvaluator}
	 */
	public ArithPostFixEvaluator(){
		this.stack = null; //TODO Initialize to your LinkedStack
		LS=new LinkedStack<Operand<Integer>>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) {
		// TODO Use all of the things they've built so far to 
		// create the algorithm to do post fix evaluation
		ArithPostFixParser parser = new ArithPostFixParser(expr);
		Operand<Integer> O=new Operand<Integer>(null);
		int operand=0;
		int operator=0;
		while(parser.hasNext()){
			switch(parser.nextType()){ 
			case OPERAND:
				LS.push(parser.nextOperand());
				operand++;//TODO What do we do when we see an operand?
				break;
			case OPERATOR:

				Operator<Integer> oper=parser.nextOperator();
				if(!LS.isEmpty()) {
					oper.setOperand(1, LS.pop());
					if(!LS.isEmpty()){
						oper.setOperand(0,LS.pop());
					}
				}
				oper.performOperation();
				LS.push(oper.performOperation());
				O=oper.performOperation();
				operator++;
				break;
			}


		}
		if(operand==1){
			O=new Operand<Integer>(LS.pop().getValue());
		}
		else if(operator==0){
			throw new IllegalPostFixExpressionException("No operator!");
		}

		//TODO What do we return?
		return O.getValue();
	}

}
