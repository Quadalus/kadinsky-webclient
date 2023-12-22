package ru.bikkul.kadinsky.webclient.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.bikkul.kadinsky.webclient.client.KadinskyClient;
import ru.bikkul.kadinsky.webclient.common.GenerateParam;
import ru.bikkul.kadinsky.webclient.dto.GeneratePictureDto;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureDto;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static ru.bikkul.kadinsky.webclient.common.GenerateParam.*;
import static ru.bikkul.kadinsky.webclient.common.Styles.*;

@Service
public class KandinskyServiceImpl implements KandinskyService {
    private final List<String> styles;
    private final Map<GenerateParam, List<String>> generateParams = new HashMap<>();
    private final KadinskyClient kadinskyClient;

    {
        generateParams.put(LOCATION, LOCATION.getParams());
        generateParams.put(WEATHER, WEATHER.getParams());
        generateParams.put(OTHER, OTHER.getParams());
        generateParams.put(OTHER_WATER, OTHER_WATER.getParams());
    }

    public KandinskyServiceImpl(KadinskyClient kadinskyClient) {
        this.kadinskyClient = kadinskyClient;
        this.styles = List.of(UHD.getStyle(), DEFAULT.getStyle(), ANIME.getStyle(), KANDINSKY.getStyle());
    }

    @Override
    public String generatePicture() {
        String style = getRandomStyle();
        GeneratePictureDto generatePictureDto = new GeneratePictureDto(style, generateRandomText());
        return kadinskyClient.generatePicture(generatePictureDto);
    }

    @Override
    public ResutPictureDto getStatusPicture(String uuid) {
        var resutPictureDto = kadinskyClient.checkGenerateStatus(uuid);
        var images = resutPictureDto.getImages();
        if (!(images == null) && !images.isEmpty()) {
            var s = images.get(0);
            byte[] decodedBytes = Base64.getDecoder().decode(s);
            try {
                FileUtils.writeByteArrayToFile(new File("src/main/resources/picture%d.jpg"
                        .formatted(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE))), decodedBytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return resutPictureDto;
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
        return StringUtils.trim(sb.toString());
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
