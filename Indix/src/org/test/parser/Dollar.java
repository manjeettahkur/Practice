package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Dollar extends Token {
    final int value() {
        return Token.DOLLAR;
    }

    public final String toString() {
        return "$";
    }
}
