package ru.bikkul.kadinsky.webclient.service;

import ru.bikkul.kadinsky.webclient.common.Styles;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureResponseDto;

import java.util.concurrent.CompletableFuture;

public interface KandinskyService {
    CompletableFuture<ResutPictureResponseDto> generatePicture(Long charId);

    CompletableFuture<ResutPictureResponseDto> generatePictureWithQuery(Long chatId, Styles style, String query);
}
