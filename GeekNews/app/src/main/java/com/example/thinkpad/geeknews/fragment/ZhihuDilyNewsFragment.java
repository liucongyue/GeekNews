package com.example.thinkpad.geeknews.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.adapter.ZhihuDilyNewsadapter.ZhihuVpAdapter;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.fragment.ZhihuFragment.DailyFragment;
import com.example.thinkpad.geeknews.fragment.ZhihuFragment.HotFragment;
import com.example.thinkpad.geeknews.fragment.ZhihuFragment.Special_columnFragment;
import com.example.thinkpad.geeknews.fragment.ZhihuFragment.SubjectFragment;
import com.example.thinkpad.geeknews.presenter.ZhihuDailyNewsP;
import com.example.thinkpad.geeknews.view.ZhihuDailyNewsV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//刘聪越   H1808B
public class ZhihuDilyNewsFragment extends BaseFragment<ZhihuDailyNewsV, ZhihuDailyNewsP> {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitle;

    @Override
    protected ZhihuDailyNewsP initPresenter() {
        return new ZhihuDailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_dily_news;
    }


    @Override
    protected void initView() {
        mTitle = new ArrayList<>();
        mTitle.add("日报");
        mTitle.add("主题");
        mTitle.add("专栏");
        mTitle.add("热门");
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new DailyFragment());
        mFragments.add(new SubjectFragment());
        mFragments.add(new Special_columnFragment());
        mFragments.add(new HotFragment());

        ZhihuVpAdapter zhihuVpAdapter = new ZhihuVpAdapter(getChildFragmentManager(), mTitle, mFragments);
        vp.setAdapter(zhihuVpAdapter);
        tab.setupWithViewPager(vp);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
