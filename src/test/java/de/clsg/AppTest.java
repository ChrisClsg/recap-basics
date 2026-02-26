package de.clsg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest
{
    @ParameterizedTest
    @CsvSource({
        "null, false",
        "         , false",
        "abc, false",
        "abcdefg, false",
        "abcdefgh, true",
        "abcdefghabcdefghabcdefghabcdefgh, true",
    })
    public void hasMinLength_returnsOnlyTrue_whenLengthEqualOrGrater8(String str, boolean exp) {
        assertEquals(exp, App.hasMinLength(str));
    }

}
