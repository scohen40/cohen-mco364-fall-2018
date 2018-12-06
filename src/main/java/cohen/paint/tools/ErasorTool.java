package cohen.paint.tools;

import cohen.paint.Shapes.Dot;
import cohen.paint.Shapes.ErasorShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class ErasorTool implements ShapeTool{
    private ErasorShape erasorShape;

    public ErasorTool() {
    }

    @Override
    public void onMouseDragged(int x, int y) {
        erasorShape.getDots().add(new Dot(x, y));
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        erasorShape = new ErasorShape();
        ArrayList<Dot> dots = new ArrayList<>();
        dots.add(new Dot(x, y));
        erasorShape.setDots(dots);
        erasorShape.setColor(color);
    }

    @Override
    public void onMouseReleased(int x, int y) {}

    @Override
    public Shape getShape() {
        return erasorShape;
    }
}
