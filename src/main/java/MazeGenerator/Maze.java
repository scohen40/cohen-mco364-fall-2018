package MazeGenerator;

import java.util.Scanner;

public class Maze {
    private static int height;
    private static int width;
//    private static GenerateMaze generator;
    private static int[][] maze;

    /**
     * Gets entries for height and width from the user. Then checks if they are odd. If they are,
     * the method is over. If they aren't it calls itself again.
     */
    public static void getDimensions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an odd number of rows: ");
        height = scanner.nextInt();
        System.out.println("Please enter an odd number of columns");
        width = scanner.nextInt();

        //entry validation
        isOdd(height, width);
    }

    /**
     * checks if the entries for height and width are odd
     *
     * @param height
     * @param width
     * @return isOdd
     */
    public static boolean isOdd(int height, int width) {
        boolean isOdd;
        if ((height % 2 != 0) && (width % 2 != 0)) {
            isOdd = true;
        } else {
            isOdd = false;
            System.out.println("Height and Width must both be odd. Please, try again.");
            getDimensions();
        }
        return isOdd;
    }

    /**
     * getMaze copies the generated maze into this main class
     *
     * @param m the generated maze
     */
    public static void getMaze(int[][] m) {
        maze = m;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                maze[i][j] = m[i][j];
//            }
//        }
    }

    /**
     * printMaze prints the generated maze to the console
     *
     * @param m the generated maze
     */
    public static void printMaze(int[][] m) {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j]);
            }
        }
    }


    public static void main(String args[]) {
//        getDimensions();
        GenerateMaze generator = new GenerateMaze(7, 7);
        getMaze(generator.getMaze());
        printMaze(maze);
    }
}

