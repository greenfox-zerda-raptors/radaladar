/// Created by BB on 2016-12-09.

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {

    static final File openingTheme = new File("src/sounds/opening_theme.wav");
    static final File dungeonTheme = new File("src/sounds/dungeon_theme.wav");
    static final File footstep = new File("src/sounds/footstep.wav");
    static final File bump = new File("src/sounds/bump.wav");
    static final File attack = new File("src/sounds/attack.wav");
    static final File miss = new File("src/sounds/miss.wav");
    static final File death = new File("src/sounds/enemydeath.wav");
    static final File nextLevel = new File("src/sounds/nextlevel.wav");
    static final File playerDeath = new File("src/sounds/playerdeath.wav");
    static final File playerDeathTheme = new File("src/sounds/playerdeath_theme.wav");
    static private Clip loop;

    static public void playFX(File audio){
        try {
            Clip fx = AudioSystem.getClip();
            fx.open(AudioSystem.getAudioInputStream(audio));
            fx.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    static public void playBackGround(File audio){
        try {
            loop = AudioSystem.getClip();
            loop.open(AudioSystem.getAudioInputStream(audio));
            loop.stop();
            loop.start();
            loop.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    static public void loopStop(){
        if (loop != null) {
        loop.stop();
        }
    }
}
