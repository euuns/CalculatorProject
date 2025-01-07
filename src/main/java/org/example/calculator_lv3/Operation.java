package org.example.calculator_lv3;

// Enum에서 Generic을 사용하기 위한 interface
public interface Operation<T, U, R> {
    R apply(T a, U b);
}
