package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class True extends Val {
    final int value() {
        return Token.TRUE;
    }

    public final String toString() {
        return "TRUE";
    }
}
