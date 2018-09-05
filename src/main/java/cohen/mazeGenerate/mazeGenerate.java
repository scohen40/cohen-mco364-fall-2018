/*
Generate and show a maze, using the simple Depth-first search algorithm.

1. Start at a random cell.
2. Mark the current cell as visited, and get a list of its neighbors. For each neighbor, starting with a randomly
selected neighbor:
    If that neighbor hasn't been visited, remove the wall between this cell and that neighbor, and then recurse with that
    neighbor as the current cell.
 */
package cohen.mazeGenerate;

public class mazeGenerate {
    private int[][] maze;
    private int height;
    private int width;

    public mazeGenerate(int height, int width) {
        this.height = height;
        this.width = width;
        maze = generateMaze();
    }

    public int[][] generateMaze() {
        int[][] maze = new int[height][width];
        //Initialize
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {

            }
        }


        return maze;
    }
}
