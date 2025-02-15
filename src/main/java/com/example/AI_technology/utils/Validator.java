package com.example.AI_technology.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateMobileNumber(Long mobileNumber) {

        String mobileNumberStr = String.valueOf(mobileNumber);
        String mobileRegex = "^[7-9][0-9]{9}$";
        Pattern pattern = Pattern.compile(mobileRegex);
        Matcher matcher = pattern.matcher(mobileNumberStr);
        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
