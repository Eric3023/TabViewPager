package com.dong.tabviewpager.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by Dong on 2018/3/13.
 */

public class TabFragmentViewPager extends RelativeLayout {

    protected Context context;
    protected FragmentViewPager fragmentViewPager;
    protected BottomNavigationBar bottomNavigationBar;

    public TabFragmentViewPager(@NonNull Context context) {
        super(context);
        init(context);
    }

    public TabFragmentViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabFragmentViewPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    protected void init(Context context) {
        this.context = context;
        initTabView();
        initViewPager(context);
    }

    /*
     * 初始化LoopViewPager
     */
    @android.support.annotation.IdRes
    int PAGERID = 1001;
    protected void initViewPager(Context context) {
        fragmentViewPager =  new FragmentViewPager(context);
        fragmentViewPager.setId(PAGERID);
        fragmentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(bottomNavigationBar!=null && position >= 0){
                    bottomNavigationBar.selectTab(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*
     * 初始化TAB标签
     */
    @android.support.annotation.IdRes
    int TABID = 1000;
    protected void initTabView() {
        bottomNavigationBar = new BottomNavigationBar(context);
        bottomNavigationBar.setId(TABID);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                if(fragmentViewPager!=null && position >= 0 && position < fragmentViewPager.getCount()){
                    fragmentViewPager.setCurrentItem(position , false);
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    public FragmentViewPager getFragmentViewPager() {
        return fragmentViewPager;
    }

    public BottomNavigationBar getBottomNavigationBar() {
        return bottomNavigationBar;
    }
}
