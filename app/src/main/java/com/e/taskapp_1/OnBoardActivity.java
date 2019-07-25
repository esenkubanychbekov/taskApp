package com.e.taskapp_1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


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
