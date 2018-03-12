package com.example.leesnriud.myactivitylist;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android activity 合集
 *
 */
public class MainActivity extends BaseActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("activity","MainActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("activity","MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("activity","MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("activity","MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("activity","MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("activity","MainActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("activity","MainActivity onRestart");
    }

    @OnClick({R.id.bt_one, R.id.bt_two, R.id.bt_three, R.id.bt_four, R.id.bt_five, R.id.bt_six, R.id.bt_seven})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_one:
                intent = new Intent(MainActivity.this,OneActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_two:
                intent = new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_three:
                intent = new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_four:
                break;
            case R.id.bt_five:
                break;
            case R.id.bt_six:
                break;
            case R.id.bt_seven:
                break;
        }
    }
}
