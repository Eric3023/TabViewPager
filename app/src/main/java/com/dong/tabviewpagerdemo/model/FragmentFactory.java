package com.dong.tabviewpagerdemo.model;

import android.support.v4.app.Fragment;

import com.dong.tabviewpagerdemo.fragment.HomeFragment;
import com.dong.tabviewpagerdemo.fragment.MesseageFragment;
import com.dong.tabviewpagerdemo.fragment.MineFragment;
import com.dong.tabviewpagerdemo.fragment.TopicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dong on 2018/3/23.
 */

public class FragmentFactory {

    public static List<Fragment> createFragmentList(){

        List<Fragment> beans = new ArrayList<Fragment>();

        HomeFragment homeFragment = HomeFragment.newInstance("HOME","0");
        TopicFragment topicFragment = TopicFragment.newInstance("TOPIC","1");
        MesseageFragment messeageFragment = MesseageFragment.newInstance("MESSEAGE","2");
        MineFragment mineFragment = MineFragment.newInstance("MINE","3");

        beans.add(homeFragment);
        beans.add(topicFragment);
        beans.add(messeageFragment);
        beans.add(mineFragment);

        return beans;
    }
}
