package com.mai.shop.taobao.pro.base.view.navigation;

/**
 * 所有ToolBar 的规范
 * @author mai
 * create at 2018/3/2 11:11
 */

public interface INavigation {
    //绑定布局
    int bindLayoutId();
    //创建ToolBar
    void build();
}
