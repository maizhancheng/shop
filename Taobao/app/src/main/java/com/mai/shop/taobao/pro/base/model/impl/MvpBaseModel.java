package com.mai.shop.taobao.pro.base.model.impl;

import android.content.Context;

import com.mai.shop.taobao.mvp.model.MvpModel;

/**
 * Created by mai on 2018/2/26.
 */

public abstract class MvpBaseModel implements MvpModel {
    private Context context;

    public MvpBaseModel(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
