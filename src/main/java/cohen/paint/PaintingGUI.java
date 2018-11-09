package cohen.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        JButton button = new JButton("Pick to Change Background");

        button.addActionListener(this::changeColor);
        panel.add(button, BorderLayout.NORTH);


        painting.addMouseListener(this);
        painting.addMouseMotionListener(this);


        setContentPane(panel);
    }

    private void changeColor(ActionEvent actionEvent) {
        Color newColor = JColorChooser.showDialog(
                PaintingGUI.this,
                "Choose Background Color",
                Color.black);
        painting.setCurrentColor(newColor);
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