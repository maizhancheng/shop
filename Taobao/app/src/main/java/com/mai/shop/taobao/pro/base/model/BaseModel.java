package com.mai.shop.taobao.pro.base.model;

import android.content.Context;

import com.mai.shop.taobao.mvp.model.MvpModel;

/**
 * Created by mai on 2018/2/26.
 */

public abstract class BaseModel implements MvpModel {
    private Context context;
    public BaseModel(Context context){
        this.context = context;
    }

    public Context getContext(){
        return this.context;
    }

}
