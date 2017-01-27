package org.test.main;

import org.test.exp.Expression;
import org.test.exp.T;
import org.test.parser.Parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Main {
    public static void main(String ar[]) throws IOException
    {
        Parser myParser;
        Expression expression;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check if tautology : ");
        String input = sc.nextLine();
        input = input.replaceAll("\\s","");

        myParser = new Parser(input);
        expression = myParser.getExpression();

        System.out.println("Input expression : "+ expression.toString());
        // Convert expression to negation normal form.
        expression = expression.toNegationNormalform();
        System.out.println("Negation normal formed Expression : "+ expression.toString());

        // Convert to conjuction normal form.
        expression = expression.nnfToConjuctionNormalForm();
        System.out.println("Conjuction normal formed Expression : "+expression.toString());

        // Simplify expression
        expression = expression.simplifyConjuctionNormalForm();
        System.out.println("Simplified expression : "+expression.toString());

        if(T.VALUE == expression)
             System.out.println("Given input is tautology");
        else
             System.out.println("Given input is not tautology");

    }
}
