/**
 * Created by BB on 2016-11-21.
 */

public class App {
    public static void main(String[] args) {
        WordToolbox wSource = new WordToolbox("Tarzan's toenails");
        System.out.printf("countHowMany(\"a\")= %d\n", wSource.countHowMany('a'));
        System.out.printf("countHowMany(\"T\")= %d\n", wSource.countHowMany('T'));
        System.out.printf("countHowMany(\"t\")= %d\n", wSource.countHowMany('t'));
        System.out.printf("countHowMany(\"x\")= %d\n", wSource.countHowMany('x'));
        System.out.printf("countHowMany(\" \")= %d\n", wSource.countHowMany(' '));

        wSource.setS("folate");
        String [] alternatives = {"falsetto", "latest", "foetal","aloft","float","flota"};
        for (String s : alternatives) {
            System.out.printf("is %s an anagram of %s = %s\n", s, wSource.getS(), wSource.isAnAnagram(s));
        }
        System.out.println("\nNew test");
        wSource.setS("aloft");
        for (String s : alternatives) {
            System.out.printf("is %s an anagram of %s = %s\n", s, wSource.getS(), wSource.isAnAnagram(s));
        }
    }
}