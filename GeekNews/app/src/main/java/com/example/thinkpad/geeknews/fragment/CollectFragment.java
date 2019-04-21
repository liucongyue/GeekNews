package com.example.thinkpad.geeknews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.presenter.EmptyP;
import com.example.thinkpad.geeknews.view.EmptyV;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends BaseFragment<EmptyV, EmptyP> {


    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }
}
