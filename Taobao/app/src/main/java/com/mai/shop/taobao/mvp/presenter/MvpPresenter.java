package com.mai.shop.taobao.mvp.presenter;

import com.mai.shop.taobao.mvp.view.MvpView;

/**
 * MVP-P层
 * Created by mai on 2018/2/26.
 */

public interface MvpPresenter<V extends MvpView> {
    /**
     * 绑定View
     * @param View
     */
    void attachView(V View);

    /**
     * 解除绑定
     */
    void dettachView();
}
