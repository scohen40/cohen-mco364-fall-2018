package cohen.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private ArrayList<Shape> shapes = new ArrayList<>();

    private int shapeCounter = 0;

    private Color currentColor = Color.BLACK; //default color


    public Canvas() {
        shapes.add(new Shape()); //add null shape as a buffer
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintShapes(g);
    }

    public void paintShapes(Graphics g) {
        for(int shape = 1; shape < shapes.size(); shape++) {
            if(shapes.get(shape).getShapeType().equals(ShapeType.Line)) {
                LineShape line = (LineShape)shapes.get(shape);

                for(int dot = 1; dot < line.getDots().size(); dot++) {
                    ArrayList<Dot> currentLine = line.getDots();
                    g.setColor(line.getColor());
                    g.drawLine(
                            currentLine.get(dot).getX(),
                            currentLine.get(dot).getY(),
                            currentLine.get(dot-1).getX(),
                            currentLine.get(dot-1).getY());
                }
            }
            else if(shapes.get(shape).getShapeType().equals(ShapeType.Rectangle)) {
                RectangleShape rectangle = (RectangleShape)shapes.get(shape);

                g.setColor(rectangle.getColor());
                g.drawRect(rectangle.getStartLocation().getX(), rectangle.getStartLocation().getY(), rectangle.getWidth(),rectangle.getHeight());
            }
        }
    }

    public void addShape(ShapeType shapeType) {
        if(shapeType.equals(ShapeType.Line)) {
            shapes.add(new LineShape(currentColor, shapeType));
            shapeCounter++;
        }
        else if(shapeType.equals(ShapeType.Rectangle)) {
            shapes.add(new RectangleShape(currentColor, shapeType));
            shapeCounter++;
        }
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public ArrayList getShapes() {
        return shapes;
    }

    public Shape getCurrentShape(){
        return shapes.get(shapeCounter);
    }

}
