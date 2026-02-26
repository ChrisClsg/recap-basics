package de.clsg;

public class App
{
    public static void main( String[] args ) {
    }

    static boolean hasMinLength(String pwd) {
        int minLength = 8;

        return pwd != null && !pwd.isBlank() && pwd.length() >= minLength;
    }

    static boolean containsDigit(String pwd) {
        char[] chars = pwd.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])) return true;
        }

        return false;
    }

    static boolean containsUpperChar(String pwd) {
        char[] chars = pwd.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(Character.isUpperCase(chars[i])) return true;
        }

        return false;
    }

    static boolean containsLowerChar(String pwd) {
        char[] chars = pwd.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(Character.isLowerCase(chars[i])) return true;
        }

        return false;
    }
}
