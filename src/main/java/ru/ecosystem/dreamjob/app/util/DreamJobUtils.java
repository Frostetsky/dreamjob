package ru.ecosystem.dreamjob.app.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class DreamJobUtils {

    public int generateId() {
        return Math.abs(new Random().nextInt());
    }
}
