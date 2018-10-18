package cohen.maze.mazeGUI;

import cohen.maze.Cell;
import cohen.maze.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class AnimatedMaze extends JComponent {
    private Maze maze;
    private Man man;
    private BufferedImage manImage;
    private int componentHeight;
    private int seventhHeight;


    public AnimatedMaze(Maze maze) {
        this.maze = maze;
        man = new Man(maze.getHeight(), maze.getWidth());
    }

    protected void paintComponent(Graphics g) {
        //having trouble loading.
//        try {
//            manImage = ImageIO.read(new File("shortMan.png"));
//        } catch (IOException e) {
//            System.out.println("man image for search button could not be loaded. contact system admin.");
//        }


        super.paintComponent(g);

        componentHeight = this.getHeight();
        seventhHeight = componentHeight/7;


        g.setColor(Color.black);

        paintMaze(g);
        paintMan(g);

    }

    /**
     * The paintMaze() method runs through the generated maze and paints the existing walls.
     * @param g
     */
    void paintMaze(Graphics g) {
        for (int column = 0; column < maze.getHeight(); column++) {
            for (int row = 0; row < maze.getWidth(); row++) {
                Cell current = maze.getMaze()[column][row];
                if(current.isWestWall()) {
                    g.setColor(Color.black);
                    g.drawLine((row+1)*seventhHeight, column*seventhHeight, (row+1)*seventhHeight, column*seventhHeight + seventhHeight);
                }

                if(current.isNorthWall()){
                    g.drawLine((row+1)*seventhHeight, column*seventhHeight,(row+1)*seventhHeight + seventhHeight, column*seventhHeight);
                }

                if(current.isEastWall()) {
                    g.drawLine((row+1)*seventhHeight + seventhHeight, column*seventhHeight, (row+1)*seventhHeight + seventhHeight, column*seventhHeight + seventhHeight);
                }

                if(current.isSouthWall()) {
                    g.drawLine((row+1)*seventhHeight, column*seventhHeight + seventhHeight, (row+1)*seventhHeight + seventhHeight, column*seventhHeight +seventhHeight);
                }

            }

        }
        g.drawOval(man.getColumn()*seventhHeight + (seventhHeight/2), man.getRow()*seventhHeight -(seventhHeight/2), 20, 20);
        paintMan(g);
    }

    //draw man here or in the paint maze method, and just repaint the whole thing when a key is pressed?
    void paintMan(Graphics g) {
        g.drawOval(man.getColumn()*seventhHeight + (seventhHeight/2), man.getRow()*seventhHeight -(seventhHeight/2), 20, 20);
    }

    public Man getMan() {
        return man;
    }
}
