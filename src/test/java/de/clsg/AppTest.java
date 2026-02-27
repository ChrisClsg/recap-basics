package de.clsg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest
{
  @ParameterizedTest
  @CsvSource(value = {
    "<null>, false",
    "         , false",
    "abc, false",
    "abcdefg, false",
    "abcdefgh, true",
    "abcdefghabcdefghabcdefghabcdefgh, true",
  }, nullValues = "<null>")
  public void hasMinLength_returnsOnlyTrue_whenLengthEqualOrGrater8(String str, boolean exp) {
    assertEquals(exp, App.hasMinLength(str));
  }

  @Test
  public void containsDigit_returnsTrue_whenStringContainsDigit() {
  assertTrue(App.containsDigit("abc1"));
  }

  @Test
  public void containsDigit_returnsFalse_whenStringContainsNoDigit() {
    assertFalse(App.containsDigit("abc"));
  }

  @Test
  public void containsUpperChar_returnsTrue_whenStringContainsUpperChar() {
    assertTrue(App.containsUpperChar("aBc"));
  }

  @Test
  public void containsUpperChar_returnsFalse_whenStringContainsNoUpperChar() {
    assertFalse(App.containsUpperChar("abc"));
  }

  @Test
  public void containsLowerChar_returnsTrue_whenStringContainsLowerChar() {
    assertTrue(App.containsLowerChar("ABc"));
  }

  @Test
  public void containsLowerChar_returnsFalse_whenStringContainsNoLowerChar() {
    assertFalse(App.containsLowerChar("ABC"));
  }

  @ParameterizedTest
  @CsvSource({
    "Abcdefgh1, false",
    "Password1, false",
    "Password2, false",
    "Password3, false",
    "Password4, false",
    "Password5, false",
  })
  public void isNotACommonPassword_returnsFalse_whenStringIsBlacklisted(String str, boolean exp) {
    assertEquals(exp, App.isNotACommonPassword(str));
  }

  @Test
  public void isNotACommonPassword_returnsTrue_whenStringIsNotBlacklisted() {
    assertTrue(App.isNotACommonPassword("ReallyAmazingPassword1"));
  }

  @ParameterizedTest
  @CsvSource({
      "Abcde1, Must be at least 8 characters.",
      "ABCDEFG8, Must contain at least one lower character.",
      "abcdefg8, Must contain at least one upper character.",
      "Abcdefgh, Must contain at least 1 digit.",
      "Password1, Must not be too common."

  })
  void validatePwd_returnsExpectedErrors_whenGivenInvalidPwd(String pwd, String exp) {
    String[] expected = exp.isBlank()
        ? new String[]{}
        : exp.split(";");

    String[] actual = App.validatePwd(pwd);

    assertArrayEquals(expected, actual);
  }

  @Test
  void validatePwd_returnsEmptyArray_whenGivenValidPwd() {
    assertEquals(0, App.validatePwd("Abcdefghij1").length);
  }
}
