/// Created by BB on 2016-12-06.

import org.junit.Test;
import static org.junit.Assert.*;

public class ArabicToRomanTest {

    @Test
    public void returnIfor1() {
        assertEquals("I", NumConverter.arabicToRoman(1));
    }

    @Test
    public void returnIIfor2() {
        assertEquals("II", NumConverter.arabicToRoman(2));
    }
    @Test
    public void returnIIIfor3() {
        assertEquals("III", NumConverter.arabicToRoman(3));
    }
    @Test
    public void returnIVfor4() {
        assertEquals("IV", NumConverter.arabicToRoman(4));
    }
    @Test
    public void returnVfor5() {
        assertEquals("V", NumConverter.arabicToRoman(5));
    }
    @Test
    public void returnVIIIfor8() {
        assertEquals("VIII", NumConverter.arabicToRoman(8));
    }
    @Test
    public void returnIXfor9() {
        assertEquals("IX", NumConverter.arabicToRoman(9));
    }
    @Test
    public void returnXfor10() {
        assertEquals("X", NumConverter.arabicToRoman(10));
    }
    @Test
    public void returnXXXVIIIfor39() {
        assertEquals("XXXIX", NumConverter.arabicToRoman(39));
    }
    @Test
    public void returnXLIXfor49() {
        assertEquals("XLIX", NumConverter.arabicToRoman(49));
    }
    @Test
    public void returnLXXVfor75() {
        assertEquals("LXXV", NumConverter.arabicToRoman(75));
    }
    @Test
    public void returnCCCXCVIIfor397() {
        assertEquals("CCCXCVII", NumConverter.arabicToRoman(397));
    }
    @Test
    public void returnCDIIfor402() {
        assertEquals("CDII", NumConverter.arabicToRoman(402));
    }
    @Test
    public void returnMMXVIor2016() {
        assertEquals("MMXVI", NumConverter.arabicToRoman(2016));
    }
    @Test
    public void returnMMMMDVIfor4506() {
        assertEquals("MMMMDVI", NumConverter.arabicToRoman(4506));
    }
    @Test
    public void returnMMCDXCIXfor2999() {
        assertEquals("MMCMXCIX", NumConverter.arabicToRoman(2999));
    }
    @Test
    public void returnCDXXfor420() {
        assertEquals("CDXX", NumConverter.arabicToRoman(420));
    }
}
