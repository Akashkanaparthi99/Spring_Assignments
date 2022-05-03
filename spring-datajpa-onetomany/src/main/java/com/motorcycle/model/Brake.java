package com.motorcycle.model;

public enum Brake {
    FRONT_DISC("Front Disc"),
    REAR_DISC("Rear Disc");

    public final String type;

    Brake(String type) {
        this.type = type;
    }
}
