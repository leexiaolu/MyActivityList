package com.example.leesnriud.myactivitylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * android intent 传递数据
 * 单个传递
 */
public class SecondActivity extends BaseActivity {

    @BindView(R.id.tv_second)
    TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String second = intent.getStringExtra("second");
        tvSecond.setText(second);

    }
}
