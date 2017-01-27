package org.test.exp;

import java.util.Vector;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
abstract class Literal extends Expression {
    public Expression toNegationNormalform() {
        return this;
    }

    public Expression nnfToConjuctionNormalForm() {
        return this;
    }

    public Expression simplifyConjuctionNormalForm() {
        return this;
    }

    protected Vector toClause() {
        Vector V = new Vector();
        V.addElement(this);
        return V;
    }

    abstract protected boolean isNeg(Expression Expression);
}
