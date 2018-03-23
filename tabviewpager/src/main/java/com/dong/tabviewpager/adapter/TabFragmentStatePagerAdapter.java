package com.dong.tabviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Dong on 2018/3/21.
 */

public class TabFragmentStatePagerAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> fragments;

    public TabFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments!=null&&position<fragments.size()? fragments.get(position): null;
    }

    @Override
    public int getCount() {
        return fragments!=null? fragments.size(): 0;
    }
}
