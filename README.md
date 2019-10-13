# SwipeCardView
SwipeCardView是一个优雅的刷脸控件，滑动刷脸伴随渐变层叠动画，带来前所未有的滑动刷脸体验。

```
       //初始化配置数据
        CardConfig.initConfig(this);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new SwipeCardLayoutManager());
        //初始化加载数据
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

```