package com.example.thinkpad.geeknews.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.base.BaseActivity;
import com.example.thinkpad.geeknews.fragment.AboutFragment;
import com.example.thinkpad.geeknews.fragment.CollectFragment;
import com.example.thinkpad.geeknews.fragment.GankFragment;
import com.example.thinkpad.geeknews.fragment.GoldFragment;
import com.example.thinkpad.geeknews.fragment.SettingFragment;
import com.example.thinkpad.geeknews.fragment.V2exVFragment;
import com.example.thinkpad.geeknews.fragment.WeChatFragment;
import com.example.thinkpad.geeknews.fragment.ZhihuDilyNewsFragment;
import com.example.thinkpad.geeknews.presenter.MainP;
import com.example.thinkpad.geeknews.view.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainView, MainP> implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fragm_container)
    FrameLayout fragmContainer;
    @BindView(R.id.nav)
    NavigationView nav;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    @BindView(R.id.toolbar_container)
    FrameLayout toolbarContainer;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> mTitles;
    private FragmentManager mManager;
    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_COLLECT = 5;
    private final int TYPE_SETTING = 6;
    private final int TYPE_ABOUT = 7;
    private int mLastFragmentPosition;
    private MenuItem mSearchItem;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mManager = getSupportFragmentManager();
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.app_name, R.string.app_name);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(toggle);
        toggle.syncState();

        initFragment();
        initTitles();
        addZhihuDilyNewsFragment();
    }

    private void addZhihuDilyNewsFragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.fragm_container, mFragments.get(0));
        transaction.commit();

        toolbar.setTitle(mTitles.get(0));
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(R.id.zhihu);
        mTitles.add(R.id.wechat);
        mTitles.add(R.id.gank);
        mTitles.add(R.id.gold);
        mTitles.add(R.id.V2EX);
        mTitles.add(R.id.collect);
        mTitles.add(R.id.setting);
        mTitles.add(R.id.about);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new ZhihuDilyNewsFragment());
        mFragments.add(new WeChatFragment());
        mFragments.add(new GankFragment());
        mFragments.add(new GoldFragment());
        mFragments.add(new V2exVFragment());
        mFragments.add(new CollectFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new AboutFragment());
    }

    @Override
    protected void initListenter() {
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId != R.id.info && itemId != R.id.options) {
                    menuItem.setChecked(true);
                    switch (itemId) {
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_GOLD);
                            break;
                        case R.id.V2EX:
                            searchView.setVisibility(View.GONE);
                            switchFragment(TYPE_V2EX);
                            break;
                        case R.id.collect:
                            switchFragment(TYPE_COLLECT);
                            break;
                        case R.id.setting:
                            switchFragment(TYPE_SETTING);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            break;
                    }
                    dl.closeDrawer(Gravity.LEFT);
                } else {
                    menuItem.setChecked(false);
                }
                return false;
            }
        });
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //按下搜索或者提交的时候回调,
                //ToastUtil.showShort("提交的内容:"+query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //搜索框内容发生改变的回调,
                //ToastUtil.showShort(newText);
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展示
                //ToastUtil.showShort("展示");
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框隐藏
                //ToastUtil.showShort("关闭");
            }
        });
    }


    private void switchFragment(int type) {
        //显示一个，隐藏一个
        Fragment fragment = mFragments.get(type);
        Fragment hideFragment = mFragments.get(mLastFragmentPosition);
        FragmentTransaction transaction = mManager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fragm_container, fragment);
        }
        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();

        mLastFragmentPosition = type;
        //显示或者隐藏搜索框
        if (type == TYPE_WECHAT || type == TYPE_GANK) {
            mSearchItem.setVisible(true);
        } else {
            mSearchItem.setVisible(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        mSearchItem = menu.findItem(R.id.action_search);
        //隐藏搜索框
        mSearchItem.setVisible(false);
        searchView.setMenuItem(mSearchItem);

        return true;
    }

    /**
     * 回退键点击回调
     */
    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
