package cohen.paint.tools;

import cohen.paint.Shapes.RectangleShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;

public class RectangleTool implements ShapeTool {
    private RectangleShape rectangle;

    @Override
    public void onMouseDragged(int x, int y) {
        rectangle.setXY2(x, y);
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        rectangle = new RectangleShape(color);
        rectangle.setXY1(x, y);
    }

    @Override
    public void onMouseReleased(int x, int y) {
        rectangle.setXY2(x, y);
    }

    @Override
    public Shape getShape() {
        return rectangle;
    }
}
