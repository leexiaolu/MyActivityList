package com.example.leesnriud.myactivitylist;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android activity 合集
 *
 */
public class MainActivity extends BaseActivity {

    private Intent intent;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

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
                intent = new Intent(MainActivity.this,FullActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_five:
                intent = new Intent(MainActivity.this,DlgActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_six:
                intent = new Intent(MainActivity.this,CommonActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_seven:
                ActivityCollector.finishAll();
                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                // 利用handler延迟发送更改状态信息
                mHandler.sendEmptyMessageDelayed(0, 2000);
            } else {
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);}
}
