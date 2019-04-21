package com.example.thinkpad.geeknews.view;

import com.example.thinkpad.geeknews.base.BaseMvpView;
import com.example.thinkpad.geeknews.bean.geekbean.ZhuanLanBean;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public interface Special_columnV extends BaseMvpView{
    void setData(ZhuanLanBean bean);

    int getpage();
}
