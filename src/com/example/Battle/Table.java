package com.example.Battle;

import java.lang.String;
import java.util.Formatter;

public class Table {

    protected String[][] array;
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


    public String[][] numbersInit() {
        for (int i = 0; i < numberedArray.length; i++) {
            for (int j = 0; j < numberedArray.length; j++) {
                numberedArray[i][0] = String.valueOf(i);
                numberedArray[0][j] = String.valueOf(j);
            }
        }
        return numberedArray;
    }

    public void print() {

        for (int i = 0; i < numberedArray.length; i++) {
            for (int j = 0; j < numberedArray.length; j++) {
                System.out.printf("%-3s", (i == 0 || j == 0 ? numberedArray[i][j] : array[i - 1][j - 1]));
            }
            System.out.println();
        }
    }

    public String[][] arrayInit() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                String element = array[i][j];
                array[i][j] = (element == null) ? "*" : element;
            }
        }
        return array;
    }


    }

    /*private String[] replaceNulls(String[] nested, String value) {
        String[] newArray = new String[nested.length];
        for (int index = 0; index < nested.length; index++) {
            String element = nested[index];
            newArray[index] = (element == null) ? value : element;
        }
        return newArray;
    }*/

