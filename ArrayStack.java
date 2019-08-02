//Authors: Lauren Johnson
//Assignment 2
//Part 1
//generic implementation of ArrayStack using Stack interface
public class ArrayStack<T> implements Stack<T> {
	//instance variables
	private T[] elems;
	private int top;
	private int size;
	//constructor
	@SuppressWarnings("unchecked")
	public ArrayStack(int n){
		elems = (T[]) new Object[ n ];
		top = 0;
	}
	//methods
	/*returns true if Stack is empty
	*/
	public boolean isEmpty(){
		return (top == 0);
	}
	/*returns true if Stack is full
	*/
	public boolean isFull(){
		return (top-1) == elems.length;
	}
	/*returns top element of Stack
	*/
	public T peek(){
		if(!isEmpty()){
			return elems[top-1];
		}
		return null;
	}
	/*Removes and returns the top element of Stack
	*/
	public T pop(){
		T saved = elems[ top-1 ];
		elems[ top-1 ] = null;
		top--;
		return saved;
	}
	/*Pushes new item T into Stack
	*/
	public void push(T item){
		if(!isFull()){
			elems[top] = item;
			top++;
		}
	}
	/*Clears Stack
	*/
	public void clear(){
		for(int i = 0; i<elems.length; i++){
			elems[i] = null;
		}
		top = 0;
	}
	/*returns size of stack
	*/
	public int size(){
		return top-1;
	}
	/*Reverses the items in the Stack by using a temp ArrayStack, pushing generic elements, and then popping the
	/elements from temp into generic array
	*/
	public void reverse(){
		ArrayStack<T> temp = new ArrayStack<T>(elems.length);
		for(int i = 0; i<top; i++){
			temp.push(elems[i]);
		}
		for(int i=0;i<top;i++){
			elems[i] = temp.pop();
		}
	}
	/*Returns string representation of Stack
	*/
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = top -1; i>=0; i--){
			sb.append(elems[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
	/*Displays items in the Stack
	*/
	public void display(){
		System.out.println(toString());
	}
}
