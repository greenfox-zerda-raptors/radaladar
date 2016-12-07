/// Created by BB on 2016-12-07.

public class MazeObj{

    private static final int WALL = 0;
    private static final int SPACE = 1;

    private int[][] data;
    private int width;
    private int height;
    private java.util.Random rand = new java.util.Random();

    public MazeObj(int width, int height) {
        this.width = width;
        this.height = height;
        data = new int[width][];
    }

    private void carve(int x, int y) {

        final int[] upx = { 1, -1, 0, 0 };
        final int[] upy = { 0, 0, 1, -1 };

        int dir = rand.nextInt(4);
        int count = 0;
        while(count < 4) {
            final int x1 = x + upx[dir];
            final int y1 = y + upy[dir];
            final int x2 = x1 + upx[dir];
            final int y2 = y1 + upy[dir];
            if(data[x1][y1] == WALL && data[x2][y2] == WALL) {
                data[x1][y1] = SPACE;
                data[x2][y2] = SPACE;
                carve(x2, y2);
            } else {
                dir = (dir + 1) % 4;
                count += 1;
            }
        }
    }

    public void generate() {
        for(int x = 0; x < width; x++) {
            data[x] = new int[height];
            for(int y = 0; y < height; y++) {
                data[x][y] = WALL;
            }
        }
        for(int x = 0; x < width; x++) {
            data[x][0] = SPACE;
            data[x][height - 1] = SPACE;
        }
        for(int y = 0; y < height; y++) {
            data[0][y] = SPACE;
            data[width - 1][y] = SPACE;
        }

        data[2][2] = SPACE;
        carve(2, 2);

        data[2][1] = SPACE;
        data[width - 3][height - 2] = SPACE;
    }

    public int[][] getData() {
        return data;
    }
}
