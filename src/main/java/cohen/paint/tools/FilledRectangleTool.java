package cohen.paint.tools;

import cohen.paint.Shapes.Dot;
import cohen.paint.Shapes.FilledRectangleShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;

public class FilledRectangleTool implements ShapeTool {
    private FilledRectangleShape filledRectangleShape;

    public FilledRectangleShape getFilledRectangleShape() {
        return filledRectangleShape;
    }

    public void setFilledRectangleShape(FilledRectangleShape filledRectangleShape) {
        this.filledRectangleShape = filledRectangleShape;
    }

    @Override
    public void onMouseDragged(int x, int y) {
        filledRectangleShape.setEndLocation(new Dot(x, y));
        filledRectangleShape.setDimentions();
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        filledRectangleShape = new FilledRectangleShape(color);
        filledRectangleShape.setStartLocation(new Dot(x, y));
    }

    @Override
    public void onMouseReleased(int x, int y) {
        filledRectangleShape.setEndLocation(new Dot(x, y));
        filledRectangleShape.setDimentions();
    }

    @Override
    public Shape getShape() {
        return filledRectangleShape;
    }

}
