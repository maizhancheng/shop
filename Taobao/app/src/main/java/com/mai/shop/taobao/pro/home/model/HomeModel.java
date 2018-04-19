package com.mai.shop.taobao.pro.home.model;

import android.content.Context;

import com.mai.shop.taobao.http.IHttpCommand;
import com.mai.shop.taobao.http.impl.system.SystemHttpCommand;
import com.mai.shop.taobao.http.impl.system.SystemRequestParam;
import com.mai.shop.taobao.http.utils.HttpTask;
import com.mai.shop.taobao.http.utils.HttpUtils;
import com.mai.shop.taobao.pro.base.model.BaseModel;

/**
 * Created by admin on 2018/4/13.
 */

public class HomeModel extends BaseModel {

    private static final String url = "";

    public HomeModel(Context context) {
        super(context);
    }

    /**
     * 获取女装数据
     * @param pageSize
     * @param pageNumber
     * @param type
     * @param onHttpResultListener
     */
    public void loadHomeList(int pageSize,
                             int pageNumber ,
                             String type,
                             final HttpUtils.OnHttpResultListener<String> onHttpResultListener){
        //发送网络请求，或者操作数据库，操作文件等等。。
        HttpTask.Builder builder = new HttpTask.Builder(getContext(), url, new HttpTask.CallBack() {
            @Override
            public void onResult(String result) {
                onHttpResultListener.onResult(result);
            }
        });
        SystemRequestParam systemRequestParam = new SystemRequestParam();
        systemRequestParam.put("pageSize",String.valueOf(pageSize));
        systemRequestParam.put("pageNumber",String.valueOf(pageNumber));
        systemRequestParam.put("type",String.valueOf(type));
        builder.setRequestParam(systemRequestParam)
                .setRequestType(IHttpCommand.RequestType.Post).setHttpCommand(new SystemHttpCommand()).create().build();


    }

}
