package ru.bikkul.kadinsky.webclient.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.bikkul.kadinsky.webclient.common.GenerateParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static ru.bikkul.kadinsky.webclient.common.GenerateParam.*;
import static ru.bikkul.kadinsky.webclient.common.Styles.*;

@Service
public class KandinskyServiceImpl implements KandinskyService {
    private final List<String> styles = List.of(UHD.getStyle(), DEFAULT.getStyle(), ANIME.getStyle(), KANDINSKY.getStyle());
    Map<GenerateParam, List<String>> generateParams = new HashMap<>();

    {
        generateParams.put(LOCATION, LOCATION.getParams());
        generateParams.put(WEATHER, WEATHER.getParams());
        generateParams.put(OTHER, OTHER.getParams());
        generateParams.put(OTHER_WATER, OTHER_WATER.getParams());
    }

    @Override
    public void generetaPicture() {

    }

    public String getRandomStyle() {
        int random = ThreadLocalRandom.current().nextInt(styles.size());
        return switch (random) {
            case 1 -> styles.get(1);
            case 2 -> styles.get(2);
            case 3 -> styles.get(3);
            default -> styles.get(0);
        };
    }

    public String generateRandomText() {
        StringBuilder sb = new StringBuilder("утро");
        String other = getOther();
        String location = getLocation(other);
        String weather = getWeather();
        String otherWater = getOtherWater(location);
        sb.append(" ")
                .append(other)
                .append(" ")
                .append(location)
                .append(" ")
                .append(weather)
                .append(" ")
                .append(otherWater);
        return sb.toString();
    }

    private String getRandomWorld(GenerateParam type) {
        var params = generateParams.get(type);
        var size = params.size();
        double randomCoef = type.equals(OTHER) ? 3 : 1.35;
        var random = ThreadLocalRandom.current().nextInt((int) (size * randomCoef));
        if (random >= size) {
            return "";
        }
        return params.get(random);
    }

    private String getOtherWater(String location) {
        if (StringUtils.containsAny(location, "море", "океан", "река")) {
            return getRandomWorld(OTHER_WATER);
        }
        return "";
    }

    private String getWeather() {
        return getRandomWorld(WEATHER);
    }

    private String getLocation(String other) {
        if (!StringUtils.isEmpty(other)) {
            return "";
        }
        return getRandomWorld(LOCATION);
    }

    private String getOther() {
        return getRandomWorld(OTHER);
    }
}
