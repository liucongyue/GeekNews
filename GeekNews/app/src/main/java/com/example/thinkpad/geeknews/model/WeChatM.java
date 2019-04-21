package com.example.thinkpad.geeknews.model;

import com.example.thinkpad.geeknews.api.ZhihuDilyNews.ZhihuServer;
import com.example.thinkpad.geeknews.base.BaseModel;
import com.example.thinkpad.geeknews.bean.WeChatBean.WechatBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.utils.BaseObserver;
import com.example.thinkpad.geeknews.utils.HttpUtils;
import com.example.thinkpad.geeknews.utils.RxUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/

public class WeChatM extends BaseModel {
    private int page = 1;
    private String key = "52b7ec3471ac3bec6846577e79f20e4c";
    private int num = 10;
    public void getData(String key, int num, int page, final CallBcak<WechatBean> callBcak) {
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.WeChatURL, ZhihuServer.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("num", num);
        map.put("page", page);
        Observable<WechatBean> wechatData = apiserver.wechatData(map);
        wechatData.compose(RxUtils.<WechatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        callBcak.onSuccess(wechatBean);
                    }
                });
    }
}
