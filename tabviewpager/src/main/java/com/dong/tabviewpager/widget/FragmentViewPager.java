package com.dong.tabviewpager.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;

import com.dong.tabviewpager.adapter.TabFragmentStatePagerAdapter;
import com.dong.tabviewpager.fragment.HomeFragment;
import com.dong.tabviewpager.fragment.MesseageFragment;
import com.dong.tabviewpager.fragment.MineFragment;
import com.dong.tabviewpager.fragment.TopicFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentViewPager extends ViewPager {
    private Context context;
    private AppCompatActivity activity;
    private TabFragmentStatePagerAdapter adapter;
    private List<Fragment> beans = new ArrayList<Fragment>();

    public FragmentViewPager(Context context) {
        super(context);
        this.init(context);
    }

    public FragmentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public Activity getActivity() {
        return activity;
    }

    public FragmentViewPager setActivity(AppCompatActivity activity) {
        this.activity = activity;
        return this;
    }

    public int getCount() {
        return this.beans != null?this.beans.size():0;
    }

    public List<Fragment> getBeans() {
        return this.beans;
    }

    public FragmentViewPager setBeans(List<Fragment> beans) {
        this.beans = beans;
        return this;
    }

    private void init(Context context) {
        this.context = context;

        HomeFragment homeFragment = HomeFragment.newInstance("HOME","0");
        TopicFragment topicFragment = TopicFragment.newInstance("TOPIC","1");
        MesseageFragment messeageFragment = MesseageFragment.newInstance("MESSEAGE","2");
        MineFragment mineFragment = MineFragment.newInstance("MINE","3");

        beans.add(homeFragment);
        beans.add(topicFragment);
        beans.add(messeageFragment);
        beans.add(mineFragment);
    }

    public void initialise() {

        FragmentManager fm = activity.getSupportFragmentManager();
        this.adapter = new TabFragmentStatePagerAdapter(fm, beans);
        this.setAdapter(adapter);
    }
}
