/**
 * Created by BB on 2016-11-21.
 */
import org.junit.Test;

public class TestBalint {
    @Test
    public void isAnAnagram() throws Exception {
        WordToolbox wSource = new WordToolbox("aloft");
        assert wSource.isAnAnagram("aloft");
        assert !(wSource.isAnAnagram("falsetto"));
        assert !(wSource.isAnAnagram(""));
        wSource.setS("");
        assert !(wSource.isAnAnagram("aloft"));
    }

    @Test
    public void countHowMany() throws Exception {
        WordToolbox wSource = new WordToolbox("Tarzan's toenails");
        assert wSource.countHowMany('a') == 3;
        assert wSource.countHowMany('T') == 1;
        assert wSource.countHowMany('t') == 1;
        assert wSource.countHowMany('x') == 0;
        assert wSource.countHowMany(' ') == 1;
    }

}
