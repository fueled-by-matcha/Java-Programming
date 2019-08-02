//Authors: Lauren Johnson, Liam Waddell
//Student numbers: 300016250, 300021290
//Assignment 2
//Part 1
//Generic implementation of ListStack using Stack interface
public class ListStack<T> implements Stack<T> {
    private static class Elem<E> {
        private E info;
        private Elem<E> next;
        private Elem(E info, Elem<E> next) {
            this.info = info;
            this.next = next;
        }
    }
    
    // instance variables
    private Elem<T> top;
    private int capacity;
    
    // constructor
    public ListStack(int capacity) {
        top = null;
        this.capacity = capacity;
    }
    
    // Methods
    
    // returns true if the stack has no elements in it, false otherwise
    public boolean isEmpty() {
      return(top == null);
    }
    
    // returns true if the stack is at capacity, false otherwise
    public boolean isFull(){
      ListStack<T> temp = new ListStack<T>(this.capacity);
      int counter = 0;
      while(this.top != null){
        temp.push(this.pop());
        counter++;
      }
      while(temp.top != null){
        this.push(temp.pop());
      }
      return(counter == capacity);
    }
    
    // returns top element of the stack
    public T peek() {
      return top.info;
    }
    
    // removes and returns top element of the stack
    public T pop() {
      T saved = top.info;
      Elem<T> oldTop = top;
      top = top.next;
      oldTop.info = null;
      oldTop.next = null;
      return saved;
    }

    // adds an element to the end of the stack
    public void push( T info ) {
      if(!this.isFull()){
        top=new Elem<T>(info,top);
      }
    }

    // erases the contents of the stack
    public void clear()
    {
      while(top!=null){
        Elem<T> previousTop = top.next;
        top.info = null;
        top.next = null;
        top = previousTop;
      }
    }
    
    // returns the size (number of elements) of the stack
    public int size(){
      ListStack<T> temp = new ListStack<T>(this.capacity);
      int counter = 0;
      while(this.top != null){
        temp.push(this.pop());
        counter++;
      }
      while(temp.top != null){
        this.push(temp.pop());
      }
      return counter;
    }
    
    // returns a user-friendly version of the stack contents
    public String toString(){
      ListStack<T> temp = new ListStack<T>(this.capacity);
      String stackContents = "Stack Contents =";
      while(this.top != null){
        stackContents = stackContents + " " + this.peek();
        temp.push(this.pop());
      }
      while(temp.top != null){
        this.push(temp.pop());
      }
      return stackContents;
    }
    
    // reverses the order of the contents of the stack
    public void reverse(){
      ListStack<T> temp = new ListStack<T>(this.capacity);
      ListStack<T> erase = new ListStack<T>(this.capacity);
      while(this.top != null){
        temp.push(this.pop());
      }
      erase.top = this.top;
      this.top = temp.top;
      erase.clear();
    }
    
    // displays the contents of the stack
    public void display(){
      System.out.println(toString());
    }
}
