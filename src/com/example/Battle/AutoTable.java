package com.example.Battle;

import java.util.Random;

public class AutoTable extends Table {
    public AutoTable(int battleFieldSize) {
        super(battleFieldSize);
    }

    public void autoPutShips(int battleFieldSize) {


        for (int k = 0; k < 3; k++) {
            while (true)
                try {
                    Random random = new Random();

                    int horNumb = random.nextInt(battleFieldSize) + 1;
                    int verNumb = random.nextInt(battleFieldSize) + 1;
                    break;

                } catch (NumberFormatException ne) {
                }
        }
        print();

    }
}
