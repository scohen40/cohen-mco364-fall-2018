package cohen.mazeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Maze {
    private Cell[][] maze;
    private int height;
    private int width;

    //generate the full 2d array of cell objects. all the 'visited's are false and all the walls are true(that's done in the cells constructor).

    public Maze(int height, int width) {
        //initialize the number of rows and columns in the maze with the numbers entered
        this.height = height;
        this.width = width;

        //initialize the 2d maze with the number of spaces allocated by the height and width entered
        maze = new Cell[height][width];
        //fill the maze with cells
        generateMaze();
        //dig a an open path through the maze
        generatePath();
        //print the maze in the console
        printMaze();
    }

    /**
     * The generateMaze method fills the maze with unvisited, walled cells.
     */
    public void generateMaze() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                maze[i][j] = new Cell(i, j);
            }
        }
    }

    /**
     * The generatePath method digs or generates a random open path through the maze of cells.
     */
    private void generatePath() {
        //Find the starting point to start digging.
        Random rand = new Random();
        int row = rand.nextInt(height);
        int col = rand.nextInt(width);

        //starting cell
        maze[row][col].setVisited(true);

        //start digging the path
        dig(row, col);

    }

    //Depth-First Searching Algorithm that digs in increments of 1
    public void dig(int row, int column){
        //generate four random directions
        Integer[] randDirs = generateRandomDirections();
        //examine each direction
        for(int i = 0; i < randDirs.length;i++) {
            switch (randDirs[i]) {
                case 1: //Up
                    //whether one cells up is in the maze or not
                    if (row - 1 <= 0) {
                        continue;
                    }
                    //whether one cells up has been visited
                    if (!maze[row - 1][column].isVisited()) {
                        maze[row - 1][column].setVisited(true);
                        maze[row][column].setNorthWall(false);
                        maze[row - 1][column].setSouthWall(false);
                        dig(row - 1, column);
                    }
                    break;
                case 2: //Right
                    //whether one cells right is in the maze or not
                    if (column + 1 >= width - 1) { //alternative: (column + 2 >= width - 1) ??
                        continue;
                    }
                    //whether one cells right has been visited
                    if (!maze[row][column + 1].isVisited()) {
                        maze[row][column + 1].setVisited(true);
                        maze[row][column].setEastWall(false);
                        maze[row][column + 1].setWestWall(false);
                        dig(row, column + 1);
                    }
                    break;
                case 3: //Down
                    //whether one cells down is in the maze or not
                    if (row + 1 >= height - 1) {//alternative: (row + 2 >= height - 1) ??
                        continue;
                    }
                    //whether one cells down has been visited
                    if (!maze[row + 1][column].isVisited()) {
                        maze[row + 1][column].setVisited(true);
                        maze[row][column].setSouthWall(false);
                        maze[row + 1][column].setNorthWall(false);
                        dig(row + 1, column);
                    }
                    break;
                case 4: //Left
                    //whether one cells left is in the maze or not
                    if (column - 1 <= 0) {
                        continue;
                    }
                    //whether one cells left has been visited
                    if (!maze[row][column - 1].isVisited()) {
                        maze[row][column - 1].setVisited(true);
                        maze[row][column].setWestWall(false);
                        maze[row][column - 1].setEastWall(false);
                        dig(row, column - 1);
                    }
                    break;
            }
        }
    }

    /**
     * The generateRandomDirections() class generates an array with random directions 1-4
     * @return Array containing 4 directions in random order
     */
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            randoms.add(i + 1);
        }
        Collections.shuffle(randoms);
        return randoms.toArray(new Integer[4]);
    }

    /**
     * The printMaze() method prints out the maze of cells generated by the GenerateMaze class, to the console.
     */
    public void printMaze() {
        for (int i = 0; i < height; i++) {
            System.out.print(" _");
        }
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                Cell current = maze[i][j];
                StringBuilder string = new StringBuilder();
                if(current.isWestWall()){
                    string.append("|");
                }
                else {
                    string.append(" ");
                }
                if(current.isSouthWall()) {
                    string.append("_");
                }
                else{
                    string.append(" ");
                }
                System.out.print(string);
//                System.out.print("|");
            }
        }
    }

}
