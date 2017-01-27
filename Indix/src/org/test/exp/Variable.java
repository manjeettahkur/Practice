package org.test.exp;

/**
 * Created by laxminarayanvarma on 16/10/16.
 */
public class Variable extends Literal {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    protected boolean isNeg(Expression Expression) {
        if (Expression instanceof NOT) {
            Expression term = ((NOT)Expression).getTerm();
            if (term instanceof Variable) {
                return ((Variable)term).getName().equals(this.name);
            }
        }
        return false;
    }

    protected Expression neg() {
        return new NOT(this);
    }

    public String toString() {
        return this.name;
    }
}
