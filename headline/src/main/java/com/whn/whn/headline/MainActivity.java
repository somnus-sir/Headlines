package com.whn.whn.headline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.whn.whn.headline.factory.FragmentFactory;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 加载具体页面的item
 */
public class MainActivity extends AppCompatActivity {
    public static final String[] typeNames = new String[]{"头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"};
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("新闻头条");
        toolbar.setTitleTextColor(Color.WHITE);

        //设置Viewpager
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        vp.setAdapter(pagerAdapter);

        //关联指针
        tabLayout.setupWithViewPager(vp);
    }

    /**
     * Adapter
     */
    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //根据创建Fragment
        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return typeNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return typeNames[position];
        }
    }


}
