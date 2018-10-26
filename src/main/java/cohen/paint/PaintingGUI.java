package cohen.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PaintingGUI extends JFrame implements MouseMotionListener {
    private Canvas painting;

    public PaintingGUI() {
        setTitle("Paint Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        painting = new Canvas();
        panel.add(painting, BorderLayout.CENTER);

        //print mouse location when you move the mouse over your canvas
        painting.addMouseMotionListener(this);

        setContentPane(panel);
    }

    public static void main(String args[]) {
        new PaintingGUI().setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        painting.draw(e.getX(), e.getY());
        painting.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}