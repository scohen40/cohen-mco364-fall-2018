package cohen.paint;

import cohen.paint.Shapes.LineShape;
import cohen.paint.Shapes.RectangleShape;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private ArrayList<LineShape> lines = new ArrayList<>();
    private ArrayList<RectangleShape> rectangles = new ArrayList<>();
//    private ArrayList<ArrayList<Dot>> circles = new ArrayList<>();
    private int lineCounter = 0;
    private int rectangleCounter = 0;
//    private int circleCounter = 0;
    private Color currentColor;


    public Canvas() {
        lines.add(new LineShape());
        rectangles.add(new RectangleShape());
//        circles.add(new ArrayList<>());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintLines(g);
        paintRectangles(g);
//        paintCircles(g);
    }

    public void paintLines(Graphics g) {
        for(int line = 0; line < lines.size(); line++) {
            for(int dot = 1; dot < lines.get(line).getDots().size(); dot++) {
                ArrayList<Dot> currentLine = lines.get(line).getDots();
                g.setColor(lines.get(line).getColor());
                g.drawLine(
                        currentLine.get(dot).getX(),
                        currentLine.get(dot).getY(),
                        currentLine.get(dot-1).getX(),
                        currentLine.get(dot-1).getY());
            }
        }
    }

    public void paintRectangles(Graphics g) {
        for(int rectangle = 1; rectangle < rectangles.size(); rectangle++) {
            RectangleShape currentRec = rectangles.get(rectangle);
            g.setColor(currentRec.getColor());
            g.drawRect(currentRec.getStartLocation().getX(), currentRec.getStartLocation().getY(), currentRec.getWidth(),currentRec.getHeight());
        }
    }

//    public void paintCircles(Graphics g) {
//
//    }

    public void newPencilLine() {
        lines.add(new LineShape(currentColor));
        lineCounter++;
    }

    public void newRectangle() {
        rectangles.add(new RectangleShape(currentColor));
        rectangleCounter++;
    }

//    public void newCircle() {
//        circles.add(new ArrayList<Dot>());
//        circleCounter++;
//    }

    public void drawLine(int x, int y) {
        //add new coords to the current line of dots
        lines.get(lineCounter).getDots().add(new Dot(x, y));
    }

    //do i need this method?
//    public void drawRectangle(int x, int y) {
//        //set the coords and dimentions of the current rectangle on the list
////        lines.get(rectangleCounter).add(new Dot(x, y, currentColor));
//    }

//    public void drawCircle(int x, int y) {
//        //add new coords to the current rectangle list
//        circles.get(circleCounter).add(new Dot(x, y, currentColor));
//    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public ArrayList getRectangles() {
        return rectangles;
    }

    public int getRectangleCounter() {
        return rectangleCounter;
    }

    public RectangleShape getCurrentRectangle(){
        return rectangles.get(rectangleCounter);
    }

}
