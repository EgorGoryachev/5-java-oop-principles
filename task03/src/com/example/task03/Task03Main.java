package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        Milliseconds ms = new Milliseconds(29999);

        System.out.println("Milliseconds: " + ms.toMillis());
        System.out.println("Seconds: " + ms.toSeconds());
        System.out.println("Minutes: " + ms.toMinutes());
        System.out.println("Hours: " + ms.toHours());
    }
}
