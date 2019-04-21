package com.example.thinkpad.geeknews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.adapter.GoldAdapter.RlvShowAdapter;
import com.example.thinkpad.geeknews.base.BaseActivity;
import com.example.thinkpad.geeknews.base.Constants;
import com.example.thinkpad.geeknews.bean.GoldBean.GoldShowBean;
import com.example.thinkpad.geeknews.presenter.EmptyP;
import com.example.thinkpad.geeknews.view.EmptyV;
import com.example.thinkpad.geeknews.widget.SimpleTouchHelperCallBack;
import com.example.thinkpad.geeknews.widget.TouchCallBack;

import java.util.ArrayList;

import butterknife.BindView;

public class ShowActivity extends BaseActivity<EmptyV, EmptyP> implements EmptyV {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ArrayList<GoldShowBean> mList;

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        mList = (ArrayList<GoldShowBean>) getIntent().getSerializableExtra(Constants.DATA);

        mToolBar.setTitle(R.string.special_show);
        mToolBar.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(mToolBar);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        RlvShowAdapter adapter = new RlvShowAdapter(mList);
        mRlv.setAdapter(adapter);
        mRlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        //删除和移动的功能
        SimpleTouchHelperCallBack simpleTouchHelperCallback = new SimpleTouchHelperCallBack(adapter);
        simpleTouchHelperCallback.setSwipeEnable(false);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(mRlv);
    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA, mList);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }
}
