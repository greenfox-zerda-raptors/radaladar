/// Created by BB on 2016-12-05.

import java.util.ArrayList;

public class Map {
    private static int level = 0;
    private int[][] mapFloor;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private Hero hero;
    private ArrayList<GameObject> entities = new ArrayList<>();

    public Map() {
        level += 1;
        this.mapFloor = this.generateMapFloor();
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
        this.entities.add(this.hero);
    }

    private int[][] generateMapFloor() {

//        MazeObj m = new MazeObj(12,12);
//        m.generate();
//        int[][] map = new int[10][10];
//        for (int i = 1; i < 11; i++){
//            for (int j = 1; j < 11; j++) {
//                map[i-1][j-1] = m.getData()[i][j];
//            }
//        }

        int[][] map = new int[][] {
                {0,0,0,1,0,0,0,1,1,0},
                {0,1,0,0,0,1,0,1,1,0},
                {0,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,1,1,1,0,1},
                {1,1,1,1,0,1,0,1,1,0},
                {0,1,0,1,0,0,0,1,1,0},
                {0,1,0,1,0,1,1,0,1,0},
                {0,0,0,0,0,1,1,0,1,0},
                {0,1,1,1,0,0,0,0,1,0},
                {0,0,0,1,1,1,1,0,0,0},
        };
        return map;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    public ArrayList<GameObject> getEntities() {
        return entities;
    }
    public Hero getHero() {
        return hero;
    }
    public int[][] getMapFloor(){
        return mapFloor;
    }
}
