package cohen.earthquake.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import cohen.earthquake.EarthquakeFeedModel;

/**
 * This is code to download the GeoJSON file directly from the web, not from a local file.
 * @author sc
 */
//public class EarthquakeClient {
//	public static void main(String[] args) throws IOException {
//
//		//URL class encapsulates a url
//		URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
//		//opens up a web-style connection. internally it uses a socket, but it's made in a way that we don't have to worry about http difficulties,
//		//that would come up with using a socket.
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//		//how we read from our connection
//		InputStream in = connection.getInputStream();
//		//pipe into buffered reader to read easier
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		//Gson and Earthquake feed to noget the actual json info
//		Gson gson = new Gson();
//		EarthquakeFeed feed = gson.fromJson(reader, EarthquakeFeed.class);
//
//		System.out.println(
//				feed.getFeatures()
//				.stream()
//				.filter(e -> e.getProperties().getMag() >= 5)
//				.count());
//
//	}

//}
