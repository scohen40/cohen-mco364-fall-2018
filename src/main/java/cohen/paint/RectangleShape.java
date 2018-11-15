package cohen.paint;

import java.awt.*;

public class RectangleShape extends Shape {
    private Dot startLocation;
    private Dot endLocation;
    private int x;
    private int y;
    private int height;
    private int width;

    private Color color;

    public RectangleShape() {
        super();
    }

    public RectangleShape(Color color) {
        this.color = color;
    }

    public void setDimentions() {
        width = Math.abs(startLocation.getX() - endLocation.getX());
        height = Math.abs(startLocation.getY() - endLocation.getY());
    }

    public Dot getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Dot startLocation) {
        this.startLocation = startLocation;
    }

    public Dot getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Dot endLocation) {
        this.endLocation = endLocation;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
