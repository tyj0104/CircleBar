package com.xiaochouyu.circleprogressbar;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author Administrator
 * @date 2017/10/17
 */

public class CircleBarAnim extends Animation {
    public float sweepAngle;

    public CircleBarAnim() {
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        sweepAngle = interpolatedTime * 360;
        
    }


}
