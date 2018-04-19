package com.mai.shop.taobao.pro.home.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import com.mai.shop.taobao.R;
import com.mai.shop.taobao.pro.base.view.BaseFragment;
import com.mai.shop.taobao.pro.base.view.navigation.impl.HomeNavagion;
import com.mai.shop.taobao.pro.home.presenter.HomePresenter;
import com.mai.shop.taobao.pro.home.view.HomeView;
import com.mai.shop.taobao.utils.ToastUtil;

/**
 * 首页Fragment
 * @author mai
 * @date
 */

public class HomeFragment extends BaseFragment<HomePresenter,HomeView> implements HomeView{

    @Override
    public HomePresenter bindPresenter() {
        return new HomePresenter(getActivity());
    }

    //绑定view接口
    @Override
    public HomeView bindView() {
        return this;
    }

    @Override
    public int bindLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initContentView(View contentView) {
        initNavigation(contentView);
        //获取数据
        getPresenter().loadHomeList(10,"13678");
    }

    private void initNavigation(View contentView){
        LinearLayout linearLayout = (LinearLayout) contentView.findViewById(R.id.ll_main);
        HomeNavagion.Builder builder = new HomeNavagion.Builder(getActivity(), linearLayout);
        builder.setLeftImageRes(R.mipmap.apk_all_top_nav)
                .setCenterImageRes(R.string.home_tab)
                .setRightImageRes(R.drawable.anim_sign_coin)
                .setRightTextRes(R.string.nav_sign_in)
                .setLeftOnclickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"Open Menu!");
                    }
                })
                .setRightOnclickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"Sign in!");
                    }
                }).create().build();
    }

    @Override
    public void onHomeListResult(Object data) {
        //解析json
    }


}

