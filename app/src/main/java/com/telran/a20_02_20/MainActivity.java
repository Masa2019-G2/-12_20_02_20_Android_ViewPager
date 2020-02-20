package com.telran.a20_02_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.myViewPager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);


        Button prevBtn = findViewById(R.id.prevBtn);
        Button nextBtn = findViewById(R.id.nextBtn);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curr = viewPager.getCurrentItem();
                if (curr > 0) {
                    viewPager.setCurrentItem(curr - 1);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curr = viewPager.getCurrentItem();
                if (curr < viewPager.getAdapter().getCount() - 1) {
                    viewPager.setCurrentItem(curr + 1,false);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("MY_TAG", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("MY_TAG", "onPageSelected() called with: position = [" + position + "]");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.d("MY_TAG", "onPageScrollStateChanged: IDLE");
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.d("MY_TAG", "onPageScrollStateChanged: DRAGGING");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.d("MY_TAG", "onPageScrollStateChanged: SETTLING");
                        break;

                }
            }
        });


    }

    static class MyPageAdapter extends FragmentStatePagerAdapter {
        String[] names = {"Dimitrius", "Denis", "Vasya", "Anna", "Sergey", "Nikita", "Sofa", "Petya"};

        public MyPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
//            Log.d("MY_TAG", "getItem: " + position);
            return PageFragment.of(names[position]);
        }

        @Override
        public int getCount() {
            return names.length;
        }
    }
}
