package com.mai.shop.taobao.http.impl;

import android.content.Context;

import com.mai.shop.taobao.http.IHttpCommand;
import com.mai.shop.taobao.http.IRequestParam;

/**
 * 作者: Dream on 16/6/29 12:35
 * QQ:510278658
 * E-mail:510278658@qq.com
 */
public abstract class AbsHttpCommand<T extends IRequestParam> implements IHttpCommand<T> {

    @Override
    public String execute(Context context, String url, IHttpCommand.RequestType requestType, T requestParam) {
        if (requestType == RequestType.Default) {
            return executeGet(context, url, requestParam);
        } else if (requestType == RequestType.Get) {
            return executeGet(context, url, requestParam);
        } else if (requestType == RequestType.Post) {
            return executePost(context, url, requestParam);
        } else if (requestType == RequestType.Delete) {
            return executeDelete(context, url, requestParam);
        }
        return null;
    }

    /**
     * 执行Get请求
     *
     * @param context
     * @param url
     * @param requestParam
     * @return
     */
    public String executeGet(Context context, String url, T requestParam) {
        return null;
    }

    /**
     * 执行Post请求
     *
     * @param context
     * @param url
     * @param requestParam
     * @return
     */
    public String executePost(Context context, String url,T requestParam) {
        return null;
    }

    /**
     * 执行Delete请求
     *
     * @param context
     * @param url
     * @param requestParam
     * @return
     */
    public String executeDelete(Context context, String url, T requestParam) {
        return null;
    }

}
