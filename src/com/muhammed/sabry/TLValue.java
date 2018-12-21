package com.muhammed.sabry;

import java.util.List;

public class TLValue implements Comparable<TLValue> {

    private static final TLValue NULL = new TLValue();
    static final TLValue VOID = new TLValue();

    private Object value;

    private TLValue() {
        // private constructor: only used for NULL and VOID
        value = new Object();
    }

    TLValue(Object v) {
        if(v == null) {
            throw new RuntimeException("v == null");
        }
        value = v;
        // only accept boolean, list, number or string types
        if(!(isBoolean() || isList() || isNumber() || isString())) {
            throw new RuntimeException("invalid data type: " + v + " (" + v.getClass() + ")");
        }
    }

    Boolean asBoolean() {
        return (Boolean)value;
    }

    Double asDouble() {
        return ((Number)value).doubleValue();
    }

    @SuppressWarnings("unchecked")
    List<TLValue> asList() {
        return (List<TLValue>)value;
    }

    String asString() {
        return (String)value;
    }

    @Override
    public int compareTo(TLValue that) {
        if(this.isNumber() && that.isNumber()) {
            if(this.equals(that)) {
                return 0;
            }
            else {
                return this.asDouble().compareTo(that.asDouble());
            }
        }
        else if(this.isString() && that.isString()) {
            return this.asString().compareTo(that.asString());
        }
        else {
            throw new RuntimeException("illegal expression: can't compare `" + this + "` to `" + that + "`");
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this == VOID || o == VOID) {
            throw new RuntimeException("can't use VOID: " + this + " ==/!= " + o);
        }
        if(this == o) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TLValue that = (TLValue)o;
        if(this.isNumber() && that.isNumber()) {
            double diff = Math.abs(this.asDouble() - that.asDouble());
            return diff < 0.00000000001;
        }
        else {
            return this.value.equals(that.value);
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    boolean isBoolean() {
        return value instanceof Boolean;
    }

    boolean isNumber() {
        return value instanceof Number;
    }

    boolean isList() {
        return value instanceof List<?>;
    }

    private boolean isNull() {
        return this == NULL;
    }

    private boolean isVoid() {
        return this == VOID;
    }

    public boolean isString() {
        return value instanceof String;
    }

    @Override
    public String toString() {
        return isNull() ? "NULL" : isVoid() ? "VOID" : String.valueOf(value);
    }
}
