package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Atom extends Val {
    final String literal;

    final int value() {
        return Token.ATOM;
    }

    Atom(final String literal) {
        this.literal = literal;
    }

    public final String toString() {
        return "Atom(" + this.literal +")";
    }
}
