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

        print("enter x");
        int row = reader.readInt();
        boolean checkRow = checkFit(row, arrayForShips);
        print("enter y");
        int column = reader.readInt();
        boolean checkColumn = checkFit(column, arrayForShips);

        if (checkColumn&&checkRow){
            arrayForShips[row][column]="S";
        }
        
return arrayForShips;
    }

    public boolean checkFit(int enteredNum, String[][] array) {
        boolean inSea;
        if (0 < enteredNum && enteredNum < array.length)
            inSea = true;
        else inSea = false;
        return inSea;
    }
}
