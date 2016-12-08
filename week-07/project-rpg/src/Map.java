/// Created by BB on 2016-12-05.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Map {
    private static int level = 0;
    private int[][] mapFloor;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private Hero hero;
    private ArrayList<Character> entities = new ArrayList<>();

    /// Constructor

    public Map() {
        level += 1;
        this.mapFloor = generateMapFloor();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.mapFloor[j][i] == 1) {
                    this.tiles.add(new Wall(i, j));
                } else {
                    this.tiles.add(new Floor(i, j));
                }
            }
        }
        this.hero = new Hero();
        Random random = new Random();
        int numberOfEnemies = 1 + random.nextInt(3);
        for (int i = 0; i < numberOfEnemies; i++) {
            this.entities.add(new Enemy(enemyPlacement()));
        }
        this.entities.add(this.hero);
    }


    /// Map generation & restrictions

    private int[][] generateMapFloor() {

        MazeObj m = new MazeObj(12,12);
        m.generate();
        int[][] map = new int[10][10];
        for (int i = 1; i < 11; i++){
            for (int j = 1; j < 11; j++) {
                map[i-1][j-1] = m.getData()[i][j];
            }
        }
        if (map[1][1] == 1 && map[2][1] == 0) {
            map[1][1] = 0;
        } else if (map[1][1] == 1 && map[2][1] == 1) {
            map[2][1] = 0;
        }
        for (int i = 1; i < 9; i++) {
            if (map[8][i-1] == 1 || map[9][i] == 1 && map[8][i+1] == 1 || map[7][i] == 1) {
                map[8][i-1] = 0;
            }
        }
        map[1][8] = 0;
        map[5][8] = 0;
        map[7][8] = 0;

        int[][] mapTrans = new int[10][10];
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                break;
            case 1:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        mapTrans[j][i] = map[i][9 - j];
                    }
                }
                map = mapTrans;
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        mapTrans[j][i] = map[9-i][j];
                    }
                }
                map = mapTrans;
                break;
            }
        return map;
    }

    private int[] enemyPlacement(){
        Random random = new Random();
        int[] position = new int[2];
        boolean goodPosition = false;
        ArrayList<int[]> usedPositions = new ArrayList<>();
        int[] hero = {0,0};
        usedPositions.add(hero);
        for (Character entity: entities) {
            usedPositions.add(entity.position);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (getMapFloor()[i][j] == 1) {
                    int[] wall = new int[2];
                    wall[0] = i;
                    wall[1] = j;
                    usedPositions.add(wall);
                }
            }
        }
        while (!goodPosition) {
            position[0] = random.nextInt(10);
            position[1] = random.nextInt(10);
            for (int[] usedPosition : usedPositions) {
                if (position[0] == usedPosition[1] && position[1] == usedPosition[0]) {
                goodPosition = false;
                break;
                } else {
                    goodPosition = true;
                }
            }
        }
        return position;
    }

    /// Getters

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ArrayList<Character> getEntities() {
        return entities;
    }

    public Hero getHero() {
        return hero;
    }

    public int[][] getMapFloor(){
        return mapFloor;
    }

}
