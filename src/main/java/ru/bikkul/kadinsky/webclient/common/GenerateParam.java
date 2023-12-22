package ru.bikkul.kadinsky.webclient.common;

import java.util.List;

public enum GenerateParam {
    LOCATION(List.of("город", "море", "океан", "деревня", "горы", "лес", "пустыня")),
    WEATHER(List.of("дождь", "солнце", "туман", "снег", "облака", "рассвет")),
    OTHER(List.of("кофе", "чай", "утки", "будильник", "завтрак", "душ")),
    OTHER_WATER(List.of("корабль", "рыбы"));

    GenerateParam(List<String> params) {
        this.params = params;
    }

    private final List<String> params;

    public List<String> getParams() {
        return params;
    }
}
