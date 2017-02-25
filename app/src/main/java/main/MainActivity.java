package main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import now_weather.NowWeatherFragment;
import now_weather.NowWeatherPresenter;
import utils.ActivityUtils;
import allen.android_mvp_beginner.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    private NowWeatherPresenter mNowWeatherPresenter;

    @BindView(R.id.contentContainer)
    FrameLayout mLayoutContentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NowWeatherFragment nowWeatherFragment = (NowWeatherFragment) getSupportFragmentManager().findFragmentById(R.id.contentContainer);
        if (nowWeatherFragment == null) {
            nowWeatherFragment = NowWeatherFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), nowWeatherFragment, R.id.contentContainer);
        }
        mNowWeatherPresenter = new NowWeatherPresenter(nowWeatherFragment);


//        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if (tabId == R.id.tab_favorites) {
//                    // The tab with id R.id.tab_favorites was selected,
//                    // change your content accordingly.
//                }
//            }
//        });

    }


}
