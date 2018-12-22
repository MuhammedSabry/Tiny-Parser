package com.muhammed.sabry;

public interface ExpressionNode {
    Expression getType();

    String getValue();

    void setValue(String value);

    String toString();

    enum Expression {
        OP, ASSIGN, WRITE, READ, REPEAT, NUMBER, BRACKETS, EQUALS
    }
}
