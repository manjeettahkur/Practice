package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Disj extends Token {
    final int value() {
        return Token.DISJ;
    }

    public final String toString() {
        return "DISJ";
    }
}
