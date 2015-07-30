package com.example.Battle;

import com.example.Battle.exception.IncorrectDirectionException;

public enum Direction {
    VERTICAL, HORIZONTAL;

    public static Direction of(String s) throws IncorrectDirectionException {
        String maybeDirection = s.trim();
        if (maybeDirection.equalsIgnoreCase("v")) {
            return VERTICAL;
        } else if (maybeDirection.equalsIgnoreCase("h")) {
            return HORIZONTAL;
        } else {
            throw new IncorrectDirectionException();
        }
    }
}