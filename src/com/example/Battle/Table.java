package com.example.Battle;

public class Table {

    private final String[][] array;
    private final String template;
    private final int size;

    public Table(int size) {
        this.size = size;
        this.template = createTemplate(size);
        this.array = new String[size][size];


    }

    private String createTemplate(int size) {
        StringBuilder b = new StringBuilder(size * 4 + 2);
        for (int step = 0; step < size+1; step++) b.append("%-3s");
        b.append("\n");
        return b.toString();
    }

    public void print() {
        String [][] numberedArray = new String[size+1][size+1];
        for (int i = 0; i<numberedArray.length; i++) {
            for (int j = 0; j < numberedArray.length; j++) {
                numberedArray[i][0] = String.valueOf(i);
                numberedArray[0][j] = String.valueOf(j);
            }
        }
            System.arraycopy(array, 0, numberedArray, 1, array.length);
        for (String[] nested : numberedArray) System.out.printf(template, replaceNulls(nested, "*"));
    }

    public void setShip(int row, int column) {
        if (row < 0 || column < 0) throw new IllegalArgumentException("Too small");
        if (row > size - 1 || column > size - 1) throw new IllegalArgumentException("Too big");

        System.out.println("Ok");
    }

    private String[] replaceNulls(String[] nested, String value) {
        String[] newArray = new String[nested.length];
        for (int index = 0; index < nested.length; index++) {
            String element = nested[index];
            newArray[index] = (element == null) ? value : element;
        }
        return newArray;
    }
}
