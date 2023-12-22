package ru.bikkul.kadinsky.webclient.client;

public interface KadinskyClient {
    String generatePicture();
    String checkServiceAvailable();
    String checkGenerateStatus(String uuid);
}
