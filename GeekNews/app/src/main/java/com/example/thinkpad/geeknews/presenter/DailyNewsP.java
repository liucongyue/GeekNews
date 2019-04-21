package com.example.thinkpad.geeknews.presenter;

import com.example.thinkpad.geeknews.base.BasePresenter;
import com.example.thinkpad.geeknews.bean.geekbean.DayNewsBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.model.DailNewsM;
import com.example.thinkpad.geeknews.view.DailyNewsV;


/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class DailyNewsP extends BasePresenter<DailyNewsV> {

    private DailNewsM mDailNewsM;

    @Override
    protected void initModel() {
        mDailNewsM = new DailNewsM();
        mModels.add(mDailNewsM);
    }

    public void getData() {
        int page= mView.getpage();
        mDailNewsM.getData(page, new CallBcak<DayNewsBean>() {

            @Override
            public void onSuccess(DayNewsBean bean) {
                if (bean != null) {
                    if (mView != null) {
                        mView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
