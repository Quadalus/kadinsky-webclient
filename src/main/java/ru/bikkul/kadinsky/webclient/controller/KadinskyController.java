package ru.bikkul.kadinsky.webclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bikkul.kadinsky.webclient.dto.GenerationPictureResponseFullDto;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureResponseDto;
import ru.bikkul.kadinsky.webclient.service.KandinskyService;

@RestController
@RequiredArgsConstructor
public class KadinskyController {
    private final KandinskyService kandinskyService;

    @PostMapping("/generate/{charId}")
    public GenerationPictureResponseFullDto generatePicture(@PathVariable Long charId) {
        return kandinskyService.generatePicture(charId);
    }

    @GetMapping("/generate/{uuid}")
    public ResutPictureResponseDto generatePicture(@PathVariable String uuid) {
        return kandinskyService.getStatusPicture(uuid);
    }
}
