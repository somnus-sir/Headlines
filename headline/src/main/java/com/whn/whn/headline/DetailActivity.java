package com.whn.whn.headline;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {

    private WebView wbDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        wbDetail = (WebView) findViewById(R.id.wb_detail);


        //设置toolBar
        toolbar.setTitle("新闻头条");
        toolbar.setTitleTextColor(Color.WHITE);


        //接受数据
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        // 启用javascript
        wbDetail.getSettings().setJavaScriptEnabled(true);

        //设置内容
        wbDetail.loadUrl(url);


        //WebView监听返回键
        wbDetail.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && wbDetail.canGoBack()) {  //表示按返回键时的操作
                        wbDetail.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
