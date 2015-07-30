package com.example.Battle;

import com.example.Battle.exception.IncorrectDirectionException;
import com.example.Battle.exception.IncorrectShipLengthException;
import com.example.Battle.exception.LocationIsOutOfTheSeaException;

import static java.lang.Integer.parseInt;

public class TableShipSetter {
    private InputReader reader = new InputReader();
    private Table table;

    public TableShipSetter(Table table) {
        this.table = table;
    }

    public void setShip() {
        for (int count = 0; count < 3; count++) {
            ShipLocation l = getShipLocation();

            switch (l.direction) {
                case HORIZONTAL:
                    for (int index = 0; index < l.blocks; index++)
                        table.set(l.point.row + index, l.point.column);
                    break;
                case VERTICAL:
                    for (int index = 0; index < l.blocks; index++)
                        table.set(l.point.row, l.point.column + index);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown " + l.direction);
            }

            table.print();
        }
    }

    private ShipLocation getShipLocation() {
        return new ShipLocation(getBlocksCount(), getDirection(), getPoint());
    }

    private Direction getDirection() {
        while (true) {
            try {
                Battle.print("enter direction v - for vertikal, h - for horizontal");
                return Direction.of(reader.readLine());
            } catch (IncorrectDirectionException e) {
                Battle.print("incorrect direction try again");
            }
        }
    }

    public Point getPoint() {
        while (true) {
            try {
                Battle.print("Enter row:column");

                String maybeXY[] = reader.readLine().split(":");
                int row = parseInt(maybeXY[0]) - 1;
                int column = parseInt(maybeXY[1]) - 1;

                return table.checkPoint(new Point(row, column));
            } catch (LocationIsOutOfTheSeaException e) {
                Battle.print("incorrect location try again");
            } catch (IndexOutOfBoundsException e) {
                Battle.print("incorrect location try again");
            } catch (NumberFormatException e) {
                Battle.print("incorrect location try again");
            }
        }
    }

    public int getBlocksCount() {
        while (true) {
            try {
                Battle.print("enter number of blocks");
                int blocks = reader.readInt();

                if (blocks < 1 || blocks > 4)
                    throw new IncorrectShipLengthException();

                return blocks;
            } catch (IncorrectShipLengthException e) {
                Battle.print("incorrect ship length try again");
            }
        }
    }
}
