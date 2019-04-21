package com.example.thinkpad.geeknews.fragment.ZhihuFragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.adapter.ZhihuDilyNewsadapter.ZhuanLanAdapter;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.bean.geekbean.ZhuanLanBean;
import com.example.thinkpad.geeknews.presenter.Special_columnP;
import com.example.thinkpad.geeknews.view.Special_columnV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Special_columnFragment extends BaseFragment<Special_columnV, Special_columnP> implements Special_columnV {


    @BindView(R.id.lv)
    RecyclerView lv;
    Unbinder unbinder;
    private ArrayList<ZhuanLanBean.DataBean> mSpeciallist;
    private ZhuanLanAdapter mZhuanLanAdapter;
    private int page = 4;

    @Override
    protected Special_columnP initPresenter() {
        return new Special_columnP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_special_column;
    }

    @Override
    protected void initView() {
        mSpeciallist = new ArrayList<>();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        lv.setLayoutManager(layoutManager);
        mZhuanLanAdapter = new ZhuanLanAdapter(getActivity(), mSpeciallist);
        lv.setAdapter(mZhuanLanAdapter);
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
    public void setData(ZhuanLanBean bean) {
        mSpeciallist.addAll(bean.getData());
        mZhuanLanAdapter.setMlist(mSpeciallist);
        mZhuanLanAdapter.notifyDataSetChanged();
    }

    @Override
    public int getpage() {
        return page;
    }
}
