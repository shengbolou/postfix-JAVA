package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
    private LLnode<T> top;
    private T t=null;
    
	/**
	 * {@inheritDoc}
	 */
	
	public LinkedStack(){
		top=null;
	}
	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()){
			t=top.getInfo();
			top=top.getLink();
			return t;
			// TODO Auto-generated method stub
		}
		else{
			throw new StackUnderflowException("the stack is empty");
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(!isEmpty()){// TODO Auto-generated method stub
			return top.getInfo();
		}
		else{
			throw new StackUnderflowException("the stack is empty");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		if(top==null){
			return true;// TODO Auto-generated method stub
		}
		else return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		LLnode<T> l=top;// TODO Auto-generated method stub
		int a=0;
		while(l!=null){
			a++;
			l=l.getLink();
		}
		return a;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		LLnode<T> L=new LLnode(elem);
		L.setLink(top);
		
		top=L;
		
		
	}

}
