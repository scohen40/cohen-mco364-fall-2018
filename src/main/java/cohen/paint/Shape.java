package cohen.paint;

import java.awt.*;

public abstract class Shape {
    private Color color;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    public void paint(Graphics g) {
        g.setColor(color);
    }
}
