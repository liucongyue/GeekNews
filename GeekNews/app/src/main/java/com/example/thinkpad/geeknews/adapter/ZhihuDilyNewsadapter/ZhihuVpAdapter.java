package com.example.thinkpad.geeknews.adapter.ZhihuDilyNewsadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class ZhihuVpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> title;
    private ArrayList<Fragment> list;

    public ZhihuVpAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> list) {
        super(fm);
        this.title = title;
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
