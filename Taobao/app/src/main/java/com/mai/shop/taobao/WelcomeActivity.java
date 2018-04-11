package com.mai.shop.taobao;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mai.shop.taobao.pro.base.presenter.SplashPresenter;
import com.mai.shop.taobao.pro.base.view.SplashView;

/**
 * Created by mai on 2018/2/26.
 */

public class WelcomeActivity extends Activity implements SplashView{
    SplashPresenter splashPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        splashPresenter = new SplashPresenter(this);
        startAnimation();
        splashPresenter.start();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    private void startAnimation(){
        ImageView iv_welcome = (ImageView) findViewById(R.id.iv_welcome);
        //target:动画对象
        //propertyName：动画类型（alpha:透明度； translationX,translationY : 平移动画  scale : 缩放动画）
        //values : 轨迹（起点，终点）
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_welcome,"alpha",0.4f,1.0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //启动引导页
                startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
            }
        });
    }

    @Override
    public void ToHome() {

    }

    @Override
    public void ToLogin() {

    }

    @Override
    public boolean isUserLogin() {
        return false;
    }
}
