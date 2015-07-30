package com.example.Battle;

import java.io.IOException;
import java.util.ArrayList;
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
        Table table = new Table(chooseSize());
        table.print();

        TableShipSetter tableShipSetter = new TableShipSetter(table);
        tableShipSetter.setShip();

        table.print();
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
