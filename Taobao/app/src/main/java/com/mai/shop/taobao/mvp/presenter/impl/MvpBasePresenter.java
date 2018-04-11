package com.mai.shop.taobao.mvp.presenter.impl;

import android.content.Context;

import com.mai.shop.taobao.mvp.presenter.MvpPresenter;
import com.mai.shop.taobao.mvp.view.MvpView;

/**
 * 具体实现绑定View
 * Created by mai on 2018/2/26.
 */

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private Context context;
    private V view;

    public MvpBasePresenter(Context context){
        this.context = context;
    }

    public Context getContext(){
        return context;
    }

    public V getView(){
        return view;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        this.view = null;
    }
}
