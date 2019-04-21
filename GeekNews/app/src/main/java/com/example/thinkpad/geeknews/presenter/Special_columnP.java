package com.example.thinkpad.geeknews.presenter;

import com.example.thinkpad.geeknews.base.BasePresenter;
import com.example.thinkpad.geeknews.bean.geekbean.ZhuanLanBean;
import com.example.thinkpad.geeknews.callback.CallBcak;
import com.example.thinkpad.geeknews.model.Special_columnM;
import com.example.thinkpad.geeknews.view.Special_columnV;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class Special_columnP extends BasePresenter<Special_columnV> {

    private Special_columnM mSpecial_columnM;

    @Override
    protected void initModel() {
        mSpecial_columnM = new Special_columnM();
        mModels.add(mSpecial_columnM);
    }

    public void getData() {
        int page = mView.getpage();
        mSpecial_columnM.getData(page, new CallBcak<ZhuanLanBean>() {
            @Override
            public void onSuccess(ZhuanLanBean bean) {
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
