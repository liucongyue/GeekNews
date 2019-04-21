package com.example.thinkpad.geeknews.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.adapter.WechatAdapter.WeChatNewsAdapter;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.bean.WeChatBean.WechatBean;
import com.example.thinkpad.geeknews.presenter.WeChatP;
import com.example.thinkpad.geeknews.view.WeChatV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends BaseFragment<WeChatV, WeChatP> implements WeChatV {


    @BindView(R.id.lv)
    RecyclerView lv;
    Unbinder unbinder;
    private int page = 1;
    private String key = "52b7ec3471ac3bec6846577e79f20e4c";
    private int num = 10;
    private ArrayList<WechatBean.NewslistBean> mWechatList;
    private WeChatNewsAdapter mWeChatNewsAdapter;

    @Override
    protected WeChatP initPresenter() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we_chat;
    }

    @Override
    protected void initView() {
        mPresenter.getData(key,num,page);
    }

    @Override
    protected void initData() {
        mWechatList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        lv.setLayoutManager(layoutManager);
        mWeChatNewsAdapter = new WeChatNewsAdapter(getActivity(), mWechatList);
        lv.setAdapter(mWeChatNewsAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void getData(WechatBean bean) {
        mWechatList.addAll(bean.getNewslist());
        mWeChatNewsAdapter.setWechatlist(mWechatList);
        mWeChatNewsAdapter.notifyDataSetChanged();
    }

    @Override
    public int getpage() {
        return page;
    }

    @Override
    public String getkey() {
        return key;
    }

    @Override
    public int getnum() {
        return num;
    }
}
