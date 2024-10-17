package com.example.task04;


import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {

    private final List<String> messages = new ArrayList<>();
    private final MessageHandler delegate;
    private final int threshold;

    public MemoryHandler(MessageHandler delegate, int threshold) {
        this.delegate = delegate;
        this.threshold = threshold;
    }

    @Override
    public void handleMessage(String message) {
        messages.add(message);

        if (messages.size() >= threshold) {
            flush();
        }
    }

    public void flush() {
        for (String message : messages) {
            delegate.handleMessage(message);
        }
        messages.clear();
    }
}