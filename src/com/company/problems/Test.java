package com.company.problems;

public class Test {
    public static void isTrue(boolean value) {
        if (!value) {
            throw new RuntimeException(getMessage(true, false));
        }
        printSuccess();
    }

    public static void isFalse(boolean value) {
        if (value) {
            throw new RuntimeException(getMessage(false, true));
        }
        printSuccess();
    }

    public static <T> void equals(T actual, T expected) {
        if (expected == null && actual == null) {
            printSuccess();
            return;
        }
        if (expected == null || actual == null) {
            throw new RuntimeException(getMessage(expected, actual));
        }
        if (!expected.equals(actual)) {
            throw new RuntimeException(getMessage(expected, actual));
        }
        printSuccess();
    }

    private static void printSuccess() {
        System.out.println("Success");
    }

    private static <T> String getMessage(T expected, T actual) {
        return "Expected: " + expected + ", actual: " + actual;
    }
}
