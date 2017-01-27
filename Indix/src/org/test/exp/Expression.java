package org.test.exp;

import java.util.Vector;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public abstract class Expression {
    abstract public Expression toNegationNormalform();
    abstract public Expression nnfToConjuctionNormalForm();
    public Expression simplifyConjuctionNormalForm()  {
        return (new AND(this, T.VALUE)).simplifyConjuctionNormalForm();
    }
    abstract protected Expression neg();
    abstract protected Vector toClause() ;;
    abstract public String toString();
}
