package com.dong.tabviewpagerdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.dong.tabviewpager.widget.BottomTabFragmentViewPager;
import com.dong.tabviewpager.widget.FragmentViewPager;
import com.dong.tabviewpagerdemo.R;
import com.dong.tabviewpagerdemo.model.FragmentFactory;

public class BottomTabFragmentViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_fragment_view_pager);

        BottomTabFragmentViewPager tabFragmentViewPager = findViewById(R.id.bottomtabfragmentviewpager);

        FragmentViewPager fragmentViewPager = tabFragmentViewPager.getFragmentViewPager();

        BottomNavigationBar bottomNavigationBar = tabFragmentViewPager.getBottomNavigationBar();

        //初始化ViewPager
        initFragmentViewPager(fragmentViewPager);
        //初始化Tab标签
        initTab(bottomNavigationBar);
    }

    private void initFragmentViewPager(FragmentViewPager fragmentViewPager) {
        fragmentViewPager.setActivity(this)//设置Fragment所在的Activity
                .setBeans(FragmentFactory.createFragmentList())//设置Fragment数据源
                .initialise();
    }

    private void initTab(BottomNavigationBar bottomNavigationBar) {
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_tab_home_selected,"主页").setInactiveIconResource(R.drawable.ic_tab_home).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_topic_selected,"主题").setInactiveIconResource(R.drawable.ic_tab_topic).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_message_selected,"消息").setInactiveIconResource(R.drawable.ic_tab_message).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_me_selected,"我的").setInactiveIconResource(R.drawable.ic_tab_me).setActiveColor(getResources().getColor(R.color.colorblue)))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();
    }
}
