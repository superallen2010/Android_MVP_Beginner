package now_weather.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import allen.android_mvp_beginner.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Allen on 2017/2/25.
 */

public class NowWeatherAdapter<T> extends RecyclerView.Adapter {

    private List<T> mData = new ArrayList<>();
    private Context mContext;


    public NowWeatherAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_nowweather, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvData.setText(String.valueOf(mData.get(position)));

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<T> data) {
        this.mData = data;
        notifyDataSetChanged();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_data)
        TextView tvData;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
