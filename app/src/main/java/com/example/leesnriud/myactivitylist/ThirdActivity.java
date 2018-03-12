package com.example.leesnriud.myactivitylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends BaseActivity {

    @BindView(R.id.tv_third)
    TextView tvThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("third");
        int num = bundle.getInt("num");
        String name = bundle.getString("name");
        tvThird.setText("num="+num+"\n"+"name="+name);
    }
}
