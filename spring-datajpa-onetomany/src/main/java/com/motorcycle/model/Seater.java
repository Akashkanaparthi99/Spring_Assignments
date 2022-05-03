package com.motorcycle.model;

public enum Seater {
    TWO_SEATER("Two Seater"),
    SINGLE_SEATER("Single Seater");

    public final String seat;

    Seater(String seat) {
        this.seat = seat;
    }
}
