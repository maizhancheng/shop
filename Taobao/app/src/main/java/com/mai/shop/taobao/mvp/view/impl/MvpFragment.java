package com.mai.shop.taobao.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mai.shop.taobao.mvp.presenter.MvpPresenter;
import com.mai.shop.taobao.mvp.view.MvpView;

/**
 * 继承v4包的Fragment
 * Created by mai on 2018/2/26.
 */

public abstract class MvpFragment<P extends MvpPresenter,V extends MvpView> extends Fragment{

    private P presenter;
    private V view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null){
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
