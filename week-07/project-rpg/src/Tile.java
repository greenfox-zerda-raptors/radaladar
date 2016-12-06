/// Created by BB on 2016-12-05.

public class Tile {
    private boolean isWall;
    private boolean isOccupied;
    private String image;

    public Tile(boolean isWall) {
        this.isWall = isWall;
        this.setImage();
    }

    private void setImage(){
        if (this.isWall) {
            this.image = "src/images/wall.png";
        } else {
            this.image = "src/images/floor.png";
        }
    }

    public String getImage() {
        return image;
    }
}