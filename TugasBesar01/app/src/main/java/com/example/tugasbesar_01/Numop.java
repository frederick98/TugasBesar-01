package com.example.tugasbesar_01;

public class Numop {
    protected String operator;
    protected int value;

    public Numop(String operator, int value) {
        this.operator = operator;
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
