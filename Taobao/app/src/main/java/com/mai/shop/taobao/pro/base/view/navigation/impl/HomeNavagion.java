package com.mai.shop.taobao.pro.base.view.navigation.impl;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mai.shop.taobao.R;
import com.mai.shop.taobao.pro.base.view.navigation.INavigation;

/**
 * Created by admin on 2018/3/2.
 */

public class HomeNavagion extends DefaultNavigation<HomeNavagion.HomeNavigationParams> {

    public HomeNavagion(HomeNavigationParams p){
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
        return R.layout.navigation_home_right;
    }

    @Override
    public int bindBackgroundColor() {
        return R.color.navigation_background;
    }

    @Override
    public void initLeftLayout(View view) {
        ImageView iv_default_left = (ImageView) view.findViewById(R.id.iv_default_left);
        iv_default_left.setImageResource(getParams().leftImageRes);
        iv_default_left.setOnClickListener(getParams().leftOnclickListener);
    }

    @Override
    public void initCenterLayout(View view) {
        TextView tv_default_center = (TextView) view.findViewById(R.id.tv_default_center);
        tv_default_center.setText(getString(getParams().centerTitleRes));
    }

    @Override
    public void initRightLayout(View view) {
        ImageView iv_home_right = (ImageView) view.findViewById(R.id.iv_home_right);
        iv_home_right.setImageResource(getParams().rightImageRes);
        view.setOnClickListener(getParams().rightOnclickListener);


        TextView tv_home_right = (TextView) view.findViewById(R.id.tv_home_right);
        tv_home_right.setText(getString(getParams().rightTextRes));

        AnimationDrawable animationDrawable = (AnimationDrawable) iv_home_right.getBackground();
        animationDrawable.start();
    }

    //第一步：定义builder参数集
    public static class HomeNavigationParams extends AbsNavigation.NavigationParams{

        public int leftImageRes;
        public int centerTitleRes;
        public int rightImageRes;
        public int rightTextRes;

        public View.OnClickListener leftOnclickListener;
        public View.OnClickListener rightOnclickListener;

        public HomeNavigationParams(Context context, ViewGroup parent) {
            super(context, parent);
        }
    }

    //第二步：构建ToolBar
    public static class Builder extends AbsNavigation.Builder{

        private HomeNavigationParams P;

        public Builder(Context context,ViewGroup parent){
            super(context, parent);
            this.P = new HomeNavigationParams(context, parent);
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

        public Builder setRightTextRes(int rightTextRes){
            this.P.rightTextRes = rightTextRes;
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
            return new HomeNavagion(this.P);
        }
    }


}
