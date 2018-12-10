//package cohen.earthquake.net;
//
//import com.google.inject.AbstractModule;
//
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class EarthquakeModule extends AbstractModule{
//	@Override
//	protected void configure() {
//		super.configure();
//
//		Retrofit retrofit = new Retrofit.Builder()
//				.baseUrl("https://earthquake.usgs.gov")
//				.addConverterFactory(GsonConverterFactory.create())
//				.build();
//		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
//
//		//every time you want to use the earthquake service, use this on ^^^
//		bind(USGSEarthquakeService.class).toInstance(service);
//	}
//}
