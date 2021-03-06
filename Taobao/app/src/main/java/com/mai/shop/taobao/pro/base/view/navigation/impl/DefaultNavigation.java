package com.mai.shop.taobao.pro.base.view.navigation.impl;

import android.view.View;
import android.widget.LinearLayout;

import com.mai.shop.taobao.R;

/**
 * 左中右场景实现
 * @author mai
 * create at 2018/3/2 15:45
 */

public abstract class DefaultNavigation<P extends AbsNavigation.NavigationParams> extends AbsNavigation<P>{


    public DefaultNavigation(P params) {
        super(params);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.navigation_default;
    }

    @Override
    public void build() {
        super.build();
        //初始化布局
        LinearLayout ll_left = (LinearLayout) findViewById(R.id.ll_left);
        LinearLayout ll_center = (LinearLayout) findViewById(R.id.ll_center);
        LinearLayout ll_right = (LinearLayout) findViewById(R.id.ll_right);
        //绑定子布局
        bindParent(bindLeftLayoutId(),ll_left);
        bindParent(bindCenterLayoutId(),ll_center);
        bindParent(bindRightLayoutId(),ll_right);

        //初始化子布局
        initLeftLayout(ll_left);
        initCenterLayout(ll_center);
        initRightLayout(ll_right);

        setBackGroundColor(bindBackgroundColor());
    }


    //左边布局
    public abstract int bindLeftLayoutId();
    //中间布局
    public abstract int bindCenterLayoutId();
    //右边布局
    public abstract int bindRightLayoutId();

    public abstract int bindBackgroundColor();
    //初始化左边布局
    public abstract void initLeftLayout(View view);
    //初始化中间布局
    public abstract void initCenterLayout(View view);
    //初始化右边布局
    public abstract void initRightLayout(View view);

}
