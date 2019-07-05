package com.e.taskapp_1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;


public class OnBoardActivity extends AppCompatActivity {

    ViewPager viewPager;
    SectionPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        viewPager = findViewById(R.id.viewPager);
        adapter = new SectionPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }



    public class SectionPageAdapter extends FragmentPagerAdapter{

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos", i);

            BoardFragment boardFragment = new BoardFragment();
            boardFragment.setArguments(bundle);
            return boardFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
