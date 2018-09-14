//package cohen.earthquake.lasthighest;
//
//import cohen.earthquake.Earthquake;
//import cohen.earthquake.EarthquakeFeedModel;
//import cohen.earthquake.net.USGSEarthquakeService;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//import javax.swing.text.JTextComponent;
//import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//public class LastHighestController {
//
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://earthquake.usgs.gov")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    USGSEarthquakeService service =
//            retrofit.create(USGSEarthquakeService.class);
//
//    public static void refresh()
//    {
//        service.getAllDay().enqueue(new Callback<EarthquakeFeedModel>() {
//            @Override
//            public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response) {
//                EarthquakeFeedModel feed = response.body();
//
//                List<Earthquake> earthquakeList = feed.getFeatures()
//                        .stream()
//                        .filter(earthquake -> earthquake.getProperties().getMag() >= 3.0)
//                        .sorted((e1, e2) -> e1.getMagnitude() > e2.getMagnitude() ? -1 : 1)
//                        .limit(5)
//                        .collect(Collectors.toList());
//
//                view.setEarthquakes(earthquakeList);
//            }
//
//            @Override
//            public void onFailure(Call<EarthquakeFeedModel> call, Throwable t) {
//                t.printStackTrace();
//
//            }
//
//        });
//
//    }
//
//
//}
//
//
