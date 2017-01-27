package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Conj extends Token {
    final int value() {
        return Token.CONJ;
    }

    public final String toString() {
        return "CONJ";
    }
}
