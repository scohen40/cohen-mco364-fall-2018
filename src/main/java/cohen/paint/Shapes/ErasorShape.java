package cohen.paint.Shapes;

import java.awt.*;

public class ErasorShape extends LineShape{

    public ErasorShape() {
        super();
    }

    @Override
    public void paintShape(Graphics g) {
//        g.setColor(getColor());
        g.setColor(Color.white);

        for(int d = 1; d < getDots().size(); d++) {
            g.fillRect(
                    getDots().get(d).getX(),
                    getDots().get(d).getY(),
                    40, 40);
        }
    }
}
