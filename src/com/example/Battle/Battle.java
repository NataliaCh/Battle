package com.example.Battle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Battle {

    private static final List<Integer> AVAILABLE_SIZES = new ArrayList<Integer>() {
        {

            add(3);
            add(4);
            add(5);
        }
    };

    public static void main(String[] args) throws IOException {
        int size = chooseSize();

        Table table = new Table(size);
        AutoTable autotable = new AutoTable(size);

        table.init();
        print("");
        autotable.init();

        table.putShips();
        print("");
        autotable.autoPutShips(size);


        List<String> listField = transformIntoList(table);
        InputReader reader = InputReader.create();


    }

    private static List<String> transformIntoList(Table table) {
        String field = table.toString();

        String[] masfield = field.split(" ");
        /*for (String s:listField) {
            System.out.print(s);
        }*/
        return Arrays.asList(masfield);
    }

    public static int chooseSize() throws IOException {
        print(generateMessage(AVAILABLE_SIZES));

        InputReader reader = InputReader.create();
        while (true) {
            int size = reader.readInt();
            if (AVAILABLE_SIZES.contains(size)) {
                return size;
            } else {
                print("Invalid value");
            }
        }
    }

    private static String generateMessage(List<Integer> availableSizes) {
        String msg = "";

        Iterator<Integer> itr = availableSizes.iterator();
        while (itr.hasNext()) {
            msg += itr.next().toString();

            if (itr.hasNext()) {
                msg += ",";
            }
        }

        return "Choose battleField size (" + msg + "):";
    }

    public static void print(String text) {
        System.out.println(text);
    }


}
