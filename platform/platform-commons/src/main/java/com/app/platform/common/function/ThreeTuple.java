package com.app.platform.common.function;

import java.util.Objects;

public class ThreeTuple<T, U, O> {
    public final T _1;
    public final U _2;
    public final O _3;

    public ThreeTuple(T _1, U _2, O _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ThreeTuple)) {
            return false;
        }
        ThreeTuple<?, ?, ?> that = (ThreeTuple<?, ?, ?>) o;
        return _1.equals(that._1) && _2.equals(that._2) && _3.equals(that._3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3);
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                '}';
    }
}
