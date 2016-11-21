/**
 * Created by BB on 2016-11-21.
 */
import java.util.HashMap;

public class WordToolbox implements IWordToolBox{
    private String stringHeld;

    public WordToolbox(String stringHeld) {
        this.stringHeld = stringHeld;
    }

    public int countHowMany(char charToFind) {
        int counter = 0;
        for (int i = 0; i < this.stringHeld.length(); i++) {
            if (this.stringHeld.charAt(i) == charToFind) {
                counter++;
            }
        }
        return counter;
    }

    private HashMap<Character, Integer> countAllLetters(String stringToCheck) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < stringToCheck.length(); i++) {
            char c = stringToCheck.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (map.containsKey(c)) {
                    int cnt = map.get(c);
                    map.put(c, ++cnt);
                } else {
                    map.put(c, 1);
                }
            }
        }
        return map;
    }

    @Override
    public boolean isAnAnagram(String stringToCheck) {
        HashMap<Character, Integer> thisMap = countAllLetters(this.stringHeld);
        HashMap<Character, Integer> thatMap = countAllLetters(stringToCheck);
        if (thisMap.equals(thatMap)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getS() {
        return stringHeld;
    }
    @Override
    public void setS(String stringHeld) {
        this.stringHeld = stringHeld;
    }
    @Override
    public void WaitingItOut() {
        for (int i = 0; i == 0;) {}
    }
}
