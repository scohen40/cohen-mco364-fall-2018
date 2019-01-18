package cohen.paint.tools;

import cohen.paint.Shapes.Dot;
import cohen.paint.Shapes.EraserShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class ErasorTool implements ShapeTool{
    private EraserShape eraserShape;

    public ErasorTool() {
    }

    @Override
    public void onMouseDragged(int x, int y) {
        eraserShape.getDots().add(new Dot(x, y));
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        eraserShape = new EraserShape();
        ArrayList<Dot> dots = new ArrayList<>();
        dots.add(new Dot(x, y));
        eraserShape.setDots(dots);
        eraserShape.setColor(color);
    }

    @Override
    public void onMouseReleased(int x, int y) {}

    @Override
    public Shape getShape() {
        return eraserShape;
    }
}
