package com.mai.shop.taobao.http.impl.system;

import android.content.Context;

import com.mai.shop.taobao.http.impl.AbsHttpCommand;
import com.mai.shop.taobao.http.utils.HttpUtils;


/**
 * 系统默认的网络请求(系统默认的网络引擎)
 *
 * Created by Dream on 16/5/28.
 */
public class SystemHttpCommand extends AbsHttpCommand<SystemRequestParam> {

    @Override
    public String executeGet(Context context, String url, SystemRequestParam requestParam) {
        try {
            return HttpUtils.get(url,requestParam.getRequestParam());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String executePost(Context context, String url, SystemRequestParam requestParam) {
        try {
            return HttpUtils.post(url,requestParam.getRequestParam());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
