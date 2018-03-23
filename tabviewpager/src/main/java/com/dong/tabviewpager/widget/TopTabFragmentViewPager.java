package com.dong.tabviewpager.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by Dong on 2018/3/23.
 */

public class TopTabFragmentViewPager extends TabFragmentViewPager {

    public TopTabFragmentViewPager(@NonNull Context context) {
        super(context);
    }

    public TopTabFragmentViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TopTabFragmentViewPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void initViewPager(Context context) {
        super.initViewPager(context);
        RelativeLayout.LayoutParams lp= new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.BELOW, TABID);
        fragmentViewPager.setLayoutParams(lp);
        fragmentViewPager.setId(PAGERID);
        addView(fragmentViewPager);
    }

    @Override
    protected void initTabView() {
        super.initTabView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        bottomNavigationBar.setLayoutParams(layoutParams);
        addView(bottomNavigationBar, layoutParams);
    }
}
