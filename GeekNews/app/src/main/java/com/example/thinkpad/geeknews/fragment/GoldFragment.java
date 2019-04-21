package com.example.thinkpad.geeknews.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.activity.ShowActivity;
import com.example.thinkpad.geeknews.adapter.GoldAdapter.VpGoldAdapter;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.base.Constants;
import com.example.thinkpad.geeknews.bean.GoldBean.GoldShowBean;
import com.example.thinkpad.geeknews.fragment.GoldF.GoldDetailFragment;
import com.example.thinkpad.geeknews.presenter.GoldP;
import com.example.thinkpad.geeknews.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldFragment extends BaseFragment<GoldV, GoldP> implements GoldV {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<GoldShowBean> mTitles;
    private VpGoldAdapter mVpGoldAdapter;
    private ArrayList<Fragment> mFragments;

    @Override
    protected GoldP initPresenter() {
        return new GoldP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView() {
        initTitle();
        setFragment();
    }

    private void setFragment() {
        initFragment();
        mVpGoldAdapter = new VpGoldAdapter(getChildFragmentManager(), mTitles, mFragments);
        vp.setAdapter(mVpGoldAdapter);
        tab.setupWithViewPager(vp);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            GoldShowBean showBean = mTitles.get(i);
            if (showBean.isChecked) {
                mFragments.add(GoldDetailFragment.newInstance(showBean.title));
            }

        }
    }

    private void initTitle() {
        mTitles = new ArrayList<>();
        mTitles.add(new GoldShowBean("工具资源", true));
        mTitles.add(new GoldShowBean("Android", true));
        mTitles.add(new GoldShowBean("IOS", true));
        mTitles.add(new GoldShowBean("设计", true));
        mTitles.add(new GoldShowBean("产品", true));
        mTitles.add(new GoldShowBean("阅读", true));
        mTitles.add(new GoldShowBean("前端", true));
        mTitles.add(new GoldShowBean("后端", true));
    }

    @OnClick({R.id.iv})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.iv:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
        Intent intent = new Intent(getActivity(), ShowActivity.class);
        intent.putExtra(Constants.DATA, mTitles);
        startActivityForResult(intent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
                mTitles = (ArrayList<GoldShowBean>) data.getSerializableExtra(Constants.DATA);
                setFragment();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
