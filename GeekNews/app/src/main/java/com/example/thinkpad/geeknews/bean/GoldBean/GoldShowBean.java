package com.example.thinkpad.geeknews.bean.GoldBean;

import java.io.Serializable;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class GoldShowBean implements Serializable{
    public String title;
    public boolean isChecked;

    public GoldShowBean(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }
}
