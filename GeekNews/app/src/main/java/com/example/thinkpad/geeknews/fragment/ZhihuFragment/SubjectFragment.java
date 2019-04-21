package com.example.thinkpad.geeknews.fragment.ZhihuFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.presenter.SubjectP;
import com.example.thinkpad.geeknews.view.SubjectV;


public class SubjectFragment extends BaseFragment<SubjectV, SubjectP> implements SubjectV {


    @Override
    protected SubjectP initPresenter() {
        return new SubjectP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_subject;
    }
}
