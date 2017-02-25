package future_weather;

import now_weather.NowWeatherContract;


/**
 * Created by Allen on 2017/2/25.
 */

public class FutureWeatherPresenter implements NowWeatherContract.Presenter {

    private NowWeatherContract.View mNowWeatherView;

    public FutureWeatherPresenter(NowWeatherContract.View nowWeatherView) {
        //mNowWeatherView = checkNotNull(nowWeatherView, "nowWeatherView cannot be null!");
        mNowWeatherView = nowWeatherView;

    }

    @Override
    public void loadData() {
        mNowWeatherView.setLoadingIndicator(true);
    }

    @Override
    public void start() {

    }
}
