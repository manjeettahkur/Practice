package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Neg extends Token {
    final int value() {
        return Token.NEG;
    }

    public final String toString() {
        return "NEG";
    }
}
