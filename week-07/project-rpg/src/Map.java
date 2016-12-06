/// Created by BB on 2016-12-05.

public class Map {
    private static int level = 0;
    private int[][] mapFloor;
    private Tile[][] mapTiles = new Tile[10][10];

    public Map() {
        level += 1;
        this.mapFloor = this.generateMapFloor();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.mapFloor[i][j] == 1) {
                    this.mapTiles[i][j] = new Tile(true);
                } else {
                    this.mapTiles[i][j] = new Tile(false);
                }
            }
        }
    }

    private int[][] generateMapFloor() {
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

    public Tile getTile(int x, int y) {
        return this.mapTiles[x][y];
    }
}
