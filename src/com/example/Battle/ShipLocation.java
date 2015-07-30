package com.example.Battle;

public class ShipLocation {
        public final int blocks;
        public final Direction direction;
        public final Point point;

        public ShipLocation(int blocks, Direction direction, Point point) {
            this.blocks = blocks;
            this.direction = direction;
            this.point = point;
        }
    }