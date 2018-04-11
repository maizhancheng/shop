package com.mai.shop.taobao.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.mai.shop.taobao.mvp.presenter.MvpPresenter;
import com.mai.shop.taobao.mvp.view.MvpView;

/**
 *
 * @author mai
 * create at 2018/3/1 12:12
 */

public abstract class MvpActivity<P extends MvpPresenter,V extends MvpView> extends FragmentActivity {

    private P presenter;
    private V view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null){
            presenter = bindPresenter();
            //绑定V层
            presenter.attachView(bindView());
        }

    }

    /**
     * 绑定具体实现类
     * @return
     */
    public abstract P bindPresenter();

    /**
     * 绑定具体View
     * @return
     */
    public abstract V bindView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.dettachView();
        }
    }

}
