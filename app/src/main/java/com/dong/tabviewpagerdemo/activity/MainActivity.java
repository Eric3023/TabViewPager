package com.dong.tabviewpagerdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dong.tabviewpagerdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        Button btn_fragment = findViewById(R.id.btn_fragmentviewpager);
        Button btn_bottomtabfragment= findViewById(R.id.btn_bottomtabfragmentviewpager);
        Button btn_toptabfragment= findViewById(R.id.btn_toptabfragmentviewpager);

        btn_fragment.setOnClickListener(this);
        btn_bottomtabfragment.setOnClickListener(this);
        btn_toptabfragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_fragmentviewpager:
                startActivity(FragmentViewPagerActivity.class);
                break;
            case R.id.btn_bottomtabfragmentviewpager:
                startActivity(BottomTabFragmentViewPagerActivity.class);
                break;
            case R.id.btn_toptabfragmentviewpager:
                startActivity(TopTabFragmentViewPagerActivity.class);
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        mContext.startActivity(intent);
    }
}
