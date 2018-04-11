package com.mai.shop.taobao.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mai.shop.taobao.mvp.view.impl.MvpFragment;
import com.mai.shop.taobao.pro.base.presenter.BasePresenter;

/**
 *
 * @author mai
 * create at 2018/3/2 10:02
 */

public abstract class BaseFragment<P extends BasePresenter,V extends BaseView> extends MvpFragment<P,V> {

    //缓存视图
    private View contentView;
    private boolean isInit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if ( contentView == null){
            contentView = inflater.inflate(bindLayoutId(),container,false);
            initContentView( contentView);
        }
        //判断Fragment对应的Activity是否存在这个视图
        ViewGroup parent = (ViewGroup) contentView.getParent();
        if (parent !=null){
            //存在，删除 重新添加 这样的方式就可以缓存视图
            parent.removeView(contentView);
        }
        return contentView;
    }

    public View getContentView() {
        return contentView;
    }

    public void initData(){

    }

    @Override
    public P bindPresenter() {
        return null;
    }

    @Override
    public V bindView() {
        return null;
    }

    public abstract int bindLayoutId();

    public abstract void initContentView(View contentView);
}
