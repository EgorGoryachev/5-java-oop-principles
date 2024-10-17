package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");

        System.out.println(logger1 == logger2);

        logger1.setLevel(Logger.Level.INFO);

        logger1.debug("This is a debug message.");
        logger1.info("This is an info message.");
        logger1.warning("This is a warning message.");
        logger1.error("This is an error message.");

        logger1.info("Formatted info: %s", "Hello World!");
    }
}
