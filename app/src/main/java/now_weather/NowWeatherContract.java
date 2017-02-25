package now_weather;

import java.util.List;

import base.BasePresenter;
import base.BaseView;

/**
 * Created by Allen on 2017/2/25.
 */

public interface NowWeatherContract {
    interface View<T> extends BaseView<Presenter> {
        void showData(List<T> list);
        void showEmpty();

        void setLoadingIndicator(boolean active);
    }


    interface Presenter extends BasePresenter {
        void loadData();
    }

}
