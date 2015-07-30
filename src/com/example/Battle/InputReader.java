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
            } catch (NumberFormatException e) {
                print("Expected int but was: '" + line + "'");
            }
        }
    }

    public String readLine() {
        while (true) {
            try {
                String line = input.readLine().trim();
                if (line.equals("exit")|| line.equals("q")|| line.equals("quit")) System.exit(0);
                return line;
            } catch (Exception e) {
                print("Unexpected error occurs: " + e.getLocalizedMessage());
            }
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
