package com.example.thinkpad.geeknews.bean.V2EXBean;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class V2exTabBean {
    public String link;
    public String tab;

    public V2exTabBean(String link, String tab) {
        this.link = link;
        this.tab = tab;
    }

    @Override
    public String toString() {
        return "V2exTabBean{" +
                "link='" + link + '\'' +
                ", tab='" + tab + '\'' +
                '}';
    }
}
