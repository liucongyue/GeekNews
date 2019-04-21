package com.example.thinkpad.geeknews.model;

import com.example.thinkpad.geeknews.api.ZhihuDilyNews.ZhihuServer;
import com.example.thinkpad.geeknews.base.BaseModel;
import com.example.thinkpad.geeknews.bean.geekbean.ZhuanLanBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.utils.HttpUtils;
import com.example.thinkpad.geeknews.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class Special_columnM extends BaseModel {
    public void getData(int page, final CallBcak<ZhuanLanBean> callBcak) {
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.daynewsUrl, ZhihuServer.class);
        Observable<ZhuanLanBean> zhuanlanData = apiserver.zhuanlanData(page);
        zhuanlanData.compose(RxUtils.<ZhuanLanBean>rxObserableSchedulerHelper())
                .subscribe(new Observer<ZhuanLanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhuanLanBean zhuanLanBean) {
                        callBcak.onSuccess(zhuanLanBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
