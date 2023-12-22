package ru.bikkul.kadinsky.webclient.common;

public enum Styles {
    KANDINSKY("KANDINSKY"),
    UHD("UHD"),
    ANIME("ANIME"),
    DEFAULT("DEFAULT");

    private final String style;

    Styles(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
