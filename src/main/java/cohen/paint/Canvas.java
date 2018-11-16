package cohen.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent implements MouseListener, MouseMotionListener {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Tool tool = null;
    private Color currentColor = Color.BLACK; //default color

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintShapes(g);
    }

    public void paintShapes(Graphics g) {
        for (Shape shape : shapes) {
            shape.paint(g);
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

    public Shape getCurrentShape(){
        return shapes.get(shapeCounter);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
