package com.example.Battle;

import java.util.Formatter;

public class Table {

    private final String[][] array;
    private String[][] numberedArray;
   // private final String template;
    private int size;

    public Table(int size) {
        this.size = size;
       // this.template = createTemplate(size);
        this.array = new String[size][size];
        this.numberedArray = new String[size + 1][size + 1];

    }

     private String createTemplate(int size) {
        StringBuilder b = new StringBuilder(size * 4 + 2);

        for (int step = 0; step < size + 1; step++)
        b.append("%-3s");
        b.append("\n");
        return b.toString();
    }


    public String[][] initArray() {
        for (int i = 0; i < numberedArray.length; i++) {
            for (int j = 0; j < numberedArray.length; j++) {
                numberedArray[i][0] = String.valueOf(i);
                numberedArray[0][j] = String.valueOf(j);
            }
        }
        return numberedArray;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                String element = array[i][j];
                array[i][j] = (element == null) ? "*" : element;
            }
        }
        for (int i = 0; i < numberedArray.length; i++) {
            for (int j = 0; j < numberedArray.length; j++) {
                System.out.printf("%-3s", (i == 0 || j == 0 ? numberedArray[i][j] : array[i - 1][j - 1]));

            }
            System.out.println();
        }
    }

    public void setShip(int row, int column) {
        if (row < 0 || column < 0) throw new IllegalArgumentException("Too small");
        if (row > size - 1 || column > size - 1) throw new IllegalArgumentException("Too big");

        System.out.println("Ok");
    }

    /*private String[] replaceNulls(String[] nested, String value) {
        String[] newArray = new String[nested.length];
        for (int index = 0; index < nested.length; index++) {
            String element = nested[index];
            newArray[index] = (element == null) ? value : element;
        }
        return newArray;
    }*/
}
