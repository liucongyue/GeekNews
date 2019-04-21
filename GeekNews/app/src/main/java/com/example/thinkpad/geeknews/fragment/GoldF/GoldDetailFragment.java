package com.example.thinkpad.geeknews.fragment.GoldF;


import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.base.Constants;
import com.example.thinkpad.geeknews.presenter.EmptyP;
import com.example.thinkpad.geeknews.view.EmptyV;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldDetailFragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {


    @BindView(R.id.tv)
    TextView tv;

    public static GoldDetailFragment newInstance(String text) {
        GoldDetailFragment fragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_detail;
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        String s = arguments.getString(Constants.DATA);
        tv.setText(s);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
