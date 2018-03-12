package com.example.leesnriud.myactivitylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * android 全屏显示
 * 1）代码隐藏ActionBar
 * 在Activity的onCreate方法中调用getActionBar.hide();会报异常 空指针 使用getSupportActionBar
 *
 * 2）通过requestWindowFeature设置
 * requestWindowFeature(Window.FEATURE_NO_TITLE); 该代码需要在setContentView ()之前调用，不然会报错！！！
 *
 * 注： 把 requestWindowFeature(Window.FEATURE_NO_TITLE);放在super.onCreate(savedInstanceState);前面就可以隐藏ActionBar而不报错。
 *
 * 3）通过AndroidManifest.xml的theme
 * 在需要全屏的Activity的标签内设置 theme = @android:style/Theme.NoTitleBar.FullScreen
 *
 */
public class FullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getSupportActionBar().hide();

        setContentView(R.layout.activity_full);

    }
}
