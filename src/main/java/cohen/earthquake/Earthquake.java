package cohen.earthquake;

public class Earthquake {
	private String id;
	private EarthquakeProperties properties;
	
	public Earthquake(double magnitude, String place, long time) {
		properties = new EarthquakeProperties(magnitude, place, time);	
	}
	
	public String getId() {
		return id;
	}
	public EarthquakeProperties getProperties() {
		return properties;
	}

	public double getMagnitude () {
		return properties.getMag();
	}


}
