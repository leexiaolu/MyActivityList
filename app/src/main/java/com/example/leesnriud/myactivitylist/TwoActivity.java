package com.example.leesnriud.myactivitylist;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Android onCreate两个参数
 * Android 启动方式 显性 隐性 通过包名
 */
public class TwoActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistableBundle) {
        super.onCreate(savedInstanceState, persistableBundle);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
    }

    /**
     * onSaveInstanceState，该方法会在以下情况被调用
     * <p>
     * 1、点击home键回到主页或长按后选择运行其他程序
     * 2、按下电源键关闭屏幕
     * 3、启动新的Activity
     * 4、横竖屏切换时，肯定会执行，因为横竖屏切换的时候会先销毁Act，然后再重新创建
     * 重要原则：当系统"未经你许可"时销毁了你的activity，则onSaveInstanceState会被系统调用，
     * 这是系统的责任，因为它必须要提供一个机会让你保存你的数据（你可以保存也可以不保存）
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * onRestoreInstanceState 该方法一般在onStart 和 onResume 之间执行
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @OnClick({R.id.bt_dominance1, R.id.bt_dominance2, R.id.bt_dominance3, R.id.bt_hidden, R.id.bt_packagename})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_dominance1:
                Toast.makeText(TwoActivity.this,"查看上级跳转方式即可",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_dominance2:
                ComponentName cn = new ComponentName("com.example.leesnriud.myactivitylist","com.example.leesnriud.myactivitylist.OneActivity") ;
                Intent intent1 = new Intent() ;
                intent1.setComponent(cn) ;
                startActivity(intent1) ;
                break;
            case R.id.bt_dominance3:
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.setClassName("com.example.leesnriud.myactivitylist","com.example.leesnriud.myactivitylist.OneActivity");
                startActivity(intent2);
                break;
            case R.id.bt_hidden:
                Intent intent3 = new Intent();
                intent3.setAction("my_action");
                intent3.addCategory("my_category");
                startActivity(intent3);
                break;
            case R.id.bt_packagename:
                Intent intent4 = getPackageManager().getLaunchIntentForPackage("com.example.leesnriud.mylistener") ;
                if(intent4 != null) startActivity(intent4) ;
                break;
        }
    }
}