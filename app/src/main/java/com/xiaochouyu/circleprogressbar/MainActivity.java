package com.xiaochouyu.circleprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CircleBarView mCircleBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircleBarView = (CircleBarView) findViewById(R.id.cirbarview);
        mCircleBarView.setProgrressNum(5000,100);
    }
}
