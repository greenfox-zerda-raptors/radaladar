/// Created by BB on 2016-12-07.

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic implements KeyListener {
    private Board board;
    private Map map;
    private JPanel panel;
    private JLabel label;
    private int level;
    private Hero hero;
    private int moveCount;


    /// Constructor

    public GameLogic(Board board, Map map, JPanel panel, JLabel label, int level, Hero hero) {
        this.board = board;
        this.map = map;
        this.panel = panel;
        this.label = label;
        this.level = level;
        this.hero = hero;
        this.moveCount = 0;
        labelUpdate();
    }

    /// Check for keys pressed

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (hero.isDead) {
                    hero.isDead = false;
                    worldReset(false);
                } else {
                    fight();
                }
                checkWorldState();
                break;
            case KeyEvent.VK_UP:
                if (!hero.isDead) {
                    move(1);
                    checkWorldState();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!hero.isDead) {
                    move(2);
                    checkWorldState();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!hero.isDead) {
                    move(3);
                    checkWorldState();
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!hero.isDead) {
                    move(4);
                    checkWorldState();
                }
                break;
        }
    }

    /// Methods

    /// Movement

    public void move(int i){
        map.getHero().faceDirection(i);
        int[] check = moveCheck(i);
        if (checkBounds(check) && checkWalls(check)) {
            map.getHero().position[check[0]] += check[3];
            SoundPlayer.playFX(SoundPlayer.footstep);
        } else {
            SoundPlayer.playFX(SoundPlayer.bump);
        }
        moveCount++;
        if (moveCount == 2) {
            enemyMove();
            moveCount = 0;
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

    private boolean enemyBounds(Character enemy,int[] check){
        return enemy.position[check[0]] + check[3] >= 0 && enemy.position[check[0]] + check[3] < 10;
    };

    private boolean enemyWalls(Character enemy, int[] check){
        return map.getMapFloor()[enemy.position[1] + check[1]] [enemy.position[0] + check[2]] == 0;
    }

    private void enemyMove(){
        ArrayList<Character> enemies = new ArrayList<>(map.getEntities());
        enemies.remove(enemies.size()-1);
        Random random = new Random();
        for (Character enemy: enemies) {
            int[] enemymove = moveCheck(1 + random.nextInt(4));
            while (!(enemyBounds(enemy, enemymove) && enemyWalls(enemy, enemymove))) {
                enemymove = moveCheck(1 + random.nextInt(4));
            }
            enemy.position[enemymove[0]] += enemymove[3];
        }
    }

    /// Fighting

    private void fight() {
        ArrayList<Character> enemies = new ArrayList<>(map.getEntities());
        enemies.remove(enemies.size()-1);
        Hero hero = map.getHero();
        Character enemyToFight = searchEnemy(enemies, hero);
        if (enemyToFight != null) {
            if (!(enemyToFight.isDead)) {
                strike(hero, enemyToFight);
            }
            if (!(enemyToFight.isDead)) {
                strike(enemyToFight,hero);
            } else {
                SoundPlayer.playFX(SoundPlayer.death);
                map.getEntities().remove(enemyToFight);
            }
        } else {
            SoundPlayer.playFX(SoundPlayer.miss);
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
        int attackValue = attacker.attack + attacker.dice(2);
        if (attackValue > defender.defense) {
            SoundPlayer.playFX(SoundPlayer.attack);
            defender.hpCurrent -= (attackValue - defender.defense);
            if (defender.hpCurrent <= 0) {
                defender.isDead = true;
            }
        } else if (attacker == hero){
            SoundPlayer.playFX(SoundPlayer.miss);
        }
    }

    /// Board & World Stuff

    private void labelUpdate() {
        StringBuilder labelText = new StringBuilder();
        labelText.append("<html>Level ");
        labelText.append(level);
        labelText.append("<br><br><br>");
        if (hero.isDead){
            labelText.append("YOU DIED!<br><br>The Overgrowth Warlock <br>and their Faceflowers <br>have taken over the world.<br><br>Press space to restart.");
        } else {
            ArrayList<Character> enemies = new ArrayList<>(map.getEntities());
            enemies.remove(enemies.size()-1);
            Hero hero = map.getHero();
            labelText.append(hero.toString());
            Character enemyToFight = searchEnemy(enemies, hero);
            if (enemyToFight != null) {
                labelText.append("<br><br><br>");
                labelText.append(enemyToFight.toString());
            }
        }
        label.setText(labelText.toString());
    }

    private void checkWorldState(){
        if (map.getHero().isDead) {
            heroDeath();
        }
        ArrayList<Character> enemies = new ArrayList<>(map.getEntities());
        enemies.remove(enemies.size()-1);
        int counter = 0;
        for (Character enemy : enemies) {
            if (enemy instanceof Boss) {
                counter++;
            } else {
                Enemy keyholder = (Enemy) enemy;
                if (keyholder.hasKey()){
                    counter++;
                }
            }
        }
        if (counter == 0) {
            worldReset(true);
        } else {
            labelUpdate();
        }
    }

    private void heroDeath(){
        hero.filename = "src/images/hero-dead.png";
        hero.setImage();
        labelUpdate();
        SoundPlayer.loopStop();
        SoundPlayer.playFX(SoundPlayer.playerDeath);
        SoundPlayer.playBackGround(SoundPlayer.playerDeathTheme);
    }

    private void worldReset(boolean win){
        if (win) {
            level++;
            hero.levelUp();
            Random random = new Random();
            int chance = random.nextInt(10);
            if (chance > 4 && chance < 9) {
                hero.hpCurrent += hero.hpMax / 3;
            } else if (chance > 9) {
                hero.hpCurrent = hero.hpMax;
            } else {
                hero.hpCurrent += hero.hpMax / 10;
            }
        } else {
            hero.hpCurrent = hero.hpMax;
        }
        hero.position = new int[]{0,0};
        hero.faceDirection(3);
        panel.remove(board);
        board = new Board(panel,label, level, hero);
        panel.add(board);
        board.grabFocus();
        panel.revalidate();
        panel.repaint();
    }

    ///Unused Overrides
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
