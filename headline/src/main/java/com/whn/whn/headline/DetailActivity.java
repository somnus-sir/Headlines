package com.whn.whn.headline;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        WebView wbDetail = (WebView) findViewById(R.id.wb_detail);


        //设置toolBar
        toolbar.setTitle("新闻头条");
        toolbar.setTitleTextColor(Color.WHITE);


        //接受数据
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");


        //设置内容
        wbDetail.loadUrl(url);



    }

}
