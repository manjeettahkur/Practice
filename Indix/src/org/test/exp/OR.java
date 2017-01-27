package org.test.exp;

import java.util.Vector;

/**
 * Created by laxminarayanvarma on 16/10/16.
 */
public class OR extends Expression {
    private final Expression left;
    private final Expression right;

    public OR(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    protected Expression getLeft() {
        return this.left;
    }

    protected Expression getRight() {
        return this.right;
    }

    public Expression toNegationNormalform()  {
        return new OR(this.left.toNegationNormalform(), this.right.toNegationNormalform());
    }
    public Expression nnfToConjuctionNormalForm()  {
        Expression left = this.left.nnfToConjuctionNormalForm();
        Expression right = this.right.nnfToConjuctionNormalForm();

        if (left instanceof AND) {
            AND conj = (AND)left;
            return new AND(new OR(conj.getLeft(), right).nnfToConjuctionNormalForm(),
                    new OR(conj.getRight(), right).nnfToConjuctionNormalForm());
        }
        else if (right instanceof AND) {
            AND conj = (AND)right;
            return new AND(new OR(left, conj.getLeft()).nnfToConjuctionNormalForm(),
                    new OR(left, conj.getRight()).nnfToConjuctionNormalForm());
        }
        return new OR(left, right);
    }

    protected Vector toClause() {
        Vector clause  = new Vector();
        Vector c_left  = this.left.toClause();
        Vector c_right = this.right.toClause();

        for (int i = 0; i < c_left.size(); i++) {
            clause.addElement(c_left.elementAt(i));
        }

        for (int i = 0; i < c_right.size(); i++) {
            clause.addElement(c_right.elementAt(i));
        }

        return clause;
    }
    protected Expression neg() {
        return new AND(this.left.neg(), this.right.neg());
    }

    public String toString() {
        return ("(" + this.left.toString() + " | "
                + this.right.toString() + ")");
    }
}
