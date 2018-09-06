/*
Generate and show a maze, using the simple Depth-first search algorithm.

1. Start at a random cell.
2. Mark the current cell as visited, and get a list of its neighbors. For each neighbor, starting with a randomly
selected neighbor:
    If that neighbor hasn't been visited, remove the wall between this cell and that neighbor, and then recurse with that
    neighbor as the current cell.
 */
package cohen.MazeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GenerateMaze {
    private int[][] maze;
    private int height;
    private int width;

    public GenerateMaze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = generateMaze();
    }

    public int[][] generateMaze() {
        int[][] maze = new int[height][width];
        //Initialize
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                maze[i][j] = 1;
            }
        }

        //Find the starting point to start digging.
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

        generatePath(row, column);

        return maze;
    }

    public void generatePath(int row, int column){
        //generate four random directions
        Integer[] randDirs = generateRandomDirections();
        //examine each direction
        for(int i = 0; i < randDirs.length;i++) {
            switch (randDirs[i]) {
                case 1: //Up
                    //whether two cells up is in the maze or not
                    if(r - 2 <= 0) {
                        continue;
                    }
                    if(maze[row - 2][column] != 0) {
                        maze[row - 2][column]= 0;
                        maze[row - 1][column]= 0;
                    }
                    break;

                case 2: //Right
                    //whether two cells right is in the maze or not
                    if(column + 2 >= 2)
                        continue;
                    }
                    if(maze[row][column + 2] != 0) {
                        maze[row][column +2] = 0;
                        maze[row][column +1] = 0;
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

}
