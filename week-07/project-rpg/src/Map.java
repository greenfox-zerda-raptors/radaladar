/// Created by BB on 2016-12-05.

import java.util.ArrayList;
import java.util.Random;

public class Map {
    private int level;
    private int[][] mapFloor;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private Hero hero;
    private ArrayList<Character> entities = new ArrayList<>();

    /// Constructor

    public Map(int level, Hero hero) {
        this.level = level;
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
        this.hero = hero;
        this.entities.add(new Enemy(enemyPlacement(), getMonsterLevel(), true));
        Random random = new Random();
        int numberOfEnemies = 1 + random.nextInt(3);
        for (int i = 0; i < numberOfEnemies; i++) {
            this.entities.add(new Enemy(enemyPlacement(), getMonsterLevel(), false));
        }
        this.entities.add(new Boss(enemyPlacement(), getMonsterLevel()));
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

    private int[] enemyPlacement() {
        Random random = new Random();
        int[] position = new int[2];
        boolean goodPosition = false;
        ArrayList<int[]> usedPositions = getOccupiedCells();
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

    private ArrayList<int[]> getOccupiedCells(){
        ArrayList<int[]> occupiedCells = new ArrayList<>();
        int[] hero = {0, 0};
        occupiedCells.add(hero);
        for (Character entity : entities) {
            occupiedCells.add(entity.position);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (getMapFloor()[i][j] == 1) {
                    int[] wall = new int[2];
                    wall[0] = i;
                    wall[1] = j;
                    occupiedCells.add(wall);
                }
            }
        }
        return occupiedCells;
    }

    private int getMonsterLevel() {
        int monsterLevel = this.level;
        Random random = new Random();
        int chance = random.nextInt(10);
        if (chance > 4 && chance < 9) {
            monsterLevel++;
        } else if (chance > 9) {
            monsterLevel += 2;
        }
        return monsterLevel;
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

    public int getLevel() {
        return level;
    }

}
