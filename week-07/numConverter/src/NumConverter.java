/// Created by BB on 2016-12-06.

public class NumConverter {

    static String arabicToRoman (int arabic) {
        StringBuilder returnString = new StringBuilder("");
        while (arabic > 0) {
            if (arabic < 4) {
                returnString.append('I');
                arabic--;
            } else if (arabic == 4) {
                returnString.append("IV");
                arabic -= 4;
            } else if (arabic > 4 && arabic < 9) {
                returnString.append("V");
                arabic -= 5;
            } else if (arabic == 9) {
                returnString.append("IX");
                arabic -= 9;
            } else if (arabic > 9 && arabic < 40) {
                returnString.append('X');
                arabic -= 10;
            } else if (arabic >= 40 && arabic < 50) {
                returnString.append("XL");
                arabic -= 40;
            } else if (arabic >= 50 && arabic < 90) {
                returnString.append('L');
                arabic -= 50;
            } else if (arabic >= 90 && arabic < 100) {
                returnString.append("XC");
                arabic -= 90;
            } else if (arabic >= 100 && arabic < 400) {
                returnString.append("C");
                arabic -= 100;
            } else if (arabic >= 400 && arabic < 500) {
                returnString.append("CD");
                arabic -= 400;
            } else if (arabic >= 500 && arabic < 900) {
                returnString.append("D");
                arabic -= 500;
            } else if (arabic >= 900 && arabic < 1000) {
                returnString.append("CM");
                arabic -= 900;
            } else if (arabic >= 1000) {
                returnString.append("M");
                arabic -= 1000;
            }
        }
        return returnString.toString();
    }

    static String arabicToRoman2(int arabic) {
        StringBuilder returnString = new StringBuilder("");
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int counter = 0;
        while (arabic > 0) {
            if (arabic < values[counter]) {
                counter++;
            } else {
                returnString.append(symbols[counter]);
                arabic -= values[counter];
            }
        }
        return returnString.toString();
    }
}
