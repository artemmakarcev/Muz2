package com.example.makar_000.muz.enums;

/**
 * Created by makar_000 on 13.04.2017.
 */

public enum IMGEnum {

    NOTDONE(0),
    DONE(1);

    private int id;

    IMGEnum(int index) {
        id = index;
    }

    public int index() {
        return id;
    }
}
