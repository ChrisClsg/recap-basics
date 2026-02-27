package de.clsg;

import java.util.Arrays;
import java.util.Scanner;

public class App
{
  public static void main( String[] args ) {
    askUserForPwd();
  }

  static boolean askUserForPwd() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Please set your password:");
    String pwd = sc.nextLine();

    String[] errors = validatePwd(pwd);

    if (errors.length == 0) {
      System.out.println("Your password is valid.");
    } else {
      System.out.println("Your password is invalid.");
      for (String e:errors) System.out.println("- " + e);
      System.out.println("Please try again :)");
      askUserForPwd();
    }

    sc.close();
    return true;
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

  static boolean isNotACommonPassword(String pwd) {
    String[] commonPasswords = {
      "Abcdefgh1",
      "Password1",
      "Password2",
      "Password3",
      "Password4",
      "Password5",
    };

    for(int i = 0; i < commonPasswords.length; i++) {
      if(commonPasswords[i].equals(pwd)) return false;
    }

    return true;
  }

  static boolean containsSpecialChar(String pwd) {
    char[] allowedSpecialChars = "!@#$%^&*()-_+=?.,;:".toCharArray();

    for (char c : pwd.toCharArray()) {
      for (char a : allowedSpecialChars) {
        if (c == a) return true;
      }
    }

    return false;
  }

  static String[] validatePwd(String pwd) {
    String[] tmpErrors = new String[5];
    int count = 0;

    if (!hasMinLength(pwd)) tmpErrors[count++] = "Must be at least 8 characters.";
    if (!containsDigit(pwd)) tmpErrors[count++] = "Must contain at least 1 digit.";
    if (!containsLowerChar(pwd)) tmpErrors[count++] = "Must contain at least one lower character.";
    if (!containsUpperChar(pwd)) tmpErrors[count++] = "Must contain at least one upper character.";
    if (!isNotACommonPassword(pwd)) tmpErrors[count++] = "Must not be too common.";

    return Arrays.copyOf(tmpErrors, count);
  }
}
