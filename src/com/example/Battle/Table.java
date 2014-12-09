package com.example.Battle;

public class Table {
    int width;
    int height;
    public int[][] array;

    public Table(int battleFieldSize) {
        this.width = battleFieldSize;
        this.height = battleFieldSize;
        this.array = new int[battleFieldSize + 1][battleFieldSize + 1];
    }

    public void InitArray() {
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            int n = i;
            array[i][j] = n++;
        }

        for (int j = 0; j < array.length; j++) {
            int i = 0;
            int n = j;
            array[i][j] = n++;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
