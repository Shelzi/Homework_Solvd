package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.util;


public enum RoundMethod {
    FLOOR {
        double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    CEIL {
        double roundFunction(double d) {
            return Math.ceil(d);
        }
    },
    ROUND {
        double roundFunction(double d) {
            return Math.round(d);
        }
    };

    abstract double roundFunction(double d);

    public int round(double roundedValue, int d) {
        int tenPow = pow10(d);
        return (int) roundFunction(roundedValue / tenPow) * tenPow;
    }

    private static int pow10(int d) {
        int n = 10;
        if (d == 0) {
            n = 1;
        }
        while (d > 1) {
            n *= 10;
            d--;
        }
        return n;
    }
}