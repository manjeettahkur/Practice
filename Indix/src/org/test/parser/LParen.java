package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class LParen extends Token {
    final int value() {
        return Token.LPAREN;
    }

    public final String toString() {
        return "(";
    }
}
