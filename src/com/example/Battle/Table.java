package com.example.Battle;

import java.util.ArrayList;
import java.util.List;

public class Table {

    int[][] array;

    public Table(int battleFieldSize) {
        this.array = new int[battleFieldSize + 1][battleFieldSize + 1];
    }

    public void init() {
        addRowsNumeric();

        print();
    }

    void print() {
        int length = array.length;
        for (int rowIndex = 0; rowIndex < length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                System.out.print(array[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }

    private void addRowsNumeric() {
        for (int i = 0; i < array.length; i++) {
            array[0][i] = i;
            array[i][0] = i;
        }
    }

    public String toString() {
        String field = "";
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < array.length; columnIndex++) {
                field += (array[rowIndex][columnIndex] + " ");
            }
        }
        return field;

    }

    public void putShips() {

        while (true) {
            try {
                for (int k = 0; k < 3; k++) {
                    System.out.println("Enter number of row and number of column with whitespace between them");

                    InputReader reader = InputReader.create();
                    String[] mas = reader.readLine().split(" ");
                    int i = Integer.parseInt(mas[0]);
                    int j = Integer.parseInt(mas[1]);

                    if (i < array.length && j < array.length) {
                        array[i][j] = 9;
                        print();
                    } else System.out.println("Out of field");
                }
            } catch (NumberFormatException ne) {
                System.out.println("plz, check entered data");
            }
        }
    }
}
