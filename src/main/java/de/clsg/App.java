package de.clsg;

public class App
{
    public static void main( String[] args ) {
    }

    static boolean hasMinLength(String pwd) {
        int minLength = 8;

        return pwd != null && !pwd.isBlank() && pwd.length() >= minLength;
    }

}
