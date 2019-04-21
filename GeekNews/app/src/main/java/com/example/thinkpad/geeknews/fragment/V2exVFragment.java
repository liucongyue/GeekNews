package com.example.thinkpad.geeknews.fragment;


import android.app.Fragment;
import android.util.Log;

import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.base.BaseFragment;
import com.example.thinkpad.geeknews.bean.V2EXBean.V2exTabBean;
import com.example.thinkpad.geeknews.presenter.V2exP;
import com.example.thinkpad.geeknews.view.V2exV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class V2exVFragment extends BaseFragment<V2exV, V2exP> implements V2exV {
    private static final String TAG = "V2exFragment";
    private String mUrl = "https://www.v2ex.com/";
    private ArrayList<V2exTabBean> mTablist;

    @Override
    protected V2exP initPresenter() {
        return new V2exP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex_v;
    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mTablist = new ArrayList<>();
                    Document doc = null;

                    doc = Jsoup.connect(mUrl).get();

                    Element tabs = doc.select("div#Tabs").first();
                    Elements allTabs = tabs.select("a[href]");
                    for (Element element : allTabs) {
                        String linkHref = element.attr("href");
                        String tab = element.text();
                        Log.d(TAG, "linkHref: " + linkHref + ",tab:" + tab);
                        V2exTabBean bean = new V2exTabBean(linkHref, tab);
                        mTablist.add(bean);
                    }

                    Log.d(TAG, "tabsList: " + mTablist.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
