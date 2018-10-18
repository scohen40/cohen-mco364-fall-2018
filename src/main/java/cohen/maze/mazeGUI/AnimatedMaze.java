package cohen.maze.mazeGUI;

import cohen.maze.Cell;
import cohen.maze.Maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class AnimatedMaze extends JComponent {
    private Maze maze;
    private Man man;
    private BufferedImage manImage;
    private int componentHeight;
    private int seventhHeight;


    public AnimatedMaze(Maze maze, Man man) {
        this.maze = maze;
        this.man = man;
    }

    protected void paintComponent(Graphics g) {
        //having trouble loading.
        try {
            manImage = ImageIO.read(new File("src/images/shortMan.png"));
        } catch (IOException e) {
            System.out.println("man image for search button could not be loaded. contact system admin.");
        }


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
    }

    void paintMan(Graphics g) {
//        g.drawOval(man.getColumn()*seventhHeight + (seventhHeight/2), man.getRow()*seventhHeight - (seventhHeight/2), 20, 20);
        g.drawImage(manImage,man.getColumn()*seventhHeight + (seventhHeight/2), man.getRow()*seventhHeight - (int)(seventhHeight/1.5), null);
    }

    public Man getMan() {
        return man;
    }
}
