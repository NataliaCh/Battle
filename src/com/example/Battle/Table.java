package com.example.Battle;

import java.util.Iterator;

public class Table {

    Object[][] array;

    public Table(int battleFieldSize) {
        this.array = new Object[battleFieldSize + 1][battleFieldSize + 1];

    }

    public void init() {
        for (int k = 0; k < array.length; k++) {
            for (int a = 0; a < array.length; a++) {
                array[k][a] = "_";
            }
        }
        addRowsNumeric();
        print();
    }

    void print() {
        int length = array.length;
        for (int rowIndex = 0; rowIndex < length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                System.out.print(array[rowIndex][columnIndex] + "|");
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
        for (Object f :array) {
                field += f.toString() + " ";
            }
        return field;

    }

    public void putShips() throws IndexOutOfBoundsException {

        for (int k = 0; k < 3; k++) {
            System.out.println("Enter number of row and number of column with whitespace between them");

            InputReader reader = InputReader.create();
            while (true) {
                try {
                    String[] mas = reader.readLine().split(" ");
                    int i = Integer.parseInt(mas[0]);
                    int j = Integer.parseInt(mas[1]);

                    Object[][] massiv = array;

                    if (i < array.length && j < array.length) {
                            //ne rabotaet proverka na kasaniya korablei drug k drugu
                        if (massiv[i + 1][j] != "S" && massiv[i - 1][j] != "S" && massiv[i][j + 1] != "S"
                                    && massiv[i][j - 1] != "S" && massiv[i][j] != "S") {
                                massiv[i][j] = "S";
                                print();
                                break;
                            } else System.out.println("isn't allowed");
                    } else System.out.println("Out of field");

                } catch (NumberFormatException ne) {
                    System.out.println("plz, check entered data");
                }
            }
        }
    }
}
