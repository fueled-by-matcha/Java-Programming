//Author: Lauren Johnson
//Assignment 2
//Part 2
//Utility class used to represent a calculator that converts infix to postfix
public class MyCalculator{
    //methods
    /*Method uses ArrayStack methods to determine if an infix expression is balanced
    */
    public static boolean isBalanced(String expression){
        ArrayStack<Character> a;//used to store operators and brackets
        a = new ArrayStack <Character> (expression.length());
        char c;//scan through expression
        for ( int i=0; i<expression.length(); i++ ) {
            c = expression.charAt(i);
            if (c == '{' ){
                a.push('}');
            }
            else if (c == '('){
                a.push(')');
            }
            else if(c == '['){
                a.push(']');
            }
            else if(c == '<'){
                a.push('>');
            }
            //checking for opposite brackets
            else if (c == ']') {
				if (a.isEmpty())
					return false;
				if (a.pop() != ']')
					return false;
            } 
            else if (c == ')') {
				if (a.isEmpty())
					return false;
				if (a.pop() != ')')
					return false;
            } 
            else if (c == '}') {
				if (a.isEmpty())
					return false;
				if (a.pop() != '}')
					return false;
            }
            else if(c == '>'){
                if(a.isEmpty())
                    return false;
                if(a.pop() != '>')
                    return false;
            }
        }
        return a.isEmpty();
    }
    /*Method converts infix to post fix using ArrayStack operations
    */
    public static String infixToPostfix(String infix){
        String s;//stores postfix
        s = "";
        char c;//used to scan characters
        ArrayStack<Character> storage;//used to store operators
        storage = new ArrayStack<Character>(infix.length());
        for(int i = 0; i<infix.length();i++){
            c = infix.charAt(i);
            //add numbers to string
            if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                s = s+c;
            }
            //add operators to storage
            else if(c=='*' || c=='/' || c=='+' || c=='-'){
                storage.push(c);
            }
            //add opening brackets to storage
            else if(c=='<' || c=='[' || c=='{' || c=='('){
                storage.push(c);
            }
            //pop out values of storage to output until opening bracket found;
            else if(c=='>'){
                while(storage.peek()!='<'){
                    s = s+storage.pop();
                }
                storage.pop();
            }
            else if(c==']'){
                while(storage.peek()!='['){
                    s = s+storage.pop();
                }
                storage.pop();
            }
            else if(c=='}'){
                while(storage.peek()!='{'){
                    s = s+storage.pop();
                }
                storage.pop();
            }
            else if(c==')'){
                while(storage.peek()!='('){
                    s = s+storage.pop();
                }
                storage.pop();
            }
        }
        while(!storage.isEmpty()){
            s = s+storage.pop().toString();
        }
        return s;
    }
    /*Method evaluates a postfix expression using ArrayStack operations
    */
    public static double evaluate(String postfix){
        ArrayStack<String> stack;//store evaluated parts of postfix
        stack = new ArrayStack<String>(postfix.length());
        char c;
        double placeholder;//used to hold calculated values
        double left;//left side of operand
        double right;//right side of operand
        double result;//final answer
        for(int i = 0; i<postfix.length(); i++){
            c = postfix.charAt(i);
            //push numbers to stack
            if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                stack.push(Character.toString(c));
            }
            //evaluate with operands, pop values into left and right side, push value back
            else if(c=='+'){
                left = Double.parseDouble(stack.pop());
                right = Double.parseDouble(stack.pop());
                placeholder = left + right;
                stack.push(Double.toString(placeholder));
            }
            else if(c=='-'){
                left = Double.parseDouble(stack.pop());
                right = Double.parseDouble(stack.pop());
                placeholder = right - left;
                stack.push(Double.toString(placeholder));
            }
            else if(c=='*'){
                left = Double.parseDouble(stack.pop());
                right = Double.parseDouble(stack.pop());
                placeholder = left * right;
                stack.push(Double.toString(placeholder));
            }
            else if(c=='/'){
                left = Double.parseDouble(stack.pop());
                right = Double.parseDouble(stack.pop());
                placeholder = right/left;
                stack.push(Double.toString(placeholder));
            }
        }
        result = Double.parseDouble(stack.pop());
        return result;
    }
}
