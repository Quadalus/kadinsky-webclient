package ru.bikkul.kadinsky.webclient.service;

import ru.bikkul.kadinsky.webclient.dto.ResutPictureDto;

public interface KandinskyService {
    String generatePicture();
    ResutPictureDto getStatusPicture(String uuid);

    String getRandomStyle();

    String generateRandomText();
}
