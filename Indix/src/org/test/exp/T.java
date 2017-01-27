package org.test.exp;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class T extends Literal {
    public static final T VALUE = new T();

    private T() {}
    protected boolean isNeg(Expression Expression) {
        return Expression == F.VALUE;
    }

    protected Expression neg() {
        return F.VALUE;
    }

    public String toString() {
        return "TRUE";
    }
}
