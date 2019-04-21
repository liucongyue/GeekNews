package com.example.thinkpad.geeknews.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void onDestory() {
        mCompositeDisposable.clear();
    }

}
