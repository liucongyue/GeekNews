package com.example.thinkpad.geeknews.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.presenter.GankP;
import com.example.thinkpad.geeknews.view.GankV;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment<GankV, GankP> {


    @Override
    protected GankP initPresenter() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }
}
