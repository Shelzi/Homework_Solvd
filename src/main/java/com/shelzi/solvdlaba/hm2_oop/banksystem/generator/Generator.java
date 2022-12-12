package com.shelzi.solvdlaba.hm2_oop.banksystem.generator;

import java.util.Set;

public interface Generator<T> {
    Set<T> generate(int amount);
}