package com.example.thinkpad.geeknews.adapter.GoldAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.thinkpad.geeknews.bean.GoldBean.GoldShowBean;

import java.util.ArrayList;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class VpGoldAdapter extends FragmentStatePagerAdapter {
    private ArrayList<GoldShowBean> mTitles;
    private ArrayList<Fragment> mFragment;
    private ArrayList<String> mNewTitls = new ArrayList<>();

    public VpGoldAdapter(FragmentManager fm, ArrayList<GoldShowBean> titles, ArrayList<Fragment> fragment) {
        super(fm);
        mTitles = titles;
        mFragment = fragment;
        for (int i = 0; i < mTitles.size(); i++) {
            GoldShowBean bean = mTitles.get(i);
            if (bean.isChecked) {
                mNewTitls.add(bean.title);
            }
        }
    }

    @Override
    public Fragment getItem(int i) {
        return mFragment.get(i);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNewTitls.get(position);
    }
}
