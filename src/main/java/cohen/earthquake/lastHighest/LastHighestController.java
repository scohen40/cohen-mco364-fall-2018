package cohen.earthquake.lastHighest;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeedModel;
import cohen.earthquake.net.USGSEarthquakeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.text.JTextComponent;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class LastHighestController {
    private Provider<LastHighestView> viewProvider;
    private USGSEarthquakeService service;

    @Inject
    public LastHighestController(Provider<LastHighestView> viewProvider, USGSEarthquakeService service) {
        this.viewProvider = viewProvider;
        this.service = service;
    }

    public void refreshData() {
        service.getAllDay().enqueue(new Callback<EarthquakeFeedModel>() {
            @Override
            public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response) {
                EarthquakeFeedModel feed = response.body();

                List<Earthquake> earthquakes = feed.getFeatures()
                        .stream()
                        .filter(earthquake -> earthquake.getProperties().getMag() >= 3.0)
                        .sorted((e1, e2) -> e1.getMagnitude() > e2.getMagnitude() ? -1 : 1)
                        .limit(5)
                        .collect(Collectors.toList());


                viewProvider.get().setEarthquakes(earthquakes);

            }

            @Override
            public void onFailure(Call<EarthquakeFeedModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}








