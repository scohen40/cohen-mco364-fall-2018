package cohen.maze.mazeGUI;

public class Man {
    //location
    private int row;
    private int column;
    //location details
    private int height;
    private int width;
    private Direction direction;

    public Man(int height, int width){
        this.row = 1;
        this.column = 1;
        this.height = height;
        this.width = width;
    }

    //direction
    //movement
    //if the man isn't standing on the last cell, move forward. if not the game is over.
    public boolean isFinished() {
        if(row == height && column == width) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
