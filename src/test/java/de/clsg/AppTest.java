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
    "Abcdefgh1!, false",
    "Password1!, false",
    "Password2!, false",
    "Password3!, false",
    "Password4!, false",
    "Password5!, false",
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
    "abc, false",
    "ab/, false",
    "ab!, true",
    "ab@, true",
    "ab#, true",
    "ab$, true",
    "ab%, true",
    "ab^, true",
    "ab&, true",
    "ab*, true",
    "ab(, true",
    "ab), true",
    "ab-, true",
    "ab_, true",
    "ab+, true",
    "ab=, true",
    "ab?, true",
    "ab., true",
    "'ab,', true",
    "ab;, true",
    "ab:, true",
  })
  public void containsSpecialChar_onlyReturnsTrue_whenStringContainsAllowedSpecialChar(String str, boolean exp) {
    assertEquals(exp, App.containsSpecialChar(str));
  }

  @ParameterizedTest
  @CsvSource({
      "A+cde1, Must be at least 8 characters.",
      "A+CDEFG8, Must contain at least one lower character.",
      "a+cdefg8, Must contain at least one upper character.",
      "A+cdefgh, Must contain at least 1 digit.",
      "Password1!, Must not be too common.",
      "Password1, 'Must contain at least one special character [\\!@#$%^&*()-_+=?.,;:\\].'",
  })
  void validatePwd_returnsExpectedError_whenGivenPwdWithOneError(String pwd, String exp) {
    String[] expected = exp.isBlank()
        ? new String[]{}
        : new String[]{exp};

    String[] actual = App.validatePwd(pwd);

    assertArrayEquals(expected, actual);
  }

  @Test
  void validatePwd_returnsEmptyArray_whenGivenValidPwd() {
    assertEquals(0, App.validatePwd("Abcdefghij1!").length);
  }

  @Test
  void getRandomLowerChar_returnsOneLowerCaseChar() {
    char c = App.getRandomLowerChar();

    assertTrue(c >= 'a' && c <= 'z');
  }

  @Test
  void getRandomLowerChar_returnsOneUpperCaseChar() {
    char c = App.getRandomUpperChar();

    assertTrue(c >= 'A' && c <= 'Z');
  }

  @Test
  void getRandomDigit_returnsOneDigit() {
    char c = App.getRandomDigit();

    assertTrue(c >= '0' && c <= '9');
  }

  @Test
  void getRandomSpecialChar_returnsOneAllowedSpecialChar() {
    String allowedChars = "!@#$%^&*()-_+=?.,;:";
    char c = App.getRandomSpecialChar();

    assertTrue(allowedChars.contains(String.valueOf(c)));
  }

  @Test
  void generatePwd_throwsArgException_whenGivenNumBelow8() {
    assertThrows(IllegalArgumentException.class, () -> App.generatePwd(7));
  }

  @ParameterizedTest
  @CsvSource({
    "8",
    "16",
    "20",
    "40",
    "72",
  })
  void generatePwd_returnsPwd_withGivenLength(int num) {
    assertEquals(num, App.generatePwd(num).length());
  }

  @ParameterizedTest
  @CsvSource({
    "8",
    "16",
    "20",
    "40",
    "72",
  })
  void generatePwd_returnsAValidPwd(int n) {
    assertEquals(0, App.validatePwd(App.generatePwd(n)).length);
  }
}

