package com.mai.shop.taobao;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.mai.shop.taobao.lib.menu.SlidingMenu;
import com.mai.shop.taobao.pro.buy.view.BuyFragment;
import com.mai.shop.taobao.pro.home.view.fragment.HomeFragment;
import com.mai.shop.taobao.pro.mine.view.MineFragment;
import com.mai.shop.taobao.pro.tata.view.TaTaFragment;
import com.mai.shop.taobao.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private SlidingMenu slidingMenu;
    private List<MenuItem> menuItemlst;

    private FragmentTabHost mTabHost;
    private Class fragmentArray[] = {HomeFragment.class, TaTaFragment.class, BuyFragment.class,MineFragment.class};
    private int mTitleArray[] = {R.string.home_tab, R.string.tata_tab,R.string.car_tab,R.string.mine_tab };
    private int mImageViewArray[] = {R.drawable.tab_home,R.drawable.tab_tata,R.drawable.tab_buy,R.drawable.tab_mine};
    private String mTextviewArray[] = {"home", "tata","buy","mine"};
    private ImageView msgUnread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSlidingMenu();
        initTabbar();
        setStatusBarColor(0);
    }
    //1.集成菜单组件
    //2.初始化SlidingMenu
    private void initSlidingMenu(){
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);//菜单位置
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//触摸方式---全屏
        slidingMenu.setShadowWidth(DisplayUtil.dp2px(this,200));//设置菜单宽度
        slidingMenu.setBehindOffset(DisplayUtil.dp2px(this,150)); //距离右边
        slidingMenu.setFadeDegree(0.3f);//透明度
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);//绑定菜单
//        setStatusBar();
        initMenuData();
        initSlidingMenuContent();

    }

    //3.初始化左边菜单布局
    private void initSlidingMenuContent(){
        View menuLayout =  getLayoutInflater().inflate(R.layout.menu_layout,null);
        slidingMenu.setMenu(menuLayout);

        ListView menulv = (ListView) menuLayout.findViewById(R.id.lv_menu);
        menulv.setAdapter(new MenuAdapter());
    }

    //5.初始化Menu数据
    private void initMenuData(){
        menuItemlst = new ArrayList<MenuItem>();
        menuItemlst.add(new MenuItem("女装"));
        menuItemlst.add(new MenuItem("女装"));
        menuItemlst.add(new MenuItem("女装"));
        menuItemlst.add(new MenuItem("女装"));
        menuItemlst.add(new MenuItem("女装"));
        menuItemlst.add(new MenuItem("女装"));
        menuItemlst.add(new MenuItem("女装"));

    }

    private class MenuItem{
        public String menuText;
        public String menuType;
        public MenuItem(String menuText){
            this.menuText = menuText;
        }
    }

    //6.准备菜单menu Adapter
    private class MenuAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return menuItemlst.size();
        }

        @Override
        public Object getItem(int position) {
            return menuItemlst.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MenuViewHolder viewHolder = null;
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.menu_item,parent,false);
                viewHolder = new MenuViewHolder((ViewGroup) convertView);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (MenuViewHolder) convertView.getTag();
            }
            viewHolder.tv_menu_title.setText(menuItemlst.get(position).menuText);
            return convertView;
        }

        class MenuViewHolder{
            TextView tv_menu_title;
//            View menuItem;
            public MenuViewHolder(ViewGroup contentView){
//                menuItem = getLayoutInflater().inflate(R.layout.menu_item,contentView,false);
                tv_menu_title = (TextView) contentView.findViewById(R.id.tv_menu_title);
            }
        }
    }

    //7.1 初始化Tabbar
    private void initTabbar(){
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.contentPanel);
        int fragmentCount = fragmentArray.length;
        for (int i = 0; i < fragmentCount; ++i) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().setDividerDrawable(null);

        }
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                //更新tabbar UI
                updateTab( mTabHost);
            }
        });

    }

    //7.2 获取TabItemView
    private View getTabItemView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.home_tab, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(mImageViewArray[index]);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(mTitleArray[index]);
        if (index == 0){
            msgUnread = (ImageView) view.findViewById(R.id.tabUnread);
            view.setBackgroundColor(getResources().getColor(R.color.white));//选中后的背景
        }
        return view;
    }

    //7.3 更新tab UI
    private void updateTab(final TabHost tabHost) {
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            View view = tabHost.getTabWidget().getChildAt(i);
            if (tabHost.getCurrentTab() == i) {//选中
                view.setBackgroundColor(getResources().getColor(R.color.white));//选中后的背景
            } else {//不选中
                view.setBackgroundColor(getResources().getColor(R.color.white));//非选择的背景
            }
        }
        //设置状态栏颜色，sdk>21
        setStatusBarColor(tabHost.getCurrentTab());
    }

    private void setStatusBarColor(int position){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.i("mak","positon = " + position);
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (position == 0){
                getWindow().setStatusBarColor(getResources().getColor(R.color.navigation_background));
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }else if (position == 1){
                getWindow().setStatusBarColor(getResources().getColor(R.color.white));
                getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }else if (position == 2){
                getWindow().setStatusBarColor(getResources().getColor(R.color.white));
                getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }else if (position == 3){
                getWindow().setStatusBarColor(getResources().getColor(R.color.white));
                getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }



    protected boolean useThemestatusBarColor = true;//是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useStatusBarColor = true;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            Log.i("mak","5.0以上");
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));
            } else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            Log.i("mak","4.5 - 5.0以上");
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && useStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            Log.i("mak","6.0以上");
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}
