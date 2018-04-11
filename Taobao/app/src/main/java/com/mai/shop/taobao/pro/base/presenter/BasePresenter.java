package com.mai.shop.taobao.pro.base.presenter;

import android.content.Context;

import com.mai.shop.taobao.mvp.presenter.impl.MvpBasePresenter;
import com.mai.shop.taobao.pro.base.view.BaseView;

/**
 * Created by admin on 2018/2/26.
 */

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    public BasePresenter(Context context){
        super(context);
    }
}
