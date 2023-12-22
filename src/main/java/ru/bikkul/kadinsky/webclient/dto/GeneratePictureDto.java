package ru.bikkul.kadinsky.webclient.dto;

import lombok.Data;

@Data
public class GeneratePictureDto {
    private final String TYPE = "GENERATE";

    private final int width = 1920;

    private final int height = 1080;

    private final int num_images = 1;

    private final String style;

    private GenerateParams generateParams;

    public GeneratePictureDto(String style, GenerateParams generateParams) {
        this.style = style;
        this.generateParams = generateParams;
    }
}

record GenerateParams(String query) {
}
