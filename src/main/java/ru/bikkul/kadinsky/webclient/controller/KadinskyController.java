package ru.bikkul.kadinsky.webclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
