package com.producter.player.registration.enums;

public enum Position {

	PG("Point Guard"),
	SG("Shooting guard"),
    SF("Small forward"),
    PF("Power forward"),
    C("Center");

    public final String value;

    private Position(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
