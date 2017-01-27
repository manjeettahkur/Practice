package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class RParen extends Token {
    final int value() {
        return Token.RPAREN;
    }

    public final String toString() {
        return ")";
    }
}
