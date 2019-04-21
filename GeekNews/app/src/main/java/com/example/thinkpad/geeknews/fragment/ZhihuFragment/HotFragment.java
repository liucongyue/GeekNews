package com.example.thinkpad.geeknews.fragment.ZhihuFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.adapter.ZhihuDilyNewsadapter.HotAdapter;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.bean.geekbean.HotBean;
import com.example.thinkpad.geeknews.presenter.HotP;
import com.example.thinkpad.geeknews.view.HotV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<HotV, HotP> implements HotV {


    @BindView(R.id.lv)
    RecyclerView lv;
    Unbinder unbinder;
    private ArrayList<HotBean.RecentBean> mHotbean;
    private HotAdapter mHotAdapter;
    private int page = 4;

    @Override
    protected HotP initPresenter() {
        return new HotP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        mHotbean = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        lv.setLayoutManager(layoutManager);
        mHotAdapter = new HotAdapter(getActivity(), mHotbean);
        lv.setAdapter(mHotAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void getData(HotBean bean) {
        mHotbean.addAll(bean.getRecent());
        mHotAdapter.setMlist(mHotbean);
        mHotAdapter.notifyDataSetChanged();
    }

    @Override
    public int getpage() {
        return page;
    }
}
