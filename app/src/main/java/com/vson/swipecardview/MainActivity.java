package com.vson.swipecardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vson.swipecardview.adapter.CommonAdapter;
import com.vson.swipecardview.adapter.ViewHolder;

import java.util.List;

/**
 * @author vson
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private CommonAdapter<SwipeCardBean> adapter;
    private List<SwipeCardBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardConfig.initConfig(this);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new SwipeCardLayoutManager());
        mDatas = SwipeCardBean.initDatas();
        adapter = new CommonAdapter<SwipeCardBean>(MainActivity.this, mDatas, R.layout.item_swipe_card) {
            @Override
            public void convert(ViewHolder ViewHolder, SwipeCardBean swipeCardBean) {
                ViewHolder.setText(R.id.tvName, swipeCardBean.getName());
                ViewHolder.setText(R.id.tvPrecent, swipeCardBean.getPosition() + "/" + mDatas.size());
                Glide.with(MainActivity.this)
                        .load(swipeCardBean.getUrl())
                        .into((ImageView) ViewHolder.getView(R.id.iv));
            }
        };
        rv.setAdapter(adapter);
        SwipeCardCallback cardCallback=new SwipeCardCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(cardCallback);
        helper.attachToRecyclerView(rv);
    }
}
