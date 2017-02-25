package now_weather;

import android.support.annotation.NonNull;

import java.util.ArrayList;


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
