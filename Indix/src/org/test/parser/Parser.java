package org.test.parser;

import org.test.exp.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Parser {
    private static StringReader input;
    private static Expression expression = null;

    private static Token token = new Dollar();
    private static boolean isEof = false;

    private static Stack operator_stack  = new Stack();
    private static Stack value_stack  = new Stack();

    private static final int S = 0;
    private static final int R = 1;
    private static final int E1 = 2;
    private static final int E2 = 3;
    private static final int E3 = 4;
    private static final int E4 = 5;

    private static final int[][] o_p_table = {
        /*  ----------------------input token--------------------- */
        /*  -op_stk-    OR  AND NOT (   )   Val Val Val  $  */
        /*  ----------------------input token--------------------- */
        /*      OR */{   R,  S,  S,  S,  R,  S,  S,  S,  R },
        /*     AND */{   R,  R,  S,  S,  R,  S,  S,  S,  R },
        /*     NOT */{   R,  R,  S,  S,  R,  S,  S,  S,  R },
        /*       ( */{   S,  S,  S,  S,  S,  S,  S,  S,  E1},
        /*       ) */{   R,  R,  R,  E4, R,  S,  S,  S,  R },
        /*         */{ /* Vals aren't held on the operator_stack but */},
        /*         */{ /* blank lines here mean we can look up */},
        /*         */{ /* Token.DOLLAR tokens correctly.       */},
        /*       $ */{  S,  S,  S,  S,  E2, S,  S,  S,  E3},
    };

    public Parser(String input) throws IOException {
        this.input = new StringReader(input);
        operator_stack.push(new Dollar());
        expression = parse();
    }

    public Expression getExpression() {
        return expression;
    }

    public Expression parse() throws IOException {
        token = nextToken();
        while (true) {
            if (token.value() == Token.DOLLAR &&
                    ((Token)operator_stack.peek()).value() == Token.DOLLAR) {
                return (Expression)value_stack.pop();
            }
            switch(o_p_table[((Token)operator_stack.peek()).value()][token.value()]) {
                case S :
                    shift();
                    token = nextToken();
                    break;
                case R :
                    reduce();
                    break;
                default :
                    break;
            }
        }
    }
    public  void shift() {
        if (token instanceof Val) {
            if (token.value() == Token.ATOM) {
                value_stack.push(new Variable(((Atom)token).literal));  //Token value (True, False or Atom)
            }
        } else {
            operator_stack.push(token); //Token value:    &, |, !, (, ), $
        }
        return;
    }
    public  void reduce() {
        switch (((Token)operator_stack.pop()).value()) {
            case Token.NEG :
                value_stack.push(new NOT((Expression)value_stack.pop()));
                break;
            case Token.RPAREN :
                operator_stack.pop(); // Pop an LParen
                break;
            case Token.CONJ :
            {
                Expression temp = (Expression)value_stack.pop();
                value_stack.push(new AND((Expression)value_stack.pop(), temp));
            }
            break;
            case Token.DISJ :
            {
                Expression temp = (Expression)value_stack.pop();
                value_stack.push(new OR((Expression)value_stack.pop(), temp));
            }
            default:
                break;
        }
        return;
    }
    
    public Token nextToken() throws IOException {
        int next_char = input.read();
        if(next_char == -1)
            isEof = true;
        
        if (isEof)
            return new Dollar();
        String tokenString = Character.toString((char)next_char);
        if (tokenString.equals("(")) {
            return new LParen();
        } else if (tokenString.equals(")")) {
            return new RParen();
        } else if (tokenString.equals("!")) {
            return new Neg();
        } else if (tokenString.equals("&")) {
            return new Conj();
        } else if (tokenString.equals("|")) {
            return new Disj();
        } else {
            return new Atom(tokenString);
        }
        
    }
}
