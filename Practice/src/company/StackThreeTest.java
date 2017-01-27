package company;

import java.util.Stack;

/**
 * Created by laxminarayanvarma on 3/1/17.
 */
public class StackThreeTest {
    public static boolean checkBalance(String si){

        char c[] = si.toCharArray();
        Stack<Character> s = new Stack<>();
        int count =0;

        for(char ch: c){
            if(ch=='(' || ch=='{' || ch== '['){
                s.push(ch);
                count++;
            }
            else if(ch==')'){
                if (s.peek()=='('){
                    s.pop();
                    count--;
                }
                else
                    return false;
            }
            else if(ch=='}'){
                if (s.peek()=='{'){
                    s.pop();
                    count--;
                }
                else
                    return false;
            }
            else if(ch==']'){
                if (s.peek()=='['){
                    s.pop();
                    count--;
                }
                else
                    return false;
            }
            else
                System.exit(1);
        }
        if(count==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        String s = "[(])";

        System.out.println(checkBalance(s));

    }
}
