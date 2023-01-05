package com.example.battelship;

public class GUIMethots {
    public static int convertCordinatsToField(int coordinat, int fieldSice, int spaceBetweenFields) {
        return coordinat / (fieldSice + spaceBetweenFields);
    }


}
