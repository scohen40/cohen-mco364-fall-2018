package cohen.paint;

import cohen.paint.Shapes.Shape;
import cohen.paint.tools.LineTool;
import cohen.paint.tools.ShapeTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent implements MouseMotionListener, MouseListener {

    private ArrayList<Shape> shapes = new ArrayList<>();
    private Color currentColor;
    private ShapeTool currentShapeTool;


    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.currentShapeTool = new LineTool();
        currentColor = Color.black;

        shapes.add(new Shape(currentColor)); //add null shape as a buffer
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintShapes(g);
    }

    public void paintShapes(Graphics g) {
        for(Shape shape : shapes) {
            shape.paintShape(g);
        }
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void setCurrentShapeTool(ShapeTool shapeTool) {
        this.currentShapeTool = shapeTool;
    }

    public void undoLastShape() {
        if(!shapes.isEmpty()) {
            shapes.remove(shapes.size()-1);
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentShapeTool.onMouseDragged(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentShapeTool.onMousePressed(e.getX(), e.getY(), currentColor);
        shapes.add(currentShapeTool.getShape());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentShapeTool.onMouseReleased(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
