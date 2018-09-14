//package cohen.earthquake.net;
//
////import java.awt.event.ActionEvent;
//import java.util.Comparator;
////import java.util.Optional;
//import java.util.List;
//import java.util.stream.Collector;
//
//import javax.swing.text.JTextComponent;
//
//import com.google.inject.Inject;
//
//import cohen.earthquake.Earthquake;
//import cohen.earthquake.EarthquakeFeedModel;
////import cohen.earthquake.EarthquakeProperties;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class EarthquakeController {
//	private EarthquakeView view;
//	private USGSEarthquakeService service;
//
//	@Inject
//	EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
//		this.view = view;
//		this.service = service;
//	}
//
//	public void refreshData() {
//		requestMonth();
//		requestWeek();
//		requestDay();
//		requestHour();
//	}
//
//	void requestMonth() {
//		requestEarthquakeFeed(service.getAllMonth(),
//				view.getMonthMagText(),
//				view.getMonthPlaceText());
//	}
//	private void requestWeek() {
//		requestEarthquakeFeed(service.getAllWeek(),
//				view.getWeekMagText(),
//				view.getWeekPlaceText());
//	}
//	private void requestDay() {
//		requestEarthquakeFeed(service.getAllDay(),
//				view.getDayMagText(),
//				view.getDayPlaceText());
//	}
//	private void requestHour() {
//		requestEarthquakeFeed(service.getAllHour(),
//				view.getHourMagText(),
//				view.getHourPlaceText());
//	}
//
//
//
//	private void requestEarthquakeFeed(Call<EarthquakeFeedModel> call,
//									   final JTextComponent magnitudeField,
//									   final JTextComponent placeField)
//	{
//		call.enqueue(new Callback<EarthquakeFeedModel>() {
//			@Override
//			public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response) {
//				EarthquakeFeedModel feed = response.body();
//
//				showLargestEarthquake(magnitudeField, placeField, feed);
//
//			}
//
//			@Override
//			public void onFailure(Call<EarthquakeFeedModel> call, Throwable t) {
//				t.printStackTrace();
//
//			}
//
//		});
//
//	}
//
//	void showLargestEarthquake(JTextComponent magnitudeField,
//			JTextComponent placeField,
//			EarthquakeFeedModel feed)
//	{
//		List<Earthquake> earthquakes = feed.getFeatures().stream()
//				.filter(earthquake -> earthquake.getProperties().getMag() >= 3)
//				.sorted(Comparator.comparing(Earthquake::getMagnitude).reversed())
//				.limit(5)
//				.collect(Collector.toList());
//
//		magnitudeField.setText(String.valueOf(largest.get().getProperties().getMag()));
//		placeField.setText(String.valueOf(largest.get().getProperties().getPlace()));
//		//viewProvider.get().setEarthquakes(earthquakes);
//	}
//
//}
//
//
