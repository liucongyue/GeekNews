package com.example.thinkpad.geeknews.model;

import com.example.thinkpad.geeknews.api.ZhihuDilyNews.ZhihuServer;
import com.example.thinkpad.geeknews.base.BaseModel;
import com.example.thinkpad.geeknews.bean.geekbean.DayNewsBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.utils.BaseObserver;
import com.example.thinkpad.geeknews.utils.HttpUtils;
import com.example.thinkpad.geeknews.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingBaseObserver;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class DailNewsM extends BaseModel {

    public void getData(int page, final CallBcak<DayNewsBean> callBcak) {
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.daynewsUrl, ZhihuServer.class);
        Observable<DayNewsBean> daynewsData = apiserver.daynewsData(page);
        daynewsData.compose(RxUtils.<DayNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DayNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DayNewsBean dayNewsBean) {
                        callBcak.onSuccess(dayNewsBean);
                    }
                });
    }
}
