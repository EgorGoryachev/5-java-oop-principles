package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {
    private final String baseFilePath;
    private final long rotationInterval;
    private LocalDateTime lastWrittenTime;

    public RotationFileHandler(String baseFilePath, long rotationInterval) {
        this.baseFilePath = baseFilePath;
        this.rotationInterval = rotationInterval;
        this.lastWrittenTime = LocalDateTime.now();
    }

    @Override
    public void handleMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(lastWrittenTime.plusHours(rotationInterval))) {
            lastWrittenTime = now;
        }

        String fileName = baseFilePath + "_" + lastWrittenTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HH")) + ".log";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
