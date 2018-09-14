package cohen.earthquake.net;

import cohen.earthquake.EarthquakeFeedModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface USGSEarthquakeService {

	@GET("earthquakes/feed/v1.0/summary/all_month.geojson")
	Call<EarthquakeFeedModel> getAllMonth();

	@GET("earthquakes/feed/v1.0/summary/all_week.geojson")
	Call<EarthquakeFeedModel> getAllWeek();

	@GET("earthquakes/feed/v1.0/summary/all_day.geojson")
	Call<EarthquakeFeedModel> getAllDay();

	@GET("earthquakes/feed/v1.0/summary/all_hour.geojson")
	Call<EarthquakeFeedModel> getAllHour();
}
