package com.jude.rollviewpagerdome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpagerdome.vertical.LoopVerticalPagerAdapter;
import com.jude.rollviewpagerdome.vertical.RollVerticalPagerView;

/**
 * Created by zhuchenxi on 2016/12/13.
 */

public class LoopActivity extends AppCompatActivity {
    private RollVerticalPagerView mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        mViewPager = (RollVerticalPagerView) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ImageLoopAdapter(mViewPager));
    }

    private class ImageLoopAdapter extends LoopVerticalPagerAdapter {
        int[] imgs = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
        };

        public ImageLoopAdapter(RollVerticalPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageResource(imgs[position]);
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }
}
