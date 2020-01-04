package stack;

import java.util.Stack;

/**
 * @author badrikant.soni
 */
public class ValidParanthesesE {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }else if(ch==')'&&!stack.isEmpty()&&stack.peek()=='('){
                stack.pop();
            }else if(ch==']'&&!stack.isEmpty()&&stack.peek()=='['){
                stack.pop();
            }else if(ch=='}'&&!stack.isEmpty()&&stack.peek()=='{'){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ValidParanthesesE validParanthesesE = new ValidParanthesesE();
        System.out.println(validParanthesesE.isValid("](([]))"));
    }
}
