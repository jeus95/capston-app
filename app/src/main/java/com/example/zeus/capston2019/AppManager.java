package com.example.zeus.capston2019;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Vibrator;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

public class AppManager  {

    private static AppManager s_instance;
    private Resources m_resources;
    private Context context;
    private Display display;
    private Point size;
    private Vibrator vibrator;
    private static Activity mainAct;

    //SingleTon Pattern
    private AppManager() {

    }



    public static AppManager getInstance() {
        if (s_instance == null){
            s_instance = new AppManager();

        }
        return s_instance;
    }

    //Get, Set Method


    public void setResources(Resources _resources) {
        m_resources = _resources;
    }

    public Resources getResources() {
        return m_resources;
    }

    public Bitmap getBitmap(int r) {
        return BitmapFactory.decodeResource(m_resources, r);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Point getDeviceSize() {
        if (size == null) { //첫실행 한번만 디바이스 사이즈를 구해오기 위함
            display = ((WindowManager) AppManager.getInstance().getContext().getSystemService(AppManager.getInstance().getContext().WINDOW_SERVICE)).getDefaultDisplay();
            size = new Point();
            display.getSize(size);
        }

        return size;
    }


    public void vibrate(long milliseconds) {
        if (vibrator == null)
            vibrator = (Vibrator) AppManager.getInstance().getContext().getSystemService(Context.VIBRATOR_SERVICE);

        vibrator.vibrate(milliseconds);
    }


    public void setMainAct(Activity act){mainAct = act;}


    public Activity getMainAct(){return mainAct;}

    public static void setAutoSizeView(Context context, String imageUrl, View view) {

        final View changeView = view;

        // image url에 연결해서 이미지의 width, height를 받아온다.
        Glide.with(context)
                .load(imageUrl)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        final int imageHeight = glideDrawable.getIntrinsicHeight();
                        final int imageWidth = glideDrawable.getIntrinsicWidth();

                        // 파라미터로 받아온 width, height를 view에 적용한다.
                        ViewTreeObserver vto = changeView.getViewTreeObserver();
                        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            @Override
                            public void onGlobalLayout() {
                                changeView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                int width = changeView.getMeasuredWidth();
                                int height = (width * imageHeight)/imageWidth;

                                changeView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                            }
                        });
                    }
                });
    }


}

