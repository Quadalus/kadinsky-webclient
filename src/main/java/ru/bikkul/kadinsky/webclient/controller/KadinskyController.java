package ru.bikkul.kadinsky.webclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bikkul.kadinsky.webclient.common.Styles;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureResponseDto;
import ru.bikkul.kadinsky.webclient.service.KandinskyService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class KadinskyController {
    private final KandinskyService kandinskyService;

    @GetMapping("/generate/{charId}")
    public CompletableFuture<ResutPictureResponseDto> generatePicture(@PathVariable Long charId) {
        return kandinskyService.generatePicture(charId);
    }

    @GetMapping("/generate/{charId}/")
    public CompletableFuture<ResutPictureResponseDto> generatePictureWithQuery(@PathVariable Long charId,
                                                                               @RequestParam(defaultValue = "DEFAULT") Styles style,
                                                                               @RequestParam String query) {
        return kandinskyService.generatePictureWithQuery(charId, style, query);
    }
}
