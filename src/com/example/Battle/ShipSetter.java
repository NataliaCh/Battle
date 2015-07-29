package com.example.Battle;

import java.util.ArrayList;

import static com.example.Battle.Battle.print;

public class ShipSetter {
    private InputReader reader = new InputReader();
    private String[][] arrayForShips;
    private ArrayList<Ships> ships = new ArrayList<Ships>();

    public ShipSetter(String[][] array) {
        this.arrayForShips = array;
    }

    public String[][] setShip() {
        for (int count = 0; count < 3; count++) {
            ShipLocation location = getShipLocation();

            switch (location.direction) {
                case HORIZONTAL:
                    fillByHorizontal(location);
                    break;
                case VERTICAL:
                    fillByVertical(location);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown " + location.direction);
            }
        }
        return arrayForShips;
    }

    private void fillByVertical(ShipLocation location) {
        int rowBlock = location.startPoint.y - 1;
        int x = location.startPoint.x;
        int blocks = location.blocks;
        for (int b = 0; b < blocks; b++) {
            arrayForShips[rowBlock][x - 1] = "S";
            Ships ship = new Ships(x - 1, rowBlock, blocks);
            ships.add(ship);
            ++rowBlock;
        }
        ships.add(new Ships(x - 1, rowBlock, blocks));
    }

    private void fillByHorizontal(ShipLocation location) {
        int colBlock = column - 1;
        for (int b = 0; b < blocks; b++) {
            arrayForShips[row - 1][colBlock] = "S";
            ++colBlock;
        }
        ships.add(new Ships(colBlock, row - 1, blocks));
    }

    public class ShipLocation {
        public final int blocks;
        public final Direction direction;
        public final Point startPoint;

        public ShipLocation(int blocks, Direction direction, Point startPoint) {
            this.blocks = blocks;
            this.direction = direction;
            this.startPoint = startPoint;
        }
    }

    public class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public enum Direction {
        VERTICAL, HORIZONTAL;

        public static Direction of(String s) throws IncorrectDirectionException {
            String maybeDirection = s.trim();
            if (maybeDirection.equalsIgnoreCase("v")) {
                return VERTICAL;
            } else if (maybeDirection.equalsIgnoreCase("h")) {
                return HORIZONTAL;
            } else {
                throw new IncorrectDirectionException();
            }
        }
    }

    private ShipLocation getShipLocation() {
        return new ShipLocation(getBlocksCount(), getDirection(), getPoint());
    }

    private Direction getDirection() {
        while (true) {
            try {
                print("enter direction v - for vertikal, h - for horizontal");
                return Direction.of(reader.readLine());
            } catch (IncorrectDirectionException e) {
                print("incorrect direction try again");
            }
        }
    }

    public Point getPoint() {
        while (true) {
            try {
                print("enter x");
                int x = checkBounds(reader.readInt(), arrayForShips);

                print("enter y");
                int y = checkBounds(reader.readInt(), arrayForShips);

                return new Point(x, y);
            } catch (LocationIsOutOfTheSeaException e) {
                print("incorrect location try again");
            }
        }
    }

    public int getBlocksCount() {
        while (true) {
            try {
                print("enter number of blocks");
                int blocks = reader.readInt();

                if (blocks < 1 || blocks > 4)
                    throw new IncorrectShipLengthException();

                return blocks;
            } catch (IncorrectShipLengthException e) {
                print("incorrect ship length try again");
            }
        }
    }

    public static class LocationIsOutOfTheSeaException extends Exception {
    }

    public static class IncorrectShipLengthException extends Exception {
    }

    public static class IncorrectDirectionException extends Exception {
    }

    public int checkBounds(int position, String[][] array) throws LocationIsOutOfTheSeaException {
        if (position < 0 || position > array.length + 1)
            throw new LocationIsOutOfTheSeaException();
        return position;
    }
}
