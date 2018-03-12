package com.example.leesnriud.myactivitylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android 数据传递
 * 后activity回传数据
 * 过场动画
 *
 */
public class FourthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_fourth)
    public void onViewClicked() {
        Intent intent =getIntent();
        //这里使用bundle绷带来传输数据
        Bundle bundle =new Bundle();
        //传输的内容仍然是键值对的形式
        bundle.putString("fourth","hello world from fourthActivity!");
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}
