package cohen.paint.Shapes;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.min;

public class FilledRectangleShape extends RectangleShape implements Serializable {

    public FilledRectangleShape(Color color) {
        super(color);
    }

    @Override
    public void paintShape(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(
                min(getX1(), getX2()),
                min(getY1(), getY2()),
                Math.abs(getX1() - getX2()),
                Math.abs(getY1() - getY2()) );
    }
}
