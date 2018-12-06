package cohen.paint.tools;

import cohen.paint.Shapes.Dot;
import cohen.paint.Shapes.RectangleShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;

public class RectangleTool implements ShapeTool {
    private RectangleShape rectangle;

    @Override
    public void onMouseDragged(int x, int y) {
        rectangle.setEndLocation(new Dot(x, y));
        rectangle.setDimentions();
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        rectangle = new RectangleShape(color);
        rectangle.setStartLocation(new Dot(x, y));
    }

    @Override
    public void onMouseReleased(int x, int y) {
        rectangle.setEndLocation(new Dot(x, y));
        rectangle.setDimentions();
    }

    @Override
    public Shape getShape() {
        return rectangle;
    }
}
