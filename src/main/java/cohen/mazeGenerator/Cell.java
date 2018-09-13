package cohen.mazeGenerator;

public class Cell {
    //coordinates
    private int x;
    private int y;
    //cell status
    private boolean visited;
    //cell walls status
    private boolean northWall;
    private boolean southWall;
    private boolean eastWall;
    private boolean westWall;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        visited =  false;
        northWall= true;
        southWall= true;
        eastWall = true;
        westWall = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isNorthWall() {
        return northWall;
    }

    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    public boolean isSouthWall() {
        return southWall;
    }

    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    public boolean isEastWall() {
        return eastWall;
    }

    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    public boolean isWestWall() {
        return westWall;
    }

    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

}
