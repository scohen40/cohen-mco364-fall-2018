package cohen.earthquake.lastHighest;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeProperties;
import cohen.earthquake.net.EarthquakeModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import javax.inject.Inject;
import javax.swing.*;
import java.util.List;

@Singleton
public class LastHighestView extends JFrame //implements WindowListener
{
    private static final long serialVersionUID = 6111006689421939040L;
    private final Timer timer;
    private JLabel fields[] = new JLabel[5];

    @Inject
    public LastHighestView(LastHighestController controller)
    {
        setTitle("Largest Earthquakes");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i=0; i<fields.length; i++) {
            fields[i] = new JLabel();
            panel.add(fields[i]);
        }

        add(panel);

        timer = new Timer(30_000, (event) -> controller.refreshData());
        timer.setInitialDelay(0);
        timer.start();
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        for (int i=0; i<fields.length && i<earthquakes.size(); i++) {
            EarthquakeProperties properties = earthquakes.get(i).getProperties();
            fields[i].setText(properties.getMag() + " " + properties.getPlace());
        }
    }


    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new EarthquakeModule());

        LastHighestView view = injector.getInstance(LastHighestView.class);

        view.setVisible(true);
    }

}