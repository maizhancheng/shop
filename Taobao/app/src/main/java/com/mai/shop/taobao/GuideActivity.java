package com.mai.shop.taobao;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mai.shop.taobao.lib.indicator.CircleIndicator;
import com.mai.shop.taobao.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/27.
 */

public class GuideActivity extends FragmentActivity {

    private List<Integer> img_resLst;
    private List<ImageView> imageViewList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        initGuideDate();
        initGuideView();
        initView();
    }

    //1.初始化引导页数据
    private void initGuideDate(){
        img_resLst = new ArrayList<>();
        img_resLst.add(R.mipmap.apk_img1);
        img_resLst.add(R.mipmap.apk_img2);
        img_resLst.add(R.mipmap.apk_img3);
    }

    //2.初始化每一个页面
    private void initGuideView(){
        imageViewList = new ArrayList<>();
        for (int i =0;i<img_resLst.size();i++){
            imageViewList.add(new ImageView(this));
        }
    }

    //3.初始化分页控件
    private void initView(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(new GuideAdapter());
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        findViewById(R.id.btn_enter_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(GuideActivity.this,MainActivity.class));
            }
        });
    }


    //ViewPager 的适配器。
    private class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViewList.get(position);
            iv.setImageResource(img_resLst.get(position));
            //等比例缩放 （1：4）
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(DisplayUtil.dp2px(GuideActivity.this,170),DisplayUtil.dp2px(GuideActivity.this,200));
            container.addView(imageViewList.get(position),params);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //释放内存方法
//            container.removeView((View) object);
            container.removeView(imageViewList.get(position));
        }



    }

}
