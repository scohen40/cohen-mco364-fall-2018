package cohen.paint.Shapes;

import java.awt.*;

public class FilledRectangleShape extends RectangleShape {

    public FilledRectangleShape(Color color) {
        super(color);
    }

    @Override
    public void paintShape(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(
                this.getStartLocation().getX(),
                this.getStartLocation().getY(),
                this.getWidth(),
                this.getHeight());
    }
}
