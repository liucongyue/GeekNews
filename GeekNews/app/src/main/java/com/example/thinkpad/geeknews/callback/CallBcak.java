package com.example.thinkpad.geeknews.callback;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public interface CallBcak<T> {
    void onSuccess(T bean);

    void onFail(String msg);

}
