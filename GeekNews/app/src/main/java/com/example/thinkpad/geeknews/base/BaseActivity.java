package com.example.thinkpad.geeknews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 * 刘聪越 H1808B
 **/
public abstract class BaseActivity<V extends BaseMvpView,P extends BasePresenter> extends AppCompatActivity implements BaseMvpView{
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
         mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.bind((V) this);
        }
        initView();
        initListenter();
        initData();
    }

    protected abstract P initPresenter();

    protected void initData() {
    }

    protected void initListenter() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutId();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //切断V层和P层的联系
        mPresenter.onDestory();
        mPresenter = null;
    }
}
