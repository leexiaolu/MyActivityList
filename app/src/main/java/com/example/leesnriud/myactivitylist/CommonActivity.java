package com.example.leesnriud.myactivitylist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android 常见activity
 */
public class CommonActivity extends BaseActivity {

    private Intent intent;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_call, R.id.bt_sms, R.id.bt_sms2, R.id.bt_browser, R.id.bt_email, R.id.bt_map, R.id.bt_adds, R.id.bt_audio, R.id.bt_mp3, R.id.bt_capture, R.id.bt_image, R.id.bt_market, R.id.bt_set, R.id.bt_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_call:
                //拨打电话
                uri = Uri.parse("tel:10086");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case R.id.bt_sms:
                //发送短信
                uri = Uri.parse("smsto:10086");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Hello");
                startActivity(intent);
                break;
            case R.id.bt_sms2:
                //发送彩信（相当于发送带附件的短信）
                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra("sms_body", "Hello");
                uri = Uri.parse("content://media/external/images/media/23");
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                intent.setType("image/png");
                startActivity(intent);
                break;
            case R.id.bt_browser:
                //打开浏览器
                uri = Uri.parse("http://www.baidu.com");
                intent  = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.bt_email:
                //发送电子邮件:(阉割了Google服务的没戏!!!!)
                uri = Uri.parse("mailto:someone@domain.com");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
                break;
            case R.id.bt_map:
                //显示地图
                uri = Uri.parse("geo:39.9,116.3");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.bt_adds:
                //路径规划
                uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=39.9 116.3&daddr=31.2 121.4");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.bt_audio:
                //多媒体播放
                intent = new Intent(Intent.ACTION_VIEW);
                uri = Uri.parse("file:///sdcard/foo.mp3");
                intent.setDataAndType(uri, "audio/mp3");
                startActivity(intent);
                break;
            case R.id.bt_mp3:
                //获取SD卡下所有音频文件,然后播放第一首=-=
                uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.bt_capture:
                //打开摄像头拍照:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
                break;
            case R.id.bt_image:
                //获取并剪切图片
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra("crop", "true"); // 开启剪切
                intent.putExtra("aspectX", 1); // 剪切的宽高比为1：2
                intent.putExtra("aspectY", 2);
                intent.putExtra("outputX", 20); // 保存图片的宽和高
                intent.putExtra("outputY", 40);
                intent.putExtra("output", Uri.fromFile(new File("/mnt/sdcard/temp"))); // 保存路径
                intent.putExtra("outputFormat", "JPEG");// 返回格式
                startActivityForResult(intent, 0);
                break;
            case R.id.bt_market:
                //打开Google Market
                // 打开Google Market直接进入该程序的详细页面
                uri = Uri.parse("market://details?id=" + "com.demo.app");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.bt_set:
                // 进入无线网络设置界面
                intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                startActivityForResult(intent, 0);
                break;
            case R.id.bt_person:
                //进入联系人页面:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Contacts.People.CONTENT_URI);
                startActivity(intent);
                break;
        }
    }
}
