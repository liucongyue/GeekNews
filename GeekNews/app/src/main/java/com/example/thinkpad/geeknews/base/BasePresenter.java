package com.example.thinkpad.geeknews.base;

import java.util.ArrayList;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public abstract class BasePresenter<V extends BaseMvpView> {
    protected V mView;
    protected ArrayList<BaseModel> mModels = new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void bind(V view) {
        this.mView = view;
    }


    public void onDestory() {
        mView = null;
        if (mModels.size() > 0) {
            for (BaseModel model : mModels) {
                model.onDestory();
            }
        }
    }
}
