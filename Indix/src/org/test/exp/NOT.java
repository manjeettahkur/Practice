package org.test.exp;

import java.util.Vector;

/**
 * Created by laxminarayanvarma on 16/10/16.
 */
public class NOT extends Expression {
    private final Expression term;

    public NOT(Expression term) {
        this.term = term;
    }

    protected Expression getTerm() {
        return this.term;
    }

    public Expression toNegationNormalform()  {
        if (this.term instanceof AND ||
                this.term instanceof OR ||
                this.term instanceof NOT) {

            return this.term.neg().toNegationNormalform();

        } else if (this.term instanceof Literal) {
            return this;
        }
        return null;
    }

    public Expression nnfToConjuctionNormalForm()  {

        if (this.term instanceof Literal) {
            return this;
        }
        return null;
    }
    public Expression simplifyConjuctionNormalForm()  {
        if (this.term instanceof Literal) {
            return this;
        }
        return null;
    }

    protected Vector toClause() {
        Vector V = new Vector();
        V.addElement(this);
        return V;
    }

    protected Expression neg() {
        return this.term;
    }

    public String toString() {
        return "!" + term.toString();
    }
}
