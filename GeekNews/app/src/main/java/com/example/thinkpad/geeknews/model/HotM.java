package com.example.thinkpad.geeknews.model;

import com.example.thinkpad.geeknews.api.ZhihuDilyNews.ZhihuServer;
import com.example.thinkpad.geeknews.base.BaseModel;
import com.example.thinkpad.geeknews.bean.geekbean.HotBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.utils.BaseObserver;
import com.example.thinkpad.geeknews.utils.HttpUtils;
import com.example.thinkpad.geeknews.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class HotM extends BaseModel {
    public void getData(int page, final CallBcak<HotBean> callBcak) {
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.daynewsUrl, ZhihuServer.class);
        Observable<HotBean> hotData = apiserver.hotData(page);
        hotData.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBcak.onSuccess(hotBean);
                    }
                });
    }
}
