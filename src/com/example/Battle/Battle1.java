package com.example.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Battle1 {

    static class Table {

        private final int width;
        private final int height;
        private final int[][] array;

        public Table(int battleFieldSize) {
            this.width = battleFieldSize;
            this.height = battleFieldSize;
            this.array = new int[battleFieldSize][battleFieldSize];
        }

        public boolean shoot(int column, int row) {
            int value = array[column][row];
            return value == 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Table)) return false;

            Table table = (Table) o;

            if (height != table.height) return false;
            if (width != table.width) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = width;
            result = 31 * result + height;
            return result;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "width=" + width +
                    ", height=" + height +
                    ", array=" + Arrays.deepToString(array) +
                    '}';
        }

        public void prepareShips() {

        }

        public boolean hasShips() {
            return true;
        }
    }

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Table table = new Table(3);
        table.prepareShips();

        while (table.hasShips()) {
            try {
                System.out.println("column ");
                int column = Integer.parseInt(reader.readLine());

                System.out.println("row ");
                int row = Integer.parseInt(reader.readLine());

                if (table.shoot(column, row)) {
                    System.out.println("Luck");
                } else {
                    System.out.println("Miss");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game is over");
    }
}
