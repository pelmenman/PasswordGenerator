package com.example.parolgenerator;
import java.util.Vector;

public class PasswordGenerator {

    protected StringBuilder Password = new StringBuilder();
    private final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private final String upperCaseLetters = lowerCaseLetters.toUpperCase();
    private final String numbers = "0123456789";
    private final String specialSymbols = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~";
    private final String allSymbols = lowerCaseLetters + upperCaseLetters + numbers + specialSymbols;

    PasswordGenerator() {
        this(8);
    }

    PasswordGenerator(int length) {
        setPassword(Password, length);
    }

    public void newPassword(int length) {
        this.Password.setLength(0);
        setPassword(Password, length);
    }

    private void setPassword(StringBuilder Password, int length) {
        for (int i = 0; i < length; i++) {
            int pos = (int) (Math.random() * (allSymbols.length()));
            char temp = allSymbols.charAt(pos);
            Password.append(temp);
        }
    }


    public StringBuilder getPassword() {
        return Password;
    }


}
