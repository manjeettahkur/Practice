package org.test.parser;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class False extends Val {
    final int value() {
        return Token.FALSE;
    }

    public final String toString() {
        return "FALSE";
    }

}
