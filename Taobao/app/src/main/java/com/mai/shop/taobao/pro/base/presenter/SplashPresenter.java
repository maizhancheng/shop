package com.mai.shop.taobao.pro.base.presenter;

import android.os.Handler;

import com.mai.shop.taobao.WelcomeActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2018/2/27.
 */

public class SplashPresenter {

    WelcomeActivity view;
    public SplashPresenter(WelcomeActivity view ){
        this.view = view;
    }

    //Handler
    public void start(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (view.isUserLogin()) {
                    view.ToHome();
                } else {
                    view.ToLogin();
                }
            }
        }, 5000);
    }

    //Timer
    public void start(long splash_time){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (view.isUserLogin()) {
                    view.ToHome();
                } else {
                    view.ToLogin();
                }
            }
        };
        timer.schedule(timerTask,splash_time);
    }

}
