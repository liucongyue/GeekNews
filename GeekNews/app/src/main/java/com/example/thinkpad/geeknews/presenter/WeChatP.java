package com.example.thinkpad.geeknews.presenter;

import android.util.Log;

import com.example.thinkpad.geeknews.base.BasePresenter;
import com.example.thinkpad.geeknews.bean.WeChatBean.WechatBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.model.WeChatM;
import com.example.thinkpad.geeknews.view.MainView;
import com.example.thinkpad.geeknews.view.WeChatV;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 * key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
 **/
public class WeChatP extends BasePresenter<WeChatV> {
    private static final String TAG = "123";
    private WeChatM mWeChatM;

    @Override
    protected void initModel() {
        mWeChatM = new WeChatM();
        mModels.add(mWeChatM);
    }

    public void getData(String key, int num, int page) {
        /*int page = mView.getpage();
        String key = mView.getkey();
        int num = mView.getnum();*/

        mWeChatM.getData(key, num, page, new CallBcak<WechatBean>() {
            @Override
            public void onSuccess(WechatBean bean) {
                if (bean != null) {
                    if (mView != null) {
                        mView.getData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                Log.d(TAG, "onFail: " + msg);
            }
        });
    }
}
