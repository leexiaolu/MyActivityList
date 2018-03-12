package com.example.leesnriud.myactivitylist;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 通过log查看activity生命周期
 * activity actionbaractivity appcompatactivity 区别
 * <p>
 * actionbaractivity 过时了，5.0之后用toolbar替换
 * appcompatactivity 默认继承这个，提供了一些新的方法
 */
public class OneActivity extends BaseActivity {

    @BindView(R.id.tv_one)
    TextView tvOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        ButterKnife.bind(this);
        tvOne.setText("ActionBarActivity 已经过时了，5.0之后用toolbar替换。\n AppCompatActivity 提供了一些新的方法。");
        Log.e("activity", "OneActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("activity", "OneActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("activity", "OneActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("activity", "OneActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("activity", "OneActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("activity", "OneActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("activity", "OneActivity onRestart");
    }
}
