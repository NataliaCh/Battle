package com.example.Battle;

import com.example.Battle.exception.LocationIsOutOfTheSeaException;
import com.example.Battle.exception.ShipCollisionException;

import java.lang.String;
import java.util.Arrays;

public class Table {

    public static final String EMPTY = "*";
    public static final String SHIP = "S";

    private String[][] array;

    public Table(int size) {
        this.array = new String[size][size];

        for (String[] each : array) Arrays.fill(each, EMPTY);
    }

    public void print() {
        new ArrayPrinter2D(array).print();
    }

    public Point checkPoint(Point point) throws LocationIsOutOfTheSeaException {
        if (!isInRange(point.row)) throw new LocationIsOutOfTheSeaException();
        if (!isInRange(point.column)) throw new LocationIsOutOfTheSeaException();
        return point;
    }

    private boolean isInRange(int location) {
        return location > 0 && location < array.length;
    }

    public String set(int row, int col) {
        if (isSet(row, col)) throw new ShipCollisionException();

        return array[row][col] = SHIP;
    }

    private boolean isSet(int row, int col) {
        return !array[row][col].equals(EMPTY);
    }
}

