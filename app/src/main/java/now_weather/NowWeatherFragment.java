package now_weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.List;

import allen.android_mvp_beginner.R;
import utils.MyItemDecaration;


/**
 * Created by Allen on 2017/2/25.
 */

public class NowWeatherFragment extends Fragment implements NowWeatherContract.View<Integer> {

    private NowWeatherContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private TextView mTvEmpty;

    private SwipeRefreshLayout mLayoutRefresh;
    private NowWeatherAdapter<Integer> mAdapter;

    public static NowWeatherFragment newInstance() {
        return new NowWeatherFragment();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new NowWeatherAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nowweather, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.view_recyclerview);
        mLayoutRefresh = (SwipeRefreshLayout) view.findViewById(R.id.layout_refresh);
        mTvEmpty = (TextView) view.findViewById(R.id.tv_no_data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new MyItemDecaration(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        mLayoutRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadData();
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showData(List<Integer> list) {
        mAdapter.updateData(list);
    }

    @Override
    public void showEmpty() {
        mTvEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }

        mLayoutRefresh.post(new Runnable() {
            @Override
            public void run() {
                mLayoutRefresh.setRefreshing(active);
            }
        });

    }

    @Override
    public void setPresenter(@NonNull NowWeatherContract.Presenter presenter) {
        //mPresenter = checkNotNull(presenter);
        Logger.d("NowWeatherFragment setPresenter");

        mPresenter = presenter;
    }

}
