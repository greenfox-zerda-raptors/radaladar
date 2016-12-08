/// Created by BB on 2016-12-07.

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

public class MoveLogic implements KeyListener {
    private Board board;
    private Map map;

    /// Constructor

    public MoveLogic(Board board,Map map) {
        this.board = board;
        this.map = map;
    }

    /// Check for keys pressed

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                fight();
                break;
            case KeyEvent.VK_UP:
                move(1);
                break;
            case KeyEvent.VK_RIGHT:
                move(2);
                break;
            case KeyEvent.VK_DOWN:
                move(3);
                break;
            case KeyEvent.VK_LEFT:
                move(4);
                break;
        }
    }

    /// Methods

    public void move(int i){
        map.getHero().faceDirection(i);
        int[] check = moveCheck(i);
        if (checkBounds(check) && checkWalls(check)) {
            map.getHero().position[check[0]] += check[3];
            playSound("src/sounds/footstep.wav");
        } else {
            playSound("src/sounds/bump.wav");
        }
        board.repaint();
    }

    private int[] moveCheck(int i) {
        int[] check = new int[4];
        switch (i) {
        case 1:
            check = new int[]{1,-1,0,-1};
            break;
        case 2:
            check = new int[]{0,0,1,1};
            break;
        case 3:
            check = new int[]{1,1,0,1};
            break;
        case 4:
            check = new int[]{0,0,-1,-1};
            break;
        }
        return check;
    }

    private boolean checkBounds(int[] check){
        return map.getHero().position[check[0]] + check[3] >= 0 && map.getHero().position[check[0]] + check[3] < 10;
    }

    private boolean checkWalls(int[] check){
        return map.getMapFloor()[map.getHero().position[1] + check[1]] [map.getHero().position[0] + check[2]] == 0;
    }

    private void fight() {
        ArrayList<Character> enemies = new ArrayList<>(map.getEntities());
        enemies.remove(enemies.size()-1);
        Hero hero = map.getHero();
        Character enemyToFight = searchEnemy(enemies, hero);
        if (enemyToFight != null) {
            if (!(enemyToFight.isDead)) {
                strike(hero, enemyToFight);
                playSound("src/sounds/attack.wav");
            }
            if (!(enemyToFight.isDead)) {
                strike(enemyToFight,hero);
            } else {
                playSound("src/sounds/death.wav");
                map.getEntities().remove(enemyToFight);
            }
            if (hero.isDead){
                /// SOMETHING HERE IF HERO DIES
            }
        }
        board.repaint();
    }

    private Character searchEnemy(ArrayList<Character> enemies, Hero hero) {
        Character enemyToFight = null;
        for (Character enemy : enemies) {
            if (enemy.position[0] == hero.position[0] && enemy.position[1] == hero.position[1]) {
                enemyToFight = enemy;
            }
        }
        return enemyToFight;
    }

    private void strike(Character attacker, Character defender) {
        defender.hpCurrent -= (attacker.sp - defender.dp);
        if (defender.hpCurrent <= 0) {
            defender.isDead = true;
        }
    }

    private void playSound(String sound){
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(sound)));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    ///Unused Overrides
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
