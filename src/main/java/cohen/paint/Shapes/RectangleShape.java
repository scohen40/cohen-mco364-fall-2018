package cohen.paint.Shapes;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.min;

public class RectangleShape extends Shape implements Serializable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public RectangleShape(Color color) {
        super(color);

    }

    public void setXY1(int x, int y) {
        this.x1 = x;
        this.y1 = y;
    }

    public void setXY2(int x, int y) {
        this.x2 = x;
        this.y2 = y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public void paintShape(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect(
                min(x1, x2),
                min(y1, y2),
                Math.abs(x1 - x2),
                Math.abs(y1 - y2));
    }
}
