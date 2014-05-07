package com.collosteam.colloscirclereitingbar.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomPanel extends View {

    public int greenCount = 0;

    public int mainCircleColor = Color.parseColor("#646464");
    public int activeCircleColor = Color.parseColor("#E009E009");

    public MyCustomPanel(Context context) {
        super(context);
    }

    public MyCustomPanel(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyCustomPanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setActivateWithAnimation(final Activity activity, long animationLength, int activateCount) {
        for (int i = 0; i < activateCount; i++) {
            final int finalI = i;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MyCustomPanel.this.greenCount = finalI + 1;
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            MyCustomPanel.this.invalidate();
                        }
                    });
                }
            }, animationLength + animationLength * i);
        }
    }

    @Override
    public void draw(final Canvas canvas) {

        final Paint paint = new Paint();
        paint.setColor(mainCircleColor);
        final float radius = 20;
        for (int i = 0; i < 10; i++) {
            canvas.drawCircle(2 * (radius + radius / 10) * i + radius, radius + radius / 10, radius, paint);
        }
        paint.setColor(activeCircleColor);
        for (int i = 0; i < greenCount; i++) {
            canvas.drawCircle(2 * (radius + radius / 10) * i + radius, radius + radius / 10, radius, paint);
        }
    }
}