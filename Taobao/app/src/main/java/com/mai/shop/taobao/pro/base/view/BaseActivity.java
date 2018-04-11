package com.mai.shop.taobao.pro.base.view;

import com.mai.shop.taobao.mvp.view.impl.MvpActivity;
import com.mai.shop.taobao.pro.base.presenter.BasePresenter;

/**
 * Activity 基类
 * @author mai
 * create at 2018/3/2 10:02
 */

public abstract class BaseActivity<P extends BasePresenter,V extends BaseView> extends MvpActivity<P,V> {
    //将来开发时候会抽象N个功能

    @Override
    public P bindPresenter() {
        return null;
    }

    @Override
    public V bindView() {
        return null;
    }


}
