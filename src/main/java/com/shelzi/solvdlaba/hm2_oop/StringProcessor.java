package com.shelzi.solvdlaba.hm2_oop;

@FunctionalInterface
public interface StringProcessor<T extends String> {
    T process(T t);
}