package cohen.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintingGUI extends JFrame implements MouseMotionListener, MouseListener {
    private Canvas painting;

    public PaintingGUI() {
        setTitle("Paint Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        painting = new Canvas();
        panel.add(painting, BorderLayout.CENTER);


        painting.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        painting.newPencilLine();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}