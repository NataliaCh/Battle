package com.example.Battle;

public class ArrayPrinter2D {

    private final String[][] array;

    public ArrayPrinter2D(String[][] array) {
        this.array = array;
    }

    public void print() {
        for (int row = 0; row < array.length + 1; row++) {
            for (int column = 0; column < array.length + 1; column++) {
                System.out.printf("%-3s", (row == 0 || column == 0 ? location(row, column) : array[row - 1][column - 1]));
            }
            System.out.println();
        }
    }

    private String location(int row, int column) {
        if (row == 0 && column == 0)
            return "0";
        else if (row == 0)
            return String.valueOf(column);
        else if (column == 0)
            return String.valueOf(row);
        else
            return "incorrect";
    }
}
