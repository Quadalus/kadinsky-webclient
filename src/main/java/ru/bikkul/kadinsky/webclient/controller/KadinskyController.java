package ru.bikkul.kadinsky.webclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureDto;
import ru.bikkul.kadinsky.webclient.service.KandinskyService;

@RestController
@RequiredArgsConstructor
public class KadinskyController {
    private final KandinskyService kandinskyService;

    @GetMapping("/text")
    public String getRandomText() {
        return kandinskyService.generateRandomText();
    }


    @GetMapping("/style")
    public String getRandomStyle() {
        return kandinskyService.getRandomStyle();
    }

    @PostMapping("/generate")
    public String generatePicture() {
        return kandinskyService.generatePicture();
    }

    @GetMapping("/generate/{uuid}")
    public ResutPictureDto generatePicture(@PathVariable String uuid) {
        return kandinskyService.getStatusPicture(uuid);
    }
}
