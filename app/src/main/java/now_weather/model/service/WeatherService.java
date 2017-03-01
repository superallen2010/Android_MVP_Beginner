package now_weather.model.service;

import java.util.Map;

import io.reactivex.Observable;
import now_weather.model.Entity.ResultCollection;
import now_weather.model.Entity.WeatherResult;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Allen on 2017/2/28.
 */

public interface WeatherService {


    @GET("/v3/weather/now.json")
    Observable<ResultCollection<WeatherResult>> getNowWeather(@QueryMap Map<String, String> map);

}
