package com.mai.shop.taobao.pro.base.view.navigation.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mai.shop.taobao.R;
import com.mai.shop.taobao.pro.base.view.navigation.INavigation;

/**
 * Created by admin on 2018/3/2.
 */

public class AppNavagion extends DefaultNavigation<AppNavagion.AppNavigationParams> {

    public AppNavagion(AppNavigationParams p){
        super(p);
    }


    //第三步，实现具体功能

    @Override
    public int bindLeftLayoutId() {
        return R.layout.navigation_default_left;
    }

    @Override
    public int bindCenterLayoutId() {
        return R.layout.navigation_default_center;
    }

    @Override
    public int bindRightLayoutId() {
        return R.layout.navigation_default_right;
    }

    @Override
    public int bindBackgroundColor() {
        if (getParams().backgroundColor!= 0){
            return getParams().backgroundColor;
        }else {
            return R.color.white;
        }
    }

    @Override
    public void initLeftLayout(View view) {
        ImageView iv_default_left = (ImageView) view.findViewById(R.id.iv_default_left);
        if (getParams().leftImageRes != 0){
            iv_default_left.setVisibility(View.VISIBLE);
            iv_default_left.setImageResource(getParams().leftImageRes);
            iv_default_left.setOnClickListener(getParams().leftOnclickListener);
        }else {
            iv_default_left.setVisibility(View.GONE);
        }
    }

    @Override
    public void initCenterLayout(View view) {
        TextView tv_default_center = (TextView) view.findViewById(R.id.tv_default_center);
        if (getParams().centerTitleRes!=0){
            tv_default_center.setVisibility(View.VISIBLE);
            tv_default_center.setText(getString(getParams().centerTitleRes));
        }else {
            tv_default_center.setVisibility(View.GONE);
        }
    }

    @Override
    public void initRightLayout(View view) {
        ImageView iv_default_right = (ImageView) view.findViewById(R.id.iv_default_right);
        if (getParams().rightImageRes!=0){
            iv_default_right.setVisibility(View.VISIBLE);
            iv_default_right.setImageResource(getParams().rightImageRes);
            view.setOnClickListener(getParams().rightOnclickListener);
        }else {
            iv_default_right.setVisibility(View.GONE);
        }
    }

    //第一步：定义builder参数集
    public static class AppNavigationParams extends AbsNavigation.NavigationParams{

        public int leftImageRes;
        public int centerTitleRes;
        public int rightImageRes;
        public int backgroundColor;

        public View.OnClickListener leftOnclickListener;
        public View.OnClickListener rightOnclickListener;

        public AppNavigationParams(Context context, ViewGroup parent) {
            super(context, parent);
        }
    }

    //第二步：构建ToolBar
    public static class Builder extends AbsNavigation.Builder{

        private AppNavigationParams P;

        public Builder(Context context,ViewGroup parent){
            super(context, parent);
            this.P = new AppNavigationParams(context, parent);
        }



        public Builder setLeftImageRes(int leftImageRes){
            this.P.leftImageRes = leftImageRes;
            return this;
        }

        public Builder setCenterImageRes(int centerTitleRes){
            this.P.centerTitleRes = centerTitleRes;
            return this;
        }

        public Builder setRightImageRes(int rightImageRes){
            this.P.rightImageRes = rightImageRes;
            return this;
        }

        public Builder setbackgroundColor(int backgroundColor){
            this.P.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setLeftOnclickListener(View.OnClickListener leftOnclickListener){
            this.P.leftOnclickListener = leftOnclickListener;
            return this;
        }

        public Builder setRightOnclickListener(View.OnClickListener rightOnclickListener){
            this.P.rightOnclickListener = rightOnclickListener;
            return this;
        }

        @Override
        public INavigation create() {
            return new AppNavagion(this.P);
        }
    }


}
