//package cohen.earthquake.lasthighest;
//
//import cohen.earthquake.Earthquake;
//import cohen.earthquake.EarthquakeProperties;
//import cohen.earthquake.net.EarthquakeView;
//
//import javax.swing.*;
//import java.util.List;
//
//import static com.sun.tools.internal.xjc.reader.Ring.add;
//import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
//
//public class LastHighestView {
//    private JLabel fields[] = new JLabel[5];
//
//
//    public LastHighestView(LastHighestController controller) {
//        setTitle("Last Highest Earthquake View");
//        setSize(800, 600);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//
//        for(int i = 0; i < fields.length; i++) {
//            fields[i] = new JLabel();
//            panel.add(fields[i]);
//        }
//
//        add(panel);
//
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                LastHighestController.refresh();
//                try {
//                    sleep(30_000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        //or use a timer
//    }
//
//
//
//
//    public void setEarthquakes(List<Earthquake> earthquakeList) {
//        for(int i = 0; i < fields.length && i < earthquakeList.size(); i++) {
//            EarthquakeProperties properties = earthquakeList.get(i).getProperties;
//            fields[i].setText(properties).getMag() + " " + properties.getPlace();
//        }
//    }
//
//
//
//}
//
//
//public static void main(String[] args) {
//    view.setVisible(true);
//}