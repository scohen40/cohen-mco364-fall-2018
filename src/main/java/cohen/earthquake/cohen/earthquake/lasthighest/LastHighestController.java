package cohen.earthquake.cohen.earthquake.lasthighest;

import cohen.earthquake.Earthquake;
import cohen.earthquake.EarthquakeFeedModel;
import cohen.earthquake.net.EarthquakeView;
import cohen.earthquake.net.USGSEarthquakeService;
import com.google.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;
import java.util.Comparator;
import java.util.Optional;

public class LastHighestController {
    private LastHighestView view;
    private USGSEarthquakeService service;

    @Inject
    LastHighestController(LastHighestView view, USGSEarthquakeService service) {
        this.view = view;
        this.service = service;
    }

    public void refreshData() {
        requestMonth();
        requestWeek();
        requestDay();
        requestHour();
    }












    void requestMonth() {
        requestEarthquakeFeed(service.getAllMonth(),
                view.getMonthMagText(),
                view.getMonthPlaceText());
    }
    private void requestWeek() {
        requestEarthquakeFeed(service.getAllWeek(),
                view.getWeekMagText(),
                view.getWeekPlaceText());
    }
    private void requestDay() {
        requestEarthquakeFeed(service.getAllDay(),
                view.getDayMagText(),
                view.getDayPlaceText());
    }
    private void requestHour() {
        requestEarthquakeFeed(service.getAllHour(),
                view.getHourMagText(),
                view.getHourPlaceText());
    }



    private void requestEarthquakeFeed(Call<EarthquakeFeedModel> call,
                                       final JTextComponent magnitudeField,
                                       final JTextComponent placeField)
    {
        call.enqueue(new Callback<EarthquakeFeedModel>() {
            @Override
            public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response) {
                EarthquakeFeedModel feed = response.body();

                showLargestEarthquake(magnitudeField, placeField, feed);

            }

            @Override
            public void onFailure(Call<EarthquakeFeedModel> call, Throwable t) {
                t.printStackTrace();

            }

        });

    }

    void showLargestEarthquake(JTextComponent magnitudeField,
                               JTextComponent placeField,
                               EarthquakeFeedModel feed)
    {
        Optional<Earthquake> largest = feed.getFeatures().stream()
                .max(Comparator.comparing(e -> e.getProperties().getMag()));

        magnitudeField.setText(String.valueOf(largest.get().getProperties().getMag()));
        placeField.setText(String.valueOf(largest.get().getProperties().getPlace()));
    }

}


