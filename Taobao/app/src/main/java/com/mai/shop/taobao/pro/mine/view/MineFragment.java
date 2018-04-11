package com.mai.shop.taobao.pro.mine.view;

import android.view.View;
import android.view.ViewGroup;

import com.mai.shop.taobao.R;
import com.mai.shop.taobao.pro.base.view.BaseFragment;
import com.mai.shop.taobao.pro.base.view.navigation.impl.AppNavagion;

/**
 * Created by admin on 2018/3/1.
 */

public class MineFragment extends BaseFragment{

    @Override
    public int bindLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View contentView) {
        AppNavagion.Builder builder = new AppNavagion.Builder(getActivity(), (ViewGroup) contentView);
        builder.setCenterImageRes(R.string.mine_tab)
                .setbackgroundColor(R.color.white).create().build();
    }
}
