package now_weather.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import now_weather.contract.NowWeatherContract;
import now_weather.model.ApiClient;
import now_weather.model.Entity.ResultCollection;
import now_weather.model.Entity.WeatherResult;
import now_weather.model.service.WeatherService;



/**
 * Created by Allen on 2017/2/25.
 */

public class NowWeatherPresenter implements NowWeatherContract.Presenter {

    private NowWeatherContract.View mNowWeatherView;

    public NowWeatherPresenter(@NonNull NowWeatherContract.View nowWeatherView) {
        //checkNotNull(nowWeatherView, "nowWeatherView cannot be null!");
        mNowWeatherView = nowWeatherView;
        mNowWeatherView.setPresenter(this);
    }


    @Override
    public void loadData() {

        Map<String, String> map = new HashMap<>();
        map.put("key", "");
        map.put("location", "beijing");
        WeatherService weatherService = ApiClient.initWeatherService("https://api.thinkpage.cn/", WeatherService.class);

        weatherService.getNowWeather(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultCollection<WeatherResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultCollection<WeatherResult> value) {
                        Log.i("lc",value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        mNowWeatherView.setLoadingIndicator(true);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        mNowWeatherView.showData(list);
        mNowWeatherView.setLoadingIndicator(false);
    }

    @Override
    public void start() {
        loadData();
    }
}
