package org.example.enums;

public enum TextData {
    EMAIL("eiridyr@gmail.com"),
    PASSWORD("Wg6y2"),

    BASE_URL("https://demo.solomono.net");

    private final String text;

    TextData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
