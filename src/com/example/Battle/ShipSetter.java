package com.example.Battle;

import static com.example.Battle.Battle.print;

public class ShipSetter {
    InputReader reader = new InputReader();
    String[][] arrayForShips;
    int size;

    ShipSetter(String[][] array, int size) {
        this.arrayForShips = array;
        this.size = size;
    }

    public String[][] setShip() {
        while (true) {
            for (int count = 0; count < 3; count++) {
                print("enter number of blocks");
                int blocks = reader.readInt();
                print("enter x");
                int row = reader.readInt();
                boolean checkRow = checkFit(row, arrayForShips);
                print("enter y");
                int column = reader.readInt();
                boolean checkColumn = checkFit(column, arrayForShips);

                if (checkColumn & checkRow) {
                    if (blocks > 1) {
                        int rowBlock = row - 1;
                        for (int b = 0; b < blocks; b++) {
                            arrayForShips[rowBlock][column - 1] = "S";
                            ++rowBlock;
                        }
                    } else arrayForShips[row - 1][column - 1] = "S";
                }
            }
            return arrayForShips;
        }
    }

    public boolean checkFit(int enteredNum, String[][] array) {
        boolean inSea;
        if (0 < enteredNum & enteredNum < array.length + 1)
            inSea = true;
        else inSea = false;
        return inSea;
    }
}
