package com.dong.tabviewpagerdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dong.tabviewpager.widget.FragmentViewPager;
import com.dong.tabviewpagerdemo.R;
import com.dong.tabviewpagerdemo.model.FragmentFactory;

public class FragmentViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view_pager);

        FragmentViewPager fragmentViewPager = findViewById(R.id.fragmentviewpager);
        fragmentViewPager.setActivity(this)
                .setBeans(FragmentFactory.createFragmentList())
                .initialise();
    }
}
