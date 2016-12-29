package com.whn.whn.headline.factory;


import android.support.v4.app.Fragment;

import com.whn.whn.headline.fragment.AllFragment;

import java.util.HashMap;

/**
 * Created by whn on 2016/12/3.
 */

public class FragmentFactory {
    public static final String[] types = new String[]{"top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"};
    public static HashMap<Integer, Fragment> hashMap = new HashMap<>();

    public static Fragment createFragment(int position) {
        Fragment fragment = null;
        fragment = hashMap.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new AllFragment(types[position]);
                    break;
                case 1:
                    fragment = new AllFragment(types[position]);
                    break;
                case 2:
                    fragment = new AllFragment(types[position]);
                    break;
                case 3:
                    fragment = new AllFragment(types[position]);
                    break;
                case 4:
                    fragment = new AllFragment(types[position]);
                    break;
                case 5:
                    fragment = new AllFragment(types[position]);
                    break;
                case 6:
                    fragment = new AllFragment(types[position]);
                    break;
                case 7:
                    fragment = new AllFragment(types[position]);
                    break;
                case 8:
                    fragment = new AllFragment(types[position]);
                    break;
                case 9:
                    fragment = new AllFragment(types[position]);
                    break;
            }
            hashMap.put(position, fragment);
        }
        return fragment;
    }

}
