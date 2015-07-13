package com.example.Battle;

import java.util.Random;

public class AutoTable extends Table {
    public AutoTable(int battleFieldSize) {
        super(battleFieldSize);
    }

    public void autoPutShips(int battleFieldSize) {

        while (true)

            for (int k = 0; k < 3; k++) {
                try {
                    Random random = new Random();

                    int horNumb = random.nextInt(battleFieldSize + 1);

                    int verNumb = random.nextInt(battleFieldSize + 1);


                    array[horNumb][verNumb] = 9;

                    print();

                } catch (NumberFormatException ne) {
                }
            }

    }
}
