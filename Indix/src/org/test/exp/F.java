package org.test.exp;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class F extends Literal {
    public static final F VALUE = new F();

    private F() {}

    protected boolean isNeg(Expression Expression) {
        return Expression == T.VALUE;
    }

    protected Expression neg() {
        return T.VALUE;
    }

    public String toString() {
        return "FALSE";
    }
}
