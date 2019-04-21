package com.example.thinkpad.geeknews.fragment.ZhihuFragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.adapter.ZhihuDilyNewsadapter.XlvAdapter;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.bean.geekbean.DayNewsBean;
import com.example.thinkpad.geeknews.presenter.DailyNewsP;
import com.example.thinkpad.geeknews.presenter.ZhihuDailyNewsP;
import com.example.thinkpad.geeknews.view.DailyNewsV;
import com.example.thinkpad.geeknews.view.ZhihuDailyNewsV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;


public class DailyFragment extends BaseFragment<DailyNewsV, DailyNewsP> implements DailyNewsV {

    @BindView(R.id.lv)
    RecyclerView lv;
    Unbinder unbinder;
    private XlvAdapter mXlvAdapter;
    private static final String TAG = "DailyNewsFragment";
    private int page = 4;
    private ArrayList<DayNewsBean.StoriesBean> mNewsList;
    private ArrayList<DayNewsBean.TopStoriesBean> mBanners;

    @Override
    protected DailyNewsP initPresenter() {
        return new DailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        lv.setLayoutManager(layoutManager);
        mNewsList = new ArrayList<>();
        mBanners = new ArrayList<>();
        mXlvAdapter = new XlvAdapter(getActivity(), mNewsList, mBanners);
        lv.setAdapter(mXlvAdapter);
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
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }

    @Override
    public void setData(DayNewsBean bean) {
        Log.d(TAG, "setData: " + bean.toString());
      /* mNewsList.addAll(bean.getStories());
       mBanners.addAll(bean.getTop_stories());
       mXlvAdapter.notifyDataSetChanged();*/
        mXlvAdapter.setData(bean);

    }

    @Override
    public int getpage() {
        return page;
    }
}
