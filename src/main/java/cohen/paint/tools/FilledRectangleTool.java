package cohen.paint.tools;

import cohen.paint.Shapes.FilledRectangleShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;

public class FilledRectangleTool implements ShapeTool {
    private FilledRectangleShape filledRectangleShape;

    @Override
    public void onMouseDragged(int x, int y) {
        filledRectangleShape.setXY2(x, y);
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        filledRectangleShape = new FilledRectangleShape(color);
        filledRectangleShape.setXY1(x, y);
    }

    @Override
    public void onMouseReleased(int x, int y) {
        filledRectangleShape.setXY2(x, y);
    }

    @Override
    public Shape getShape() {
        return filledRectangleShape;
    }

}
