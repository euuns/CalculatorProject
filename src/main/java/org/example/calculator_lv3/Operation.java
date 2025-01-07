package org.example.calculator_lv3;

// Enum에서 Generic을 사용하기 위한 interface
public interface Operation<T> {
    T apply(T a, T b);
}
