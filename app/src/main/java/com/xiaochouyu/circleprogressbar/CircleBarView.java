package com.xiaochouyu.circleprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author Administrator
 * @date 2017/10/16
 */

public class CircleBarView extends View {
    /**
     * /绘制矩形的画笔
     */
    private Paint mPaintR;
    /**
     * 绘制圆弧的画笔
     */
    private Paint mPaintP;
    /**
     * 绘制圆弧背景画笔
     */
    private  Paint mPaintBg;
    /**
     * 最大进度
     */
    private float macNum;
    /**
     * 当前进度
     */
    private  float currentPross;
    /**
     * 背景圆弧扫过的弧度
     */
    private  float progressSweepAngl;
    /**
     * 起始角度
     */
    private  float startAngle;

    private CircleBarAnim mCircleBarAnim;
    /**
     * 扫过的角度
     */
    public float sweepAngle;

    public CircleBarView(Context context) {
        this(context, null);
    }

    public CircleBarView(Context context, AttributeSet attres) {
        this(context, attres, 0);
    }

    public CircleBarView(Context context, AttributeSet attres, int defStyleAttr) {
        super(context, attres, defStyleAttr);
        init();
    }

    private void init() {
        mCircleBarAnim = new CircleBarAnim();
        mPaintP = new Paint();
        mPaintP.setColor(Color.GREEN);
        mPaintP.setStrokeWidth(10);
        //  之描边 ，不填充
        mPaintP.setStyle(Paint.Style.STROKE);
        mPaintP.setAntiAlias(true);


        mPaintBg = new Paint();
        mPaintBg.setColor(Color.GRAY);
        mPaintBg.setStrokeWidth(15);
        //  之描边 ，不填充
        mPaintBg.setStyle(Paint.Style.STROKE);
        mPaintBg.setAntiAlias(true);

        mPaintR = new Paint();
        mPaintR.setColor(Color.BLUE);
        //  之描边 ，不填充
        mPaintR.setStyle(Paint.Style.STROKE);


        currentPross = 0;
        macNum= 100;

        startAngle = 0;
        sweepAngle = 360;

    }

    /**
     * 重写view的宽高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = 50f;
        float y = 50f;
        // 设置一个400*400 的矩阵
        RectF rectF = new RectF(x, y, x + 300, y + 300);
        canvas.drawArc(rectF,startAngle,sweepAngle,false,mPaintBg);
        canvas.drawArc(rectF, startAngle, progressSweepAngl, false, mPaintP);

        canvas.drawRect(rectF, mPaintR);
    }

    /**
     *  设置动画
     * @param time 动画时间
     */
    public void setProgrressNum(long time,float progressNum) {
        mCircleBarAnim.setDuration(time);
        this.currentPross = progressNum;
        this.startAnimation(mCircleBarAnim);
    }

    /**
     * 进度圈动画
     */
    public class CircleBarAnim extends Animation {


        public CircleBarAnim() {
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            progressSweepAngl = interpolatedTime*sweepAngle*currentPross/macNum;
            System.out.println("interpolatedTime =="+interpolatedTime +"progressSweepAngl=="+progressSweepAngl+"currentPross == "+currentPross);

            postInvalidate();
        }
    }
}
