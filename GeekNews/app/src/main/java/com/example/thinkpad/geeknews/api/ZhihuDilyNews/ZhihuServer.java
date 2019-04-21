package com.example.thinkpad.geeknews.api.ZhihuDilyNews;

import com.example.thinkpad.geeknews.bean.WeChatBean.WechatBean;
import com.example.thinkpad.geeknews.bean.geekbean.DayNewsBean;
import com.example.thinkpad.geeknews.bean.geekbean.HotBean;
import com.example.thinkpad.geeknews.bean.geekbean.ZhuanLanBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public interface ZhihuServer {

    public String daynewsUrl = "http://news-at.zhihu.com/api/";
    public String WeChatURL = "http://api.tianapi.com/";

    @GET("wxnew/")
    Observable<WechatBean> wechatData(@QueryMap HashMap<String,Object> map);

    //日报
    @GET("{page}/news/latest")
    Observable<DayNewsBean> daynewsData(@Path("page") int page);

    //专栏数据
    @GET("{page}/sections")
    Observable<ZhuanLanBean> zhuanlanData(@Path("page") int page);

    //热门数据
    @GET("{page}/news/hot")
    Observable<HotBean> hotData(@Path("page") int page);
}
