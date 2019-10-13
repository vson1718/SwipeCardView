package com.vson.swipecardview.adapter;


import android.view.View;
import android.view.ViewGroup;

/**
 * @author vson
 */
public interface OnItemClickListener<T> {

    /**
     * Item点击事件
     *
     * @param var1
     * @param var2
     * @param var3
     * @param var4
     */
    void onItemClick(ViewGroup var1, View var2, T var3, int var4);

    /**
     * item长按点击事件
     *
     * @param var1
     * @param var2
     * @param var3
     * @param var4
     * @return
     */
    boolean onItemLongClick(ViewGroup var1, View var2, T var3, int var4);
}
