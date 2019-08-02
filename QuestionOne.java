//Authors: Lauren Johnson, Liam Waddell
//Student numbers: 300016250, 300021290
//Assignment 2
//Part 1
//Utility class used to test ArrayStack and ListStack implementation
public class QuestionOne{
    public static void main(String[] args){
        ArrayStack<Integer> a;
        ListStack<Integer> l;

        a = new ArrayStack<Integer>(20);
        l = new ListStack<Integer>(20);
        int i;
        for(i=1; i<21; i++){
            a.push(i);
        }
        for(i = 1; i<21; i++){
          l.push(i);
        }
        System.out.println("Test ArrayStack");
        a.display();
        a.reverse();
        a.display();
        System.out.println(a.peek());
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.reverse();
        System.out.println(a.size());
        System.out.println(a.isFull());
        System.out.println(a.isEmpty());
        a.display();
        a.clear();
        a.display();
        System.out.println(a.isEmpty());
        System.out.println("Test ListStack");
        l.display();
        l.reverse();
        l.display();
        System.out.println(l.peek());
        System.out.println(l.pop());
        System.out.println(l.pop());
        l.reverse();
        System.out.println(l.size());
        System.out.println(l.isFull());
        System.out.println(l.isEmpty());
        l.display();
        l.clear();
        l.display();
        System.out.println(l.isEmpty());
    }
}