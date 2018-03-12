package com.example.leesnriud.myactivitylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android 数据传递
 * 一个个传递
 * 多个传递
 */
public class FirstActivity extends BaseActivity {

    private Intent intent;

    @BindView(R.id.bt_fourth)
    Button btFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_second, R.id.bt_third,R.id.bt_fourth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_second:
                intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("second","单个传递");
                startActivity(intent);
                break;
            case R.id.bt_third:
                intent = new Intent(FirstActivity.this,ThirdActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("num",123);
                bundle.putString("name","leesnriud");
                intent.putExtra("third",bundle);
                startActivity(intent);
                break;
            case R.id.bt_fourth:
                intent =new Intent(FirstActivity.this,FourthActivity.class);
                startActivityForResult(intent,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0 && resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            String text =null;
            if(bundle!=null)
                text=bundle.getString("fourth");
                btFourth.setText(text);
        }
    }
}
