package com.example.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class Battle {

    public static void main(String[] args) throws IOException {

        print("Choose field size (3, 4 or 5):");
        int size = Integer.parseInt(input.readLine());
        Table table = new Table(size);
        table.InitArray();
        //  Table table = new table3[][];

        shipPlacement();

    }

    private static void shipPlacement() throws IOException {
        for (int i = 0; i < 3; i++) {
            print("Put your ships. Choose the row(1,2 or 3):");
            int row = Integer.parseInt(input.readLine());
            int shiprow = row+1;
            print("Choose column(1,2 or 3):");
            int column = Integer.parseInt(input.readLine());
            int shipcolumn = column+1;
            String ship = "X";
            //table [shiprow][column]= ship;
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
}
