package com.example.thinkpad.geeknews.widget;


public interface TouchCallBack {
    //数据交换
    void onItemMove(int fromPosition, int toPosition);

    //删除条目
    void onItemDelete(int position);
}
