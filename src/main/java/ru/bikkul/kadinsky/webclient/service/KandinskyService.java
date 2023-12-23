package ru.bikkul.kadinsky.webclient.service;

import ru.bikkul.kadinsky.webclient.dto.GenerationPictureResponseFullDto;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureResponseDto;

public interface KandinskyService {
    GenerationPictureResponseFullDto generatePicture(Long charId);
    ResutPictureResponseDto getStatusPicture(String uuid);
}
