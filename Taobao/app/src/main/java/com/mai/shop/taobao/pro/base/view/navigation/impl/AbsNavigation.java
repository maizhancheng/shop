package com.mai.shop.taobao.pro.base.view.navigation.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.mai.shop.taobao.pro.base.view.navigation.INavigation;

/**
 * 只要是APP开发，一定会有布局创建和绑定的具体实现
 * @author mai
 * create at 2018/3/2 11:15
 */

public abstract class AbsNavigation<P extends AbsNavigation.NavigationParams> implements INavigation {

    public static final int DEFAULT_LAYOUT_ID = 0;


    private P params;

    public AbsNavigation(P params){
        this.params = params;
    }

    public P getParams() {
        return params;
    }

    public View findViewById(int id){
        return contentView.findViewById(id);
    }

    public String getString(int id){
        return params.context.getResources().getString(id);
    }

    public void setBackGroundColor(int color){
        contentView.setBackgroundColor(params.context.getResources().getColor(color));
    }

    @Override
    public int bindLayoutId() {
        return DEFAULT_LAYOUT_ID;
    }
    View contentView;
    @Override
    public void build() {
        //将ToolBar布局 绑定到 父容器
        if (contentView == null){
            contentView = bindParent(bindLayoutId(), getParams().parent);
        }
    }


    public View bindParent(int layoutId,ViewGroup parent){
        if (layoutId == DEFAULT_LAYOUT_ID){
            return null;
        }
        View layout =getParams().inflater.inflate(layoutId,parent,false);
        return bindParent(layout,parent);

    }

    public View bindParent(View childView, ViewGroup parent){
        //子容器只允许有一个父容器
        ViewParent viewParent = childView.getParent();
        if (viewParent!=null){
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.removeView(childView);
        }
        parent.addView(childView,0);
        return childView;
    }

    /**
     * Builder设计模式
     * 必须需要的参数
     */
    public static class NavigationParams{
        public Context context;
        public ViewGroup parent;
        public LayoutInflater inflater;
        public NavigationParams(Context context,ViewGroup parent){
            this.context = context;
            this.parent = parent;
            this.inflater = LayoutInflater.from(context);
        }
    }

    /**
     *
     */
    public abstract static class Builder{
        public Builder(Context context,ViewGroup parent){

        }

        //创建
        public abstract INavigation create();

    }



}
