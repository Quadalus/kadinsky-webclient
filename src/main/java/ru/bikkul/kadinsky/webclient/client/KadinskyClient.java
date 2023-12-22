package ru.bikkul.kadinsky.webclient.client;

import ru.bikkul.kadinsky.webclient.dto.GeneratePictureDto;
import ru.bikkul.kadinsky.webclient.dto.ResutPictureDto;

public interface KadinskyClient {
    String generatePicture(GeneratePictureDto queryPicture);
    String checkServiceAvailable();
    ResutPictureDto checkGenerateStatus(String uuid);
}
