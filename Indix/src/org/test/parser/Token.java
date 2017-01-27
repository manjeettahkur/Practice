package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
abstract class Token {
    static final int DOLLAR = 8;
    static final int ATOM   = 7;
    static final int FALSE  = 6;
    static final int TRUE   = 5;
    static final int RPAREN = 4;
    static final int LPAREN = 3;
    static final int NEG    = 2;
    static final int CONJ   = 1;
    static final int DISJ   = 0;

    abstract int value();
    abstract public String toString();

}
