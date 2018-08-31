package cohen.earthquake.net;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeedModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeRetrofitClient {
	public EarthquakeRetrofitClient()
	{
		
	
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("https://earthquake.usgs.gov")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			USGSEarthquakeService service = 
					retrofit.create(USGSEarthquakeService.class);
			
			Call<EarthquakeFeedModel> callMonth = service.getAllMonth();
			Call<EarthquakeFeedModel> callWeek = service.getAllWeek();
			Call<EarthquakeFeedModel> callDay = service.getAllDay();
			Call<EarthquakeFeedModel> callHour = service.getAllHour();
			//1st way of doing the call, that you don't want to do in the main, because it will make startup slower:
        		//Response<EarthquakeFeed> response = call.execute();
			//better way of doing call: call.enqueue
			//advantage of this is that when we enqueue, the request goes out automatically to another thread. 
			callMonth.enqueue(new Callback<EarthquakeFeedModel>() {

				@Override
				public void onResponse(Call<EarthquakeFeedModel> callMonth, Response<EarthquakeFeedModel> responseMonth) {
					EarthquakeFeedModel feed = responseMonth.body();
		
					Optional<Earthquake> greatestMonth = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
									
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeedModel> callMonth, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
			
			callWeek.enqueue(new Callback<EarthquakeFeedModel>() {

				@Override
				public void onResponse(Call<EarthquakeFeedModel> callWeek, Response<EarthquakeFeedModel> responseWeek) {
					EarthquakeFeedModel feed = responseWeek.body();
					
					Optional<Earthquake> greatestWeek = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
								
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeedModel> callWeek, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
		
			
			callDay.enqueue(new Callback<EarthquakeFeedModel>() {

				@Override
				public void onResponse(Call<EarthquakeFeedModel> callDay, Response<EarthquakeFeedModel> responseDay) {
					EarthquakeFeedModel feed = responseDay.body();
					
					Optional<Earthquake> greatestWeek = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
						
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeedModel> callDay, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
			
			callHour.enqueue(new Callback<EarthquakeFeedModel>() {

				@Override
				public void onResponse(Call<EarthquakeFeedModel> callHour, Response<EarthquakeFeedModel> responseHour) {
					EarthquakeFeedModel feed = responseHour.body();
					
					Optional<Earthquake> greatestWeek = feed.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
					
				}
				
				@Override
				public void onFailure(Call<EarthquakeFeedModel> callHour, Throwable t) {
					t.printStackTrace(); 
					
				}
				
			});
			
		}
	
}
