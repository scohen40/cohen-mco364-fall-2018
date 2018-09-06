/*
Generate and show a maze, using the simple Depth-first search algorithm.

1. Start at a random cell.
2. Mark the current cell as visited, and get a list of its neighbors. For each neighbor, starting with a randomly
selected neighbor:
    If that neighbor hasn't been visited, remove the wall between this cell and that neighbor, and then recurse with that
    neighbor as the current cell.
 */
package MazeGenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class GenerateMaze {
    private int[][] maze;
    private int height;
    private int width;
//    private Stack<Cell> pathTrack;
//    private ArrayList<Cell> visited;

    //this class only accepts an odd number of rows and columns
    public GenerateMaze(int height, int width) {
        if(isOdd(height, width)) {
            this.height = height;
            this.width = width;
//            pathTrack = new Stack<>();
//            visited = new ArrayList<>();
            maze = new int[height][width];
            maze = generateMaze();
            printMaze();
        }
    }

    public void printMaze() {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j]);
            }
        }
    }

    public boolean isOdd(int height, int width) {
        return (height % 2 != 0) && (width % 2 != 0);
    }

    public int[][] generateMaze() {

        //Initialize
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                maze[i][j] = 1;
            }
        }

        //Find the (odd) starting point to start digging.
        Random rand = new Random();
        int row = rand.nextInt(height);
        while(row % 2 == 0) {
            row = rand.nextInt(height);
        }
        int column = rand.nextInt(width);
        while(column % 2 ==0) {
            column = rand.nextInt(width);
        }
        //starting cell
        maze[row][column] = 0;

//        do {
            generatePath(row, column);
//        }
//        while(visited.size() < (height*width));
//
        return maze;
    }

    //Depth-First Searching and Backtracking Algorithm
    public void generatePath(int row, int column){
        //generate four random directions
        Integer[] randDirs = generateRandomDirections();
        //examine each direction
        for(int i = 0; i < randDirs.length;i++) {
            switch (randDirs[i]) {
                case 1: //Up
                    //whether two cells up is in the maze or not
                    if (row - 2 <= 0) {
                        continue;
                    }
                    if (maze[row - 2][column] != 0) {
                        maze[row - 2][column] = 0;
                        maze[row - 1][column] = 0;
                        generatePath(row - 2, column);
                    }
                    break;
                case 2: //Right
                    //whether two cells right is in the maze or not
                    if (column + 2 >= width - 1) { //alternative: (column + 2 >= width - 1) ??
                        continue;
                    }
                    if (maze[row][column + 2] != 0) {
                        maze[row][column + 2] = 0;
                        maze[row][column + 1] = 0;
                        generatePath(row, column + 2);
                    }
                    break;
                case 3: //Down
                    //whether two cells down is in the maze or not
                    if (row + 2 >= height - 1) {//alternative: (row + 2 >= height - 1) ??
                        continue;
                    }
                    if (maze[row + 2][column] != 0) {
                        maze[row + 2][column] = 0;
                        maze[row + 1][column] = 0;
                        generatePath(row + 2, column);
                    }
                    break;
                case 4: //Left
                    //whether two cells left is in the maze or not
                    if (column - 2 <= 0) {
                        continue;
                    }
                    if (maze[row][column - 2] != 0) {
                        maze[row][column - 2] = 0;
                        maze[row][column - 1] = 0;
                        generatePath(row, column - 2);
                    }
                    break;
            }
        }
    }

    /**
     * Generate an array with random directions 1-4
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

    public int[][] getMaze() {
        return maze;
    }

}
