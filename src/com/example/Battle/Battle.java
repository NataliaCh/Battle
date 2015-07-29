package com.example.Battle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Battle {

    private static final List<Integer> AVAILABLE_SIZES = new ArrayList<Integer>() {
        {

            add(5);
            add(7);
            add(10);
        }
    };

    public static void main(String[] args) throws IOException {
        int size = chooseSize();

        Table table = new Table(size);
        table.numbersInit();
        String[][] sea = table.arrayInit();
        table.print();

        ShipSetter shipSetter = new ShipSetter(sea);
        table.array = shipSetter.setShip();
        table.print();

        print("make a shot");
        InputReader reader = new InputReader();
        int target = reader.readInt();


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
