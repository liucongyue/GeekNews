package com.example.thinkpad.geeknews.presenter;

import com.example.thinkpad.geeknews.base.BasePresenter;
import com.example.thinkpad.geeknews.bean.geekbean.HotBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.model.HotM;
import com.example.thinkpad.geeknews.view.HotV;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class HotP extends BasePresenter<HotV> {

    private HotM mHotM;

    @Override
    protected void initModel() {
        mHotM = new HotM();
        mModels.add(mHotM);
    }

    public void getData() {
        int page = mView.getpage();
        mHotM.getData(page, new CallBcak<HotBean>() {
            @Override
            public void onSuccess(HotBean bean) {
                if (bean != null) {
                    if (mView != null) {
                        mView.getData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
