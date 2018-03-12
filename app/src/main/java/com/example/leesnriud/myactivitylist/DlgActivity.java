package com.example.leesnriud.myactivitylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class DlgActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置左上角小图标
        requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.activity_dlg);
        getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, android.R.mipmap.sym_def_app_icon);
        //设置文字:
        setTitle(R.string.actdialog_title);  //XML代码中设置:android:label="@string/activity_dialog"

    }
}
