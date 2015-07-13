package com.example.Battle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader {

    private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static InputReader create(){
        return new InputReader();
    }

    public int readInt() {
        while (true) {
            String line = readLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (Exception e) {
                print("Expected int but was: '" + line + "'");
            }
        }
    }

    public String readLine() {
        while (true) {
            try {
                return input.readLine();
            } catch (Exception e) {
                print("Unexpected error occurs: " + e.getLocalizedMessage());
            }
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
