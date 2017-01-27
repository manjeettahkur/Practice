package org.test.exp;

import java.util.Vector;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class AND extends Expression {
    private final Expression left;
    private final Expression right;

    public AND(Expression left, Expression right) {
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
        return new AND(this.left.toNegationNormalform(), this.right.toNegationNormalform());
    }

    public Expression nnfToConjuctionNormalForm()  {
        return new AND(this.left.nnfToConjuctionNormalForm(), this.right.nnfToConjuctionNormalForm());
    }
    public Expression simplifyConjuctionNormalForm() {
        Vector clausal = this.toClause();

        // A particular clause will be TRUE if it contain literal and its negation.
        for (int i = 0; i < clausal.size(); i++) {
            Vector currentOR = (Vector)clausal.elementAt(i);
            loop: for (int j = 0; j < currentOR.size(); j++) {
                if (currentOR.elementAt(j) instanceof Literal) {
                    Literal jthElement = (Literal)currentOR.elementAt(j);
                    for (int k = 0; k < currentOR.size(); k++) {
                        Expression kthElement = (Expression)currentOR.elementAt(k);
                        if (jthElement.isNeg(kthElement)) {
                            clausal.removeElementAt(i--);
                            break loop;
                        }
                    }
                }
            }
        }
        Expression result = F.VALUE;
        if(clausal.size() == 0)
            result = T.VALUE;
        return result;
    }

    protected Vector toClause()  {
        Vector clause  = new Vector();
        Vector c_left;
        Vector c_right;

        if (this.left instanceof AND) {
            c_left = this.left.toClause();
            for (int i = 0; i < c_left.size(); i++) {
                clause.addElement(c_left.elementAt(i));
            }
        } else {
            c_left = this.left.toClause();
            clause.addElement(c_left);
        }

        if (this.right instanceof AND) {
            c_right = this.right.toClause();
            for (int i = 0; i < c_right.size(); i++) {
                clause.addElement(c_right.elementAt(i));
            }
        } else {
            c_right = this.right.toClause();
            clause.addElement(c_right);
        }
        return clause;
    }

    protected Expression neg() {
        return new OR(this.left.neg(), this.right.neg());
    }
    public String toString() {
        return ("(" + this.left.toString() + " & "
                + this.right.toString() + ")");
    }
}
