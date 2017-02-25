package utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import allen.android_mvp_beginner.R;

/**
 * Created by Allen on 2017/2/25.
 */

public class MyItemDecaration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private int mDiverHeight;
    private Paint mPaint;

    public MyItemDecaration(Context context) {
        mPaint = new Paint();
        mContext = context;
        mDiverHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.divider_height);
        mPaint.setColor(ContextCompat.getColor(mContext,R.color.itemDivider));
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View childView = parent.getChildAt(i);
            int top = childView.getBottom();
            int bottom = childView.getBottom() + mDiverHeight;
            c.drawRect(left,top,right,bottom,mPaint);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = mDiverHeight;
    }
}
