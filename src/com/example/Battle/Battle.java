package com.example.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = readInt("Выбери размер поля (3, 4 или 5):");

        Table table = new Table(size);
        table.shipPlacement();
        table.printContent();
    }

    private static int readInt(String message) throws IOException {
        print(message);
        return Integer.parseInt(input.readLine());
    }

    static class Table {

        private int[][] array;

        public Table(int capacity) {
            this.array = new int[capacity][capacity];
        }

        public void printContent() {
            for (int[] one : array) {
                for (int second : one) {
                    System.out.print(second + " ");
                }
                System.out.println();
            }
        }

        private void shipPlacement() throws IOException {
            for (int i = 0; i < 3; i++) {
                printContent();

                int row = readInt("Расставь свои корабли. Выбери ряд(1,2 или 3):");
                int column = readInt("Выбери столбец(1,2 или 3):");

                row -= 1;
                column -= 1;

                markShip(row, column);
            }
        }

        public void markShip(int row, int column) {
            array[row][column] = 1;
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }
}

 