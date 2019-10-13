package com.vson.swipecardview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vson
 */
public class SwipeCardBean {

    private int postition;
    private String url;
    private String name;

    public SwipeCardBean(int postition, String url, String name) {
        this.postition = postition;
        this.url = url;
        this.name = name;
    }

    public int getPosition() {
        return postition;
    }

    public SwipeCardBean setPosition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SwipeCardBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public SwipeCardBean setName(String name) {
        this.name = name;
        return this;
    }

    public static List<SwipeCardBean> initDatas() {
        List<SwipeCardBean> datas = new ArrayList<>();
        int i = 1;
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258989&di=6683066911fdbbc9b4d264c4bea22a4c&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201808%2F27%2F20180827030547_tsblg.jpg", "美女1"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258989&di=dc8059ef7ac2846839b3fb78a955a635&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20130221%2FImg366640084.jpg", "美女2"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258989&di=c26ccb743132290654f2f815405b8c3b&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20130416%2FImg372885486.jpg", "美女3"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258989&di=132ffb8a8c1d32339be3219760ea3751&imgtype=0&src=http%3A%2F%2Fy0.ifengimg.com%2Fe6ce10787c9a3bdb%2F2014%2F0307%2Frdn_531978b96e374.jpg", "美女4"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258988&di=7f702efa6b3a2ca3eb7aa58884dd7f02&imgtype=0&src=http%3A%2F%2Fpic22.nipic.com%2F20120709%2F3082675_091538091000_2.jpg", "美女5"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258988&di=a0f2fc02b4cfd440680670ccf78c4a7f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201412%2F27%2F20141227174553_auCHe.jpeg", "美女6"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258988&di=dcb90c2d0fb7526c0ab22f174f5f6242&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20080514%2FImg256840631.jpg", "美女7"));
        datas.add(new SwipeCardBean(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570898258988&di=77228a1595c5bbff5c8d9a0189609b81&imgtype=0&src=http%3A%2F%2Fimg4.cache.netease.com%2Fphoto%2F0026%2F2013-06-30%2F92KAKETV43AJ0026.jpg", "美女8"));
        return datas;
    }
}