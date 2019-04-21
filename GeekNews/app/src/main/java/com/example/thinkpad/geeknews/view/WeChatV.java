package com.example.thinkpad.geeknews.view;

import com.example.thinkpad.geeknews.base.BaseMvpView;
import com.example.thinkpad.geeknews.bean.WeChatBean.WechatBean;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public interface WeChatV extends BaseMvpView {
    void getData(WechatBean bean);

    int getpage();

    String getkey();

    int getnum();
}
