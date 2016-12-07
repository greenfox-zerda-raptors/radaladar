/// Created by BB on 2016-12-06.

import org.junit.Test;
import static org.junit.Assert.*;

public class ArabicToRomanTest {

    @Test
    public void returnIfor1() {
        assertEquals("I", NumConverter.arabicToRoman2(1));
    }

    @Test
    public void returnIIfor2() {
        assertEquals("II", NumConverter.arabicToRoman2(2));
    }
    @Test
    public void returnIIIfor3() {
        assertEquals("III", NumConverter.arabicToRoman2(3));
    }
    @Test
    public void returnIVfor4() {
        assertEquals("IV", NumConverter.arabicToRoman2(4));
    }
    @Test
    public void returnVfor5() {
        assertEquals("V", NumConverter.arabicToRoman2(5));
    }
    @Test
    public void returnVIIIfor8() {
        assertEquals("VIII", NumConverter.arabicToRoman2(8));
    }
    @Test
    public void returnIXfor9() {
        assertEquals("IX", NumConverter.arabicToRoman2(9));
    }
    @Test
    public void returnXfor10() {
        assertEquals("X", NumConverter.arabicToRoman2(10));
    }
    @Test
    public void returnXXXVIIIfor39() {
        assertEquals("XXXIX", NumConverter.arabicToRoman2(39));
    }
    @Test
    public void returnXLIXfor49() {
        assertEquals("XLIX", NumConverter.arabicToRoman2(49));
    }
    @Test
    public void returnLXXVfor75() {
        assertEquals("LXXV", NumConverter.arabicToRoman2(75));
    }
    @Test
    public void returnCCCXCVIIfor397() {
        assertEquals("CCCXCVII", NumConverter.arabicToRoman2(397));
    }
    @Test
    public void returnCDIIfor402() {
        assertEquals("CDII", NumConverter.arabicToRoman2(402));
    }
    @Test
    public void returnMMXVIor2016() {
        assertEquals("MMXVI", NumConverter.arabicToRoman2(2016));
    }
    @Test
    public void returnMMMMDVIfor4506() {
        assertEquals("MMMMDVI", NumConverter.arabicToRoman2(4506));
    }
    @Test
    public void returnMMCDXCIXfor2999() {
        assertEquals("MMCMXCIX", NumConverter.arabicToRoman2(2999));
    }
    @Test
    public void returnCDXXfor420() {
        assertEquals("CDXX", NumConverter.arabicToRoman2(420));
    }
}
