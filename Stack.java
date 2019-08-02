//Authors: Lauren Johnson, Liam Waddell
//Student numbers: 300016250, 300021290
//Assignment 2
//Part 1
//interface Stack created to be used for Questions 2 and 3, and for 
//generic implementations of ArrayStack and ListStack
public interface Stack <T>{
	//interface methods
	/*returns true if Stack is empty
	*/
	public abstract boolean isEmpty();
	/*returns true if Stack is full
	*/
	public abstract boolean isFull();
	/*returns top element of Stack
	*/
	public abstract T peek();
	/*Removes and returns the top element of Stack
	*/
	public abstract T pop();
	/*Pushes new item T into Stack
	*/
	public abstract void push(T item);
	/*Clears Stack
	*/
	public abstract void clear();
	/*returns size of stack
	*/
	public abstract int size();
	/*Returns string representation of Stack
	*/
	public abstract String toString();
	/*Reverses the items in the Stack
	*/
	public abstract void reverse();
	/*Displays items in the Stack
	*/
	public abstract void display();
}