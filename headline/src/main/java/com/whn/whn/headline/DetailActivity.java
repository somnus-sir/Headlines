package com.whn.whn.headline;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.wb_detail)
    WebView wbDetail;
    @Bind(R.id.container_detail)
    LinearLayout containerDetail;
    @Bind(R.id.iv_load_detail)
    ImageView ivLoadDetail;
    private RotateAnimation ra;
    private LinearInterpolator linearInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //加载中动画
        if (ra == null) {
            ra = new RotateAnimation(0, 2160, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        if (linearInterpolator == null) {
            linearInterpolator = new LinearInterpolator();
        }
        ra.setInterpolator(linearInterpolator);
        ra.setDuration(6000);
        ivLoadDetail.startAnimation(ra);


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
        wbDetail.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                ivLoadDetail.setVisibility(View.GONE);
                containerDetail.setVisibility(View.VISIBLE);
            }
        });


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
