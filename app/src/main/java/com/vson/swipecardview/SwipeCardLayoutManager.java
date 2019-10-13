package com.vson.swipecardview;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author vson
 */
class SwipeCardLayoutManager extends RecyclerView.LayoutManager {

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //回收  复用
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        //最后一个显示在最前面
        int bottomPosition;
        if (itemCount < CardConfig.MAX_SHOW_COUNT) {
            bottomPosition = 0;
        } else {
            bottomPosition = itemCount - CardConfig.MAX_SHOW_COUNT;
        }

        for (int i = bottomPosition; i < itemCount; i++) {
            //View 复用
            View view = recycler.getViewForPosition(i);
            addView(view);
            //测量出View宽高
            measureChildWithMargins(view, 0, 0);

            //求padding的总大小
            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
            //布局
            //getDecoratedMeasuredWidth去掉装饰后测量的宽度
            layoutDecoratedWithMargins(view,
                    widthSpace / 2,
                    heightSpace / 2,
                    widthSpace / 2 + getDecoratedMeasuredWidth(view),
                    heightSpace / 2 + getDecoratedMeasuredHeight(view));

            int level = itemCount - i - 1;
            if (level > 0) {
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    view.setTranslationY(CardConfig.TRANS_Y_GAP * level);
                    view.setScaleY(1 - CardConfig.SCALE_GAP * level);
                    view.setScaleX(1 - CardConfig.SCALE_GAP * level);
                } else {
                    view.setTranslationY(CardConfig.TRANS_Y_GAP * (level - 1));
                    view.setScaleY(1 - CardConfig.SCALE_GAP * (level - 1));
                    view.setScaleX(1 - CardConfig.SCALE_GAP * (level - 1));
                }
            }
        }
    }
}
