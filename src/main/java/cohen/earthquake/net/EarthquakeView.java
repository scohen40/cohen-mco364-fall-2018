package cohen.earthquake.net;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;


@Singleton
public class EarthquakeView extends JFrame{

	private JFormattedTextField word = new JFormattedTextField();
	private JButton refresh = new JButton("refresh");
	private JLabel magLabel = new JLabel("Largest Magnitude this Month:");
	private JLabel placeLabel = new JLabel("Place:");
	private JLabel magLabel2 = new JLabel("Largest Magnitude this Week:");
	private JLabel placeLabel2 = new JLabel("Place:");
	private JLabel magLabel3 = new JLabel("Largest Magnitude Today:");
	private JLabel placeLabel3 = new JLabel("Place:");
	private JLabel magLabel4 = new JLabel("Largest Magnitude in the Past Hour:");
	private JLabel placeLabel4 = new JLabel("Place:");
	private JFormattedTextField monthMagText = new JFormattedTextField();
	private JFormattedTextField monthPlaceText = new JFormattedTextField();
	private JFormattedTextField weekMagText = new JFormattedTextField();
	private JFormattedTextField weekPlaceText = new JFormattedTextField();
	private JFormattedTextField todayMagText = new JFormattedTextField();
	private JFormattedTextField todayPlaceText = new JFormattedTextField();
	private JFormattedTextField hourMagText = new JFormattedTextField();
	private JFormattedTextField hourPlaceText = new JFormattedTextField();

	
	
	public EarthquakeView() throws IOException {
		setTitle("Greatest Earthquake Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(8,2));

		panel.add(refresh);
		panel.add(results);
		
		results.add(magLabel);
		results.add(monthMagText);
		results.add(placeLabel);
		results.add(monthPlaceText);
		results.add(magLabel2);
		results.add(weekMagText);
		results.add(placeLabel2);
		results.add(weekPlaceText);
		results.add(magLabel3);
		results.add(todayMagText);
		results.add(placeLabel3);
		results.add(todayPlaceText);
		results.add(magLabel4);
		results.add(hourMagText);
		results.add(placeLabel4);
		results.add(hourPlaceText);

	
		refresh.addActionListener(this::refreshFields);
		
		add(panel);
		
	}
	
	public void refreshFields(ActionEvent event) {
//		controller.refreshData();
	}
	
	public JFormattedTextField getMonthMagText() {
		return monthMagText;
	}
	public JFormattedTextField getMonthPlaceText() {
		return monthPlaceText;
	}	
	public JFormattedTextField getWeekMagText() {
		return weekMagText;
	}
	public JFormattedTextField getWeekPlaceText() {
		return weekPlaceText;
	}
	public JFormattedTextField getDayMagText() {
		return todayMagText;
	}
	public JFormattedTextField getDayPlaceText() {
		return todayPlaceText;
	}
	public JFormattedTextField getHourMagText() {
		return hourMagText;
	}
	public JFormattedTextField getHourPlaceText() {
		return hourPlaceText;
	}
		
	public static void main(String[] args) throws IOException {	
		//Instead of creating the dependencies inside the class, create it outside 
		//use Guice to create objects and wire them together. 

		//the injector creates the view and the controller for me and automatically wires it up
		//to my retrofit and service as described in the EarthquakeModule. 
		Injector injector = Guice.createInjector(new EarthquakeModule());
		
		EarthquakeView view = injector.getInstance(EarthquakeView.class);
		//put in @Singleton before the EarthquakeView name up top in order to make sure there is only one view, because controller also has a view as a member. 
		//So we create 2 views and it doesn't work without the implementation of the Singleton Design Pattern 
		EarthquakeController controller = injector.getInstance(EarthquakeController.class);
		
		controller.refreshData();
		
		view.setVisible(true);	
	}
	
	
}
	



