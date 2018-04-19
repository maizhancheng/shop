package com.mai.shop.taobao.pro.home.presenter;

import android.content.Context;

import com.mai.shop.taobao.http.utils.HttpUtils;
import com.mai.shop.taobao.pro.base.presenter.BasePresenter;
import com.mai.shop.taobao.pro.home.model.HomeModel;
import com.mai.shop.taobao.pro.home.view.HomeView;

/**
 * Created by admin on 2018/4/13.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private int pageNumber = 0;
    private HomeModel homeModel;

    public HomePresenter(Context context) {
        super(context);
        homeModel = new HomeModel(context);
    }

    public void loadHomeList(int pageSize,String type){
        homeModel.loadHomeList(pageSize, pageNumber, type, new HttpUtils.OnHttpResultListener<String>() {
            @Override
            public void onResult(String result) {
                getView().onHomeListResult(result);
            }
        });
    }

}
