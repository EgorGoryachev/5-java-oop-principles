package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger{
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


    private Logger(String name) {
        this.name = name;
        this.currentLevel = Level.DEBUG;
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

    private void log(Level level, String message) {
        if (level.getValue() >= currentLevel.getValue()) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
            System.out.printf("[%s] %s %s - %s%n", level, timestamp, name, message);
        }
    }

    public void debug(String message) {

        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... args) {

        log(Level.DEBUG, String.format(format, args));
    }

    public void info(String message) {

        log(Level.INFO, message);
    }

    public void info(String format, Object... args) {

        log(Level.INFO, String.format(format, args));
    }

    public void warning(String message) {

        log(Level.WARNING, message);
    }

    public void warning(String format, Object... args) {

        log(Level.WARNING, String.format(format, args));
    }

    public void error(String message) {

        log(Level.ERROR, message);
    }

    public void error(String format, Object... args) {

        log(Level.ERROR, String.format(format, args));
    }
}
