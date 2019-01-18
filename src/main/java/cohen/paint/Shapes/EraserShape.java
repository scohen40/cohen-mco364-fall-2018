package cohen.paint.Shapes;

import java.awt.*;
import java.io.Serializable;

public class EraserShape extends LineShape implements Serializable {

    public EraserShape() {
        super(new Color(238, 238, 238));
    }

    @Override
    public void paintShape(Graphics g) {
//        g.setColor(getColor());
        g.setColor(new Color(238, 238, 238));

        for(int d = 1; d < getDots().size(); d++) {
            g.fillRect(
                    getDots().get(d).getX(),
                    getDots().get(d).getY(),
                    40, 40);
        }
    }
}

