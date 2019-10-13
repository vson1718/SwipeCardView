package com.vson.swipecardview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vson
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected ViewGroup mRv;
    private OnItemClickListener mOnItemClickListener;

    public CommonAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }

    public OnItemClickListener getmOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
        this.mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(this.mContext, (View) null, parent, this.mLayoutId);
        if (null == this.mRv) {
            this.mRv = parent;
        }

        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }

    /**
     * @deprecated
     */
    @Deprecated
    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        if (this.isEnabled(viewType)) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CommonAdapter.this.mOnItemClickListener != null) {
                        int position = CommonAdapter.this.getPosition(viewHolder);
                        CommonAdapter.this.mOnItemClickListener.onItemClick(parent, v, CommonAdapter.this.mDatas.get(position), position);
                    }

                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (CommonAdapter.this.mOnItemClickListener != null) {
                        int position = CommonAdapter.this.getPosition(viewHolder);
                        return CommonAdapter.this.mOnItemClickListener.onItemLongClick(parent, v, CommonAdapter.this.mDatas.get(position), position);
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        this.setListener(position, holder);
        this.convert(holder, this.mDatas.get(position));
    }

    protected void setListener(final int position, final ViewHolder viewHolder) {
        if (this.isEnabled(this.getItemViewType(position))) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CommonAdapter.this.mOnItemClickListener != null) {
                        CommonAdapter.this.mOnItemClickListener.onItemClick(CommonAdapter.this.mRv, v, CommonAdapter.this.mDatas.get(position), position);
                    }

                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (CommonAdapter.this.mOnItemClickListener != null) {
                        int position = CommonAdapter.this.getPosition(viewHolder);
                        return CommonAdapter.this.mOnItemClickListener.onItemLongClick(CommonAdapter.this.mRv, v, CommonAdapter.this.mDatas.get(position), position);
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    /**
     * 将 var2的数据 显示在ViewHolder 的对应 View 中
     *
     * @param var1 ViewHolder
     * @param var2 T
     */
    public abstract void convert(ViewHolder var1, T var2);

    @Override
    public int getItemCount() {
        return this.mDatas != null ? this.mDatas.size() : 0;
    }

    public void setDatas(List<T> list) {
        if (this.mDatas != null) {
            if (null != list) {
                ArrayList temp = new ArrayList();
                temp.addAll(list);
                this.mDatas.clear();
                this.mDatas.addAll(temp);
            } else {
                this.mDatas.clear();
            }
        } else {
            this.mDatas = list;
        }

        this.notifyDataSetChanged();
    }

    public void remove(int i) {
        if (null != this.mDatas && this.mDatas.size() > i && i > -1) {
            this.mDatas.remove(i);
            this.notifyDataSetChanged();
        }

    }

    public void addDatas(List<T> list) {
        if (null != list) {
            ArrayList temp = new ArrayList();
            temp.addAll(list);
            if (this.mDatas != null) {
                this.mDatas.addAll(temp);
            } else {
                this.mDatas = temp;
            }

            this.notifyDataSetChanged();
        }

    }

    public List<T> getDatas() {
        return this.mDatas;
    }

    public T getItem(int position) {
        return position > -1 && null != this.mDatas && this.mDatas.size() > position ? this.mDatas.get(position) : null;
    }
}

