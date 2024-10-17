package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logger {
    public enum Level {
        DEBUG(0), INFO(1), WARNING(2), ERROR(3);

        private final int value;

        Level(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static final Map<String, Logger> loggers = new HashMap<>();

    private final String name;
    private Level currentLevel;
    private final List<MessageHandler> handlers;

    private Logger(String name) {
        this.name = name;
        this.currentLevel = Level.DEBUG;
        this.handlers = new ArrayList<>();
    }

    public static Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.currentLevel = level;
    }

    public Level getLevel() {
        return currentLevel;
    }

    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    private void log(Level level, String message) {
        if (level.getValue() >= currentLevel.getValue()) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
            String formattedMessage = String.format("[%s] %s %s - %s", level, timestamp, name, message);

            for (MessageHandler handler : handlers) {
                handler.handleMessage(formattedMessage);
            }
        }
    }

}